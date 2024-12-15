package problems.SOLID.LibraryManagement.repositories;

import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.entities.Borrow;
import problems.SOLID.LibraryManagement.entities.Id;
import problems.SOLID.LibraryManagement.entities.User;
import problems.SOLID.LibraryManagement.persistence.Persistence;
import problems.SOLID.LibraryManagement.serializer.Serializer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleBorrowRepository implements BorrowRepository{
	private Persistence<Book> persistence;
	private Serializer<Borrow> borrowSerializer;

	public SimpleBorrowRepository(Persistence<Book> persistence, Serializer<Borrow> borrowSerializer) {
		this.persistence = persistence;
		this.borrowSerializer = borrowSerializer;
	}

	@Override
	public Borrow findActiveBorrowByBook(Book book) {
		try {
			Borrow[] borrows = this.findAllBorrows();
			for(Borrow borrow:borrows){
				if(borrow.getBookId().isEqual(book) && !borrow.isBookReturned())
					return borrow;
			}
		}catch (Exception e){
			System.out.println("Failed to get all borrows");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Borrow borrow) throws IOException {
		Borrow[] borrows=this.findAllBorrows();

		this.persistence.clearAll();
		for(int i=0;i<borrows.length;i++){
			if(borrows[i].getId().equals(borrow.getId()))
				borrows[i]=borrow;
			this.add(borrow);
		}

	}

	@Override
	public Borrow[] findActiveBorrowsByUser(User user) {
		List<Borrow> activeBorrows = new ArrayList<>();
		try{
			Borrow[] borrows = this.findAllBorrows();
			for(Borrow borrow:borrows){
				if(borrow.getUserId().isEqual(user) && !borrow.isBookReturned()){
					activeBorrows.add(borrow);
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return activeBorrows.toArray(new Borrow[]{});
	}

	@Override
	public Borrow add(Borrow item) throws IOException {
		String serializedBorrow = borrowSerializer.serialize(item);
		this.persistence.insert(serializedBorrow);;
		return item;
	}
	public Borrow[] findAllBorrows() throws FileNotFoundException {
		String[] borrows = this.persistence.findAll();
		return Arrays.stream(borrows).map(borrow->this.borrowSerializer.deserialize(borrow)).toList().toArray(new Borrow[]{});
	}
	@Override
	public Borrow findById(Id id) {
			try{
					Borrow[]borrows=this.findAllBorrows();
					for(Borrow borrow:borrows){
						if(borrow.isEqual(id)) return borrow;
					}
			}catch (Exception e){
				System.out.println("No borrows found for  id: "+id.getId());

			}
			return null;
	}
}
