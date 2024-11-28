package problems.SOLID.LibraryManagement.repositories;

import problems.SOLID.LibraryManagement.Book;
import problems.SOLID.LibraryManagement.FilterKey;
import problems.SOLID.LibraryManagement.bookfilter.BookFilter;
import problems.SOLID.LibraryManagement.bookfilter.BookFilterFactory;
import problems.SOLID.LibraryManagement.persistence.Persistence;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The respository is responsible for working with the persistence layer to
 * transform or query information
 */
public class SimpleBookRepository implements BookRepository {
    Persistence<Book> filePersistence ;
    public SimpleBookRepository(Persistence<Book> filePersistence){
        this.filePersistence=filePersistence;
    }

    @Override
    public Book[] findBy(FilterKey key, String pattern) {
        Book[] books =this.filePersistence.findAll();
        BookFilter filter = BookFilterFactory.createBookFilter(key);
        return filter.find(new ArrayList<>(List.of(books)),pattern);
    }

    @Override
    public void add(Book book) throws IOException {
        this.filePersistence.insert(book);
    }
}
