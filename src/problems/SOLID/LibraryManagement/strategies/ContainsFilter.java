package problems.SOLID.LibraryManagement.strategies;

import problems.SOLID.LibraryManagement.bookfilter.FilterLogic;

public interface ContainsFilter<T> {
	boolean doesContain(T o1, FilterLogic logic);
}
