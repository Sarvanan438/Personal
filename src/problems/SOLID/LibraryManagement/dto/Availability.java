package problems.SOLID.LibraryManagement.dto;

import problems.SOLID.LibraryManagement.entities.Book;

import java.util.List;

public class Availability {


	List<Book> availableCopies;

	public Availability(List<Book> availableCopies) {
		this.availableCopies = availableCopies;
	}

	public Book getBook() {
		return availableCopies.size()>0 ?availableCopies.get(0):null;
	}

	public int getAvailableCopies() {
		return availableCopies.size();
	}

	public boolean isCopyAvailable(){
		return this.getAvailableCopies()>0;
	}

	public Book[] getAvailableBooks(){
		return this.availableCopies.toArray(new Book[]{});
	}

}
