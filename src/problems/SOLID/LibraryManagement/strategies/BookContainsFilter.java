package problems.SOLID.LibraryManagement.strategies;

import problems.SOLID.LibraryManagement.bookfilter.FilterLogic;
import problems.SOLID.LibraryManagement.entities.Book;

public class BookContainsFilter implements ContainsFilter<Book>
{
	;

	public BookContainsFilter() {

	}

	@Override
	public boolean doesContain(Book o1, FilterLogic logic) {

		return this.getProperty(logic.getProperty(),o1).contains(logic.getValue());
	}

	public String getProperty(String property, Book book){
		switch (property){
			case "title":
				return book.getTitle();
			default:
				throw new IllegalArgumentException();
		}

	}
}
