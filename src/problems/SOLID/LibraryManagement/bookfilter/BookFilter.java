package problems.SOLID.LibraryManagement.bookfilter;

import problems.SOLID.LibraryManagement.Book;

import java.util.List;

public interface BookFilter {
    Book[] find(List<Book> books, String pattern);
}
