package problems.SOLID.LibraryManagement.service;

import problems.SOLID.LibraryManagement.dto.Availability;
import problems.SOLID.LibraryManagement.entities.Book;

import java.util.List;

public interface AvailabilityService {
	Availability createAvailability(List<Book> books);
}
