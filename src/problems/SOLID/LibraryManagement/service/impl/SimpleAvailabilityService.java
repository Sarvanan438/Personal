package problems.SOLID.LibraryManagement.service.impl;

import problems.SOLID.LibraryManagement.dto.Availability;
import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.repositories.BookRepository;
import problems.SOLID.LibraryManagement.service.AvailabilityService;

import java.util.List;

public class SimpleAvailabilityService implements AvailabilityService {


	public SimpleAvailabilityService() {

	}

	@Override
	public Availability createAvailability(List<Book> books) {
		return new Availability(books.stream().filter(book->!book.isBorrowed()).toList());
	}
}
