package problems.SOLID.LibraryManagement.repositories;

import problems.SOLID.LibraryManagement.bookfilter.FilterCriteria;
import problems.SOLID.LibraryManagement.dto.Availability;
import problems.SOLID.LibraryManagement.entities.Book;

import java.util.List;

public class SimpleAvailabilityRepository implements AvailablilityRepository{
	private BookRepository bookRepository;

	public SimpleAvailabilityRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public Availability findBookAvailabilityByTitle(FilterCriteria filterCriteria) throws Exception {
		Book[] books = this.bookRepository.findBy(filterCriteria);
		return new Availability(List.of(books));
	}
}
