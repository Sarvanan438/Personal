package problems.SOLID.LibraryManagement.bookfilter;

import problems.SOLID.LibraryManagement.Book;

import java.util.List;

/**
 * This tightly couples the find method to list of books , this might not be viable in all cases
 * we can let the book implementation handle how to filter and find ,it may delegate
 * So its better to only use the pattern and make the bookfilter monadic
 * How to fetch the books can be through constructor or other fetch methods
 * BookFilter will filter the books ,what and which books will be differenc
 * Because we can just use bookfilter to create a filterCriteria which the repository can handle
 */
public interface BookFilter {
    Book[] find(List<Book> books, String pattern);
}
