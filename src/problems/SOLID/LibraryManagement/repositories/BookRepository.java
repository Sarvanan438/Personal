package problems.SOLID.LibraryManagement.repositories;

import problems.SOLID.LibraryManagement.Book;
import problems.SOLID.LibraryManagement.FilterKey;
import problems.SOLID.LibraryManagement.bookfilter.FilterCriteria;

public interface BookRepository extends Repository<Book> {

    Book[] findBy(FilterCriteria filterCriteria);
}
