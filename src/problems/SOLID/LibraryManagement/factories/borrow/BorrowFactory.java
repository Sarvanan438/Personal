package problems.SOLID.LibraryManagement.factories.borrow;

import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.entities.Borrow;
import problems.SOLID.LibraryManagement.entities.User;
import problems.SOLID.LibraryManagement.utilities.impl.UUIDUtils;

import java.time.LocalDate;
import java.util.Date;

public class BorrowFactory {

	public static Borrow createBorrow(User user, Book book, int noOfDaysDue){
		return new Borrow(UUIDUtils.generateUUID(),user,book, LocalDate.now(),noOfDaysDue);
	}
}
