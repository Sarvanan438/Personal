package problems.SOLID.LibraryManagement.strategies;

import problems.SOLID.LibraryManagement.bookfilter.FilterLogic;

import java.util.List;

public interface FilterStrategy<T> {
	List<T> applyFilter(FilterLogic logic, T[]item);
}
