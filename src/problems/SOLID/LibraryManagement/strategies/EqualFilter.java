package problems.SOLID.LibraryManagement.strategies;

import problems.SOLID.LibraryManagement.bookfilter.FilterLogic;
import problems.SOLID.LibraryManagement.entities.Book;

import java.util.ArrayList;
import java.util.List;

public class EqualFilter implements FilterStrategy<Book> {
	@Override
	public List<Book> applyFilter(FilterLogic logic, Book[] item) {
		List<Book> books = new ArrayList<>();
		for(Book book:item){
			if(book.getTitle().equals(logic.getValue()))
				books.add(book);
		}
		return books;
	}
}
