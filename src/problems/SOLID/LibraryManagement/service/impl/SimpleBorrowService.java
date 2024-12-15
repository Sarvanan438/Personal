package problems.SOLID.LibraryManagement.service.impl;

import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.entities.Borrow;
import problems.SOLID.LibraryManagement.entities.User;
import problems.SOLID.LibraryManagement.factories.borrow.BorrowFactory;
import problems.SOLID.LibraryManagement.repositories.BorrowRepository;
import problems.SOLID.LibraryManagement.serializer.Serializer;
import problems.SOLID.LibraryManagement.service.BorrowService;

public class SimpleBorrowService implements BorrowService {

	private BorrowRepository borrowRepository;

	public SimpleBorrowService( BorrowRepository borrowRepository) {

		this.borrowRepository = borrowRepository;
	}

	@Override
	public Borrow borrowBook(User user, Book book) throws Exception {

		if(this.getActiveBorrowByBook(book)!=null)
			throw new Exception("Book not available");
		Borrow borrow=BorrowFactory.createBorrow(user,book,15);
		return this.borrowRepository.add(borrow);
	}

	@Override
	public Borrow returnBook(Book book) throws Exception {
		Borrow borrow = this.getActiveBorrowByBook(book);
		if(borrow ==null) throw new Exception("Book not borrowed");
		borrow.returnBook();
		this.borrowRepository.update(borrow);
		return borrow;
	}

	@Override
	public Borrow getActiveBorrowByBook(Book book) {
		return this.borrowRepository.findActiveBorrowByBook(book);
	}

	@Override
	public Borrow[] getActiveBorrowByUser(User user) {
		return this.borrowRepository.findActiveBorrowsByUser(user);
	}
}
