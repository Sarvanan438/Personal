package problems.SOLID.LibraryManagement.service.impl;

import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.entities.Borrow;
import problems.SOLID.LibraryManagement.entities.User;
import problems.SOLID.LibraryManagement.factories.borrow.BorrowFactory;
import problems.SOLID.LibraryManagement.repositories.BorrowRepository;
import problems.SOLID.LibraryManagement.serializer.Serializer;
import problems.SOLID.LibraryManagement.service.BookService;
import problems.SOLID.LibraryManagement.service.BorrowService;
import problems.SOLID.LibraryManagement.service.UserService;

public class SimpleBorrowService implements BorrowService {

	private BorrowRepository borrowRepository;
	private BookService bookService;
	private UserService userService;

	public SimpleBorrowService(BorrowRepository borrowRepository, BookService bookService, UserService userService) {
		this.borrowRepository = borrowRepository;
		this.bookService = bookService;
		this.userService = userService;
	}

	@Override
	public Borrow borrowBook(String userId, String bookId) throws Exception {
		Book book = this.bookService.getBookById(bookId);
		User user = this.userService.getUserById(userId);
		if(this.getActiveBorrowByBook(bookId)!=null)
			throw new Exception("Book not available");
		Borrow borrow=BorrowFactory.createBorrow(user,book,15);
		return this.borrowRepository.add(borrow);
	}

	@Override
	public Borrow returnBook(String bookId) throws Exception {

		Borrow borrow = this.getActiveBorrowByBook(bookId);
		if(borrow ==null) throw new Exception("Book not borrowed");
		borrow.returnBook();
		this.borrowRepository.update(borrow);
		return borrow;
	}

	@Override
	public Borrow getActiveBorrowByBook(String bookId) {
		Book book = this.bookService.getBookById(bookId);
		return this.borrowRepository.findActiveBorrowByBook(book);
	}

	@Override
	public Borrow[] getActiveBorrowByUser(String  userId) {
		User user = this.userService.getUserById(userId);
		return this.borrowRepository.findActiveBorrowsByUser(user);
	}
}
