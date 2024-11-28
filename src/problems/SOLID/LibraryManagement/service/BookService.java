package problems.SOLID.LibraryManagement.service;

import problems.SOLID.LibraryManagement.Book;
import problems.SOLID.LibraryManagement.FilterKey;

import java.io.IOException;

/**
 * will handle things related to service
 */
public interface BookService {
    // we will use Book object as input as the service will only add book i.e persist
    void add(Book book) throws IOException;

    // find a book
    Book[] findBy(FilterKey key,String pattern);
}
