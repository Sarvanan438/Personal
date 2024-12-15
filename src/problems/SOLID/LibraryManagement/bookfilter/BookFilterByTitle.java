package problems.SOLID.LibraryManagement.bookfilter;

import problems.SOLID.LibraryManagement.Conditions;
import problems.SOLID.LibraryManagement.FilterKey;
import problems.SOLID.LibraryManagement.entities.Book;

import java.util.ArrayList;
import java.util.List;


public class BookFilterByTitle implements BookFilter{

    private FilterKey filterKey;
    private Conditions condition;

    public BookFilterByTitle(FilterKey filterKey, Conditions condition) {
        this.filterKey = filterKey;
        this.condition = condition;
    }

    @Override
    public FilterLogic createFilter( FilterCriteria filterCriteria) throws IllegalArgumentException{
        String filterPattern = filterCriteria.getFilters().get(this.filterKey);
        if( filterPattern==null)
            throw new IllegalArgumentException("No filter speicified for title");
        return new FilterLogic("title", this.condition,filterPattern);
    }
}
