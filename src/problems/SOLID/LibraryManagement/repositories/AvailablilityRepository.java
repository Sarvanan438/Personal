package problems.SOLID.LibraryManagement.repositories;

import problems.SOLID.LibraryManagement.bookfilter.FilterCriteria;
import problems.SOLID.LibraryManagement.dto.Availability;

public interface AvailablilityRepository {
	Availability findBookAvailabilityByTitle(FilterCriteria filterCriteria) throws Exception;
}
