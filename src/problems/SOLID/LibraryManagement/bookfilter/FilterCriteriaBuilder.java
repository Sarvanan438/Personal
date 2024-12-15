package problems.SOLID.LibraryManagement.bookfilter;

import problems.SOLID.LibraryManagement.FilterKey;

import java.util.concurrent.locks.Condition;

public interface FilterCriteriaBuilder {
    FilterCriteriaBuilder addFilterByTitle(String pattern);
    FilterCriteriaBuilder caseSensitive();
    FilterCriteriaBuilder caseInsensitive();
    FilterCriteriaBuilder clear();
    FilterCriteria getFilterCriteria();
    FilterCriteriaBuilder addFilter(FilterKey key, String pattern);
}
