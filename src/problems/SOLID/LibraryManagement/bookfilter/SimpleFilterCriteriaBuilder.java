package problems.SOLID.LibraryManagement.bookfilter;

import problems.SOLID.LibraryManagement.FilterKey;

import java.util.HashMap;
import java.util.Map;

public class SimpleFilterCriteriaBuilder implements FilterCriteriaBuilder{
    private final Map<FilterKey, String> filters = new HashMap<>();
    private boolean isCaseSensitive=false;




    public FilterCriteria getFilterCriteria() {
        if (filters.isEmpty()) {
            throw new IllegalStateException("At least one filter must be specified");
        }
        return new FilterCriteria(filters,this.isCaseSensitive);
    }
    @Override
    public FilterCriteriaBuilder addFilterByTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title filter cannot be null or empty");
        }
        filters.put(FilterKey.TITLE, title);
        return this;
    }

    @Override
    public FilterCriteriaBuilder caseSensitive() {
         this.isCaseSensitive=true;
         return this;
    }

    @Override
    public FilterCriteriaBuilder caseInsensitive() {
        this.isCaseSensitive=false;
        return this;
    }

    @Override
    public FilterCriteriaBuilder clear() {
        this.filters.clear();
        this.caseInsensitive();
        return this;
    }


}
