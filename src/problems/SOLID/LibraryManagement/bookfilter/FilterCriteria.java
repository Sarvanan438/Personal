package problems.SOLID.LibraryManagement.bookfilter;

import problems.SOLID.LibraryManagement.FilterKey;

import java.util.HashMap;
import java.util.Map;

public class FilterCriteria {

    private final Map<FilterKey,String> filters ;
    private boolean isCaseSensitive=false;

    public FilterCriteria(Map<FilterKey, String> filters, boolean isCaseSensitive) {
        this.filters = filters;
        this.isCaseSensitive = isCaseSensitive;
    }

    public boolean isCaseSensitive() {
        return isCaseSensitive;
    }




    public Map<FilterKey, String> getFilters() {
        return filters;
    }


}
