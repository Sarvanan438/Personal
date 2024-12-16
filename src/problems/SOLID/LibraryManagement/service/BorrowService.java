package problems.SOLID.LibraryManagement.service;

import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.entities.Borrow;
import problems.SOLID.LibraryManagement.entities.User;

public interface BorrowService {
	Borrow borrowBook(String userId, String bookId) throws Exception;
	Borrow returnBook(String bookId) throws Exception;
	Borrow getActiveBorrowByBook(String bookId);
	Borrow[] getActiveBorrowByUser(String userId);
}
