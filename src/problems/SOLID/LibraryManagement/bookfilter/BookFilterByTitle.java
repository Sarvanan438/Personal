package problems.SOLID.LibraryManagement.bookfilter;

import problems.SOLID.LibraryManagement.Conditions;
import problems.SOLID.LibraryManagement.FilterKey;
import problems.SOLID.LibraryManagement.entities.Book;

import java.util.ArrayList;
import java.util.List;


public class BookFilterByTitle implements BookFilter{

    @Override
    public FilterLogic createFilter( FilterCriteria filterCriteria) throws IllegalArgumentException{
        String filterPattern = filterCriteria.getFilters().get(FilterKey.TITLE);
        if( filterPattern==null)
            throw new IllegalArgumentException("No filter speicified for title");
        return new FilterLogic("title", Conditions.CONTAINS,filterPattern);
    }
}
