package problems.SOLID.LibraryManagement.repositories;

import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.entities.Borrow;
import problems.SOLID.LibraryManagement.entities.User;

import java.io.IOException;

public interface BorrowRepository extends Repository<Borrow> {
	Borrow findActiveBorrowByBook(Book book);
	void update(Borrow borrow) throws IOException;
	Borrow[] findActiveBorrowsByUser(User user);
}
