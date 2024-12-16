package problems.SOLID.LibraryManagement.strategies;

import problems.SOLID.LibraryManagement.FilterKey;
import problems.SOLID.LibraryManagement.bookfilter.FilterLogic;
import problems.SOLID.LibraryManagement.entities.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookAvailabilityFilter implements FilterStrategy<Book> {
	@Override
	public List<Book> applyFilter(FilterLogic logic, Book[] item) {
		String property = logic.getProperty();
		if(!property.equals(FilterKey.AVAILABILITY.toString()))
			return new ArrayList<>();
		return Arrays.stream(item).filter(book-> !book.isBorrowed() && book.getTitle().equals(logic.getValue())).toList();
	}
}
