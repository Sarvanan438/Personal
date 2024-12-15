package problems.SOLID.LibraryManagement.service;

import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.entities.Borrow;
import problems.SOLID.LibraryManagement.entities.User;

public interface BorrowService {
	Borrow borrowBook(User user, Book book) throws Exception;
	Borrow returnBook(Book book) throws Exception;
	Borrow getActiveBorrowByBook(Book book);
	Borrow[] getActiveBorrowByUser(User user);
}
