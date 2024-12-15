package problems.SOLID.LibraryManagement.dto;

import problems.SOLID.LibraryManagement.entities.Book;

public class Availability {
	Book book;
	private int availableCopies;

	public Availability(Book book, int availableCopies) {
		this.book = book;
		this.availableCopies = availableCopies;
	}

	public Book getBook() {
		return book;
	}

	public int getAvailableCopies() {
		return availableCopies;
	}

	public boolean isCopyAvailable(){
		return this.getAvailableCopies()>0;
	}

}
