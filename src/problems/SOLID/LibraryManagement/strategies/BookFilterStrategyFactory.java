package problems.SOLID.LibraryManagement.strategies;

import problems.SOLID.LibraryManagement.bookfilter.FilterLogic;

import static problems.SOLID.LibraryManagement.Conditions.CONTAINS;

public class BookFilterStrategyFactory {

	public FilterStrategy createFilterStrategy(FilterLogic logic){
		switch (logic.getCondition()){
			case  CONTAINS:
				return new ContainsFilterStrategy(new BookContainsFilter());
			case  EQUAL:
				return new EqualFilter();
		}
		throw new IllegalArgumentException("No such filter available");
	}
}
