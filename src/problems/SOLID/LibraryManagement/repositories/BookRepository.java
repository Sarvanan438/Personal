package problems.SOLID.LibraryManagement.repositories;

import problems.SOLID.LibraryManagement.Book;
import problems.SOLID.LibraryManagement.FilterKey;

public interface BookRepository extends Repository<Book> {

    Book[] findBy(FilterKey key, String pattern);
}
