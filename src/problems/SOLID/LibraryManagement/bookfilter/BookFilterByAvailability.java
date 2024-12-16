package problems.SOLID.LibraryManagement.bookfilter;

import problems.SOLID.LibraryManagement.Conditions;
import problems.SOLID.LibraryManagement.FilterKey;

public class BookFilterByAvailability implements BookFilter{
	@Override
	public FilterLogic createFilter(FilterCriteria filterCriteria) throws IllegalArgumentException {
		if(!filterCriteria.getFilters().containsKey(FilterKey.AVAILABILITY))
			throw new IllegalArgumentException("No such filter available");
		String pattern = filterCriteria.getFilters().get(FilterKey.AVAILABILITY);
		return new FilterLogic(FilterKey.AVAILABILITY.toString(), Conditions.EQUAL,pattern);
	}
}
