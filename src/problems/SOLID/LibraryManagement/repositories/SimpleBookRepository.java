package problems.SOLID.LibraryManagement.repositories;

import problems.SOLID.LibraryManagement.bookfilter.FilterLogic;
import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.FilterKey;
import problems.SOLID.LibraryManagement.bookfilter.BookFilter;
import problems.SOLID.LibraryManagement.bookfilter.BookFilterFactory;
import problems.SOLID.LibraryManagement.bookfilter.FilterCriteria;
import problems.SOLID.LibraryManagement.entities.Id;
import problems.SOLID.LibraryManagement.persistence.Persistence;
import problems.SOLID.LibraryManagement.serializer.Serializer;
import problems.SOLID.LibraryManagement.strategies.BookFilterStrategyFactory;
import problems.SOLID.LibraryManagement.strategies.FilterStrategy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * The respository is responsible for working with the persistence layer to
 * transform or query information
 *
 * The book repository is abstracted well as in the first iteration after
 * change in file persistence from moving the serializer to repository as its the responsbility of repository
 * the changes are only needed in the repository file
 *
 * The contract changes to changes are needed here no other possibility but the classes using this doesn't
 * have to know this chnage
 */
public class SimpleBookRepository implements BookRepository {
    Persistence<Book> filePersistence ;
    Serializer<Book> bookSerializer;
    public SimpleBookRepository(Persistence<Book> filePersistence,Serializer<Book> bookSerializer){
        this.filePersistence=filePersistence;
        this.bookSerializer = bookSerializer;
    }

    private String serializeBook(Book book){
        return this.bookSerializer.serialize(book);
    }
    private Book[] getAllBooks() throws FileNotFoundException {
        String[] bookEntries = this.filePersistence.findAll();
        Book[] books = Arrays.stream(bookEntries).map(entry->this.bookSerializer.deserialize(entry)).toList().toArray(new Book[]{});
        return books;
    }
    @Override
    public Book[] findBy(FilterCriteria filterCriteria) throws FileNotFoundException {
//          Contract change and first iteration
//        Book[] books =this.filePersistence.findAll();
        /**
         * According to CC and SRP a code unit should be responsbile for one thing
         * here the function should be respsonbile for filtering books by the filter passed
         * So getting the books and converting to domain entity is not part of this unit but
         * specialized unit getAllBooks as converting to domain entity is resposibility of repo
         */

        Book[] books = getAllBooks();
        BookFilter filter = BookFilterFactory.createBookFilter(FilterKey.COMPOSITE);
        FilterLogic logic = filter.createFilter(filterCriteria);
        return this.filterBooks(logic,books);

    }

    private Book[] filterBooks(FilterLogic logic, Book[] books){
        Book[] filteredBooks =books;
        FilterLogic currentFilterLogic = logic;
        while (currentFilterLogic !=null){
            filteredBooks = this.applyFilterLogic(currentFilterLogic,books);
            currentFilterLogic = currentFilterLogic.nextFilterLogic();
        }
        return filteredBooks;
    }

    private Book[] applyFilterLogic(FilterLogic logic,Book[] books){
        FilterStrategy<Book> filterStrategy = new BookFilterStrategyFactory().createFilterStrategy(logic);
        return  filterStrategy.applyFilter(logic,books).toArray(new Book[]{});

    }
    @Override
    public Book add(Book book) throws IOException {
        this.filePersistence.insert(this.serializeBook(book));
        return book;
    }

    @Override
    public Book findById(Id id) {
        try {
          Book[] books = this.getAllBooks();
          for(Book book:books)
          {
              if(book.isEqual(id)) return book;
          }
        }catch (Exception e){

        }
        return null;

    }
}
