package problems.SOLID.LibraryManagement.bookfilter;

import problems.SOLID.LibraryManagement.FilterKey;

public class CompositeFilter implements BookFilter{
	@Override
	public FilterLogic createFilter(FilterCriteria filterCriteria) throws IllegalArgumentException {
		FilterLogic logic = null;
		for(FilterKey key : filterCriteria.getFilters().keySet()){
			FilterLogic currentFilterLogic = BookFilterFactory.createBookFilter(key).createFilter(filterCriteria);
			if(logic==null) logic=currentFilterLogic;
			else {
				logic.setNextFilterLogic(currentFilterLogic);
				logic=currentFilterLogic;
			}
		}
		return logic;
	}
}
