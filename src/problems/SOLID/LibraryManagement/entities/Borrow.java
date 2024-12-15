package problems.SOLID.LibraryManagement.entities;

import problems.SOLID.LibraryManagement.utilities.impl.DateUtils;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

public class Borrow implements Id {
	// may be have a object for id if the type changes in future
	private Id borrowId,bookId,userId;

	private final LocalDate borrowedDate;
	LocalDate returnedDate;
	private final int noOfDaysToDue;

	public Borrow(Id borrowId,Id userId, Id bookId, LocalDate borrowedDate, int noOfDaysToDue) {
		this.borrowId=borrowId;
		this.bookId = bookId;
		this.userId = userId;
		this.borrowedDate = borrowedDate;
		this.noOfDaysToDue = noOfDaysToDue;
	}

	public void returnBook() throws IllegalAccessException {
		if(this.isBookReturned()) throw new IllegalAccessException("Book already returned on "+this.returnedDate.toString());
		this.returnedDate = LocalDate.now();
	}

	public boolean isBookReturned(){
		return this.returnedDate!=null;
	}
	public Date getDueDate(){
		return DateUtils.addDays(Date.from(this.borrowedDate.atStartOfDay().toInstant(ZoneOffset.UTC)),this.noOfDaysToDue);
	}

	public Id getUserId() {
		return this.userId;
	}

	public Id getBookId() {
		return bookId;
	}

	public LocalDate getBorrowedDate() {
		return borrowedDate;
	}

	@Override
	public String getId() {
		return this.borrowId.getId();
	}

	@Override
	public void setId(String id) {
		this.borrowId.setId(id);
	}
	@Override
	public boolean isEqual(Id id) {
		return this.borrowId.isEqual(id);
	}

	public LocalDate getReturnedDate() {
		return returnedDate;
	}

	public int getNoOfDaysToDue() {
		return noOfDaysToDue;
	}

	public void setReturnedDate(LocalDate returnedDate) {
		this.returnedDate = returnedDate;
	}

	@Override
	public String toString() {
		return "Borrow{" +
				"borrowId=" + borrowId.getId() +
				", bookId=" + bookId.getId() +
				", userId=" + userId.getId() +
				", borrowedDate=" + borrowedDate +
				", returnedDate=" + returnedDate +
				", noOfDaysToDue=" + noOfDaysToDue +
				'}';
	}
}
