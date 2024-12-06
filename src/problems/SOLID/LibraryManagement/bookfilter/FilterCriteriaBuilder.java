package problems.SOLID.LibraryManagement.bookfilter;

public interface FilterCriteriaBuilder {
    FilterCriteriaBuilder addFilterByTitle(String pattern);
    FilterCriteriaBuilder caseSensitive();
    FilterCriteriaBuilder caseInsensitive();
    FilterCriteriaBuilder clear();
    FilterCriteria getFilterCriteria();
}
