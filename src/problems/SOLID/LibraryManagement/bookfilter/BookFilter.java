package problems.SOLID.LibraryManagement.bookfilter;

import problems.SOLID.LibraryManagement.entities.Book;

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
    /**
     * Moving to FilterCriteria as input
     * as book filter isn't just about creating filter on just a pattern
     * it may be data ranges or anthing of that type
     * filterCriteria is basically a dto to carry the filter condition which will be translated into the
     * filter logic based on the condition which the data access can understand
     *
     * FilterLogic will be returned to the caller as FilterLogic will be a simplified encapsulation
     * The creates an abstraction on how queries can be translated
     * The repository/caller is responsible for translating these commands into queries the data source understands
     */
    FilterLogic createFilter(FilterCriteria filterCriteria) throws IllegalArgumentException;
}
