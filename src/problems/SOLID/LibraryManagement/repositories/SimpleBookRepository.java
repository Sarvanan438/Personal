package problems.SOLID.LibraryManagement.repositories;

import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.FilterKey;
import problems.SOLID.LibraryManagement.bookfilter.BookFilter;
import problems.SOLID.LibraryManagement.bookfilter.BookFilterFactory;
import problems.SOLID.LibraryManagement.bookfilter.FilterCriteria;
import problems.SOLID.LibraryManagement.persistence.Persistence;
import problems.SOLID.LibraryManagement.serializer.Serializer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    @Override
    public Book[] findBy(FilterCriteria filterCriteria) throws FileNotFoundException {
//          Contract change and first iteration
//        Book[] books =this.filePersistence.findAll();
        String[] bookEntries = this.filePersistence.findAll();
        Book[] books = Arrays.stream(bookEntries).map(entry->this.bookSerializer.deserialize(entry)).toList().toArray(new Book[]{});
        for(FilterKey key: filterCriteria.getFilters().keySet()) {
            BookFilter filter = BookFilterFactory.createBookFilter(key);
            books=filter.find(new ArrayList<>(List.of(books)),filterCriteria.getFilters().get(key));
        }
        return books;
    }

    @Override
    public void add(Book book) throws IOException {
        this.filePersistence.insert(this.serializeBook(book));
    }
}
