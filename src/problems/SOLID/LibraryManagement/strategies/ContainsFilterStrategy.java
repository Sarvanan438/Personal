package problems.SOLID.LibraryManagement.strategies;

import problems.SOLID.LibraryManagement.bookfilter.FilterLogic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContainsFilterStrategy<T> implements FilterStrategy<T>{

	private ContainsFilter<T> containsFilter;

	public ContainsFilterStrategy(ContainsFilter<T> containsFilter) {
		this.containsFilter = containsFilter;
	}

	@Override
	public List<T> applyFilter(FilterLogic logic, T[] items) {
		List<T> filteredResult = new ArrayList<>();
		for(T item:items) {
			if(this.containsFilter.doesContain(item,logic))
				filteredResult.add(item);
		}
		return filteredResult;
	}
}
