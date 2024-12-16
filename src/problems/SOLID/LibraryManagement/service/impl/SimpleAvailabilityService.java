package problems.SOLID.LibraryManagement.service.impl;

import problems.SOLID.LibraryManagement.FilterKey;
import problems.SOLID.LibraryManagement.bookfilter.FilterCriteria;
import problems.SOLID.LibraryManagement.bookfilter.FilterCriteriaBuilder;
import problems.SOLID.LibraryManagement.dto.Availability;
import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.repositories.AvailablilityRepository;
import problems.SOLID.LibraryManagement.repositories.BookRepository;
import problems.SOLID.LibraryManagement.service.AvailabilityService;

import java.util.List;

public class SimpleAvailabilityService implements AvailabilityService {


	private AvailablilityRepository availablilityRepository;

	private FilterCriteriaBuilder filterCriteriaBuilder;
	public SimpleAvailabilityService(AvailablilityRepository availablilityRepository, FilterCriteriaBuilder filterCriteriaBuilder) {
		this.availablilityRepository = availablilityRepository;
		this.filterCriteriaBuilder=filterCriteriaBuilder;
	}

	@Override
	public Availability createAvailability(String title) throws Exception {
		FilterCriteria filterCriteria=this.filterCriteriaBuilder.addFilter(FilterKey.AVAILABILITY,title).getFilterCriteria();
		return this.availablilityRepository.findBookAvailabilityByTitle(filterCriteria);
	}
}
