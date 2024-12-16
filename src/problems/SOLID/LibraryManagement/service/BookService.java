package problems.SOLID.LibraryManagement.service;

import problems.SOLID.LibraryManagement.dto.Availability;
import problems.SOLID.LibraryManagement.dto.BookDTO;
import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.bookfilter.FilterCriteria;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * will handle things related to service
 */
public interface BookService {
    // we will use Book object as input as the service will only add book i.e persist
    Book add(BookDTO bookDTO) throws IOException;

    // find a book
    /**
     * Old implemmentation used the caller to know implementation details and
     * control filter by key . this causes issue when we need to change filter details in service and discard
     * the enum for btter object oriented way
     * And also Clean code suggests no param function is better
     *
     * The only benefit was we can add new functionalities like by ISBN etc without the caller changing majorly
     * but this makes the book service like a hybrid of ds and object as it exposes internal implementation
     */
    // old: Book[] findBy(FilterKey key,String pattern);

    /**
     * Let use a filter criteria class
     * the class helps keep the method signature same and just use the class as a DS to pass data
     * we can even use a builder to build the class
     */

    Book[] filterBy(FilterCriteria filterCriteria) throws FileNotFoundException;
    Book getBookById(String id);
    Availability getBooksAvailability(String title) throws Exception;
    Book[] getAvailableBookByTitle(String title);
}
