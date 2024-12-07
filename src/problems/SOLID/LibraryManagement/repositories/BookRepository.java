package problems.SOLID.LibraryManagement.repositories;

import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.bookfilter.FilterCriteria;

import java.io.FileNotFoundException;

public interface BookRepository extends Repository<Book> {

    Book[] findBy(FilterCriteria filterCriteria) throws FileNotFoundException;
}
