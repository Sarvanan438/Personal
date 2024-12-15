package problems.SOLID.LibraryManagement.factories.book;


import problems.SOLID.LibraryManagement.dto.BookDTO;
import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.utilities.impl.UUIDUtils;

public class BookCreatorFactory {



    public static BookDTO createDTO(String title, String author, String ISBN){
        return new BookDTO(author,ISBN,title);
    }

    public static Book createBookFromDTO(BookDTO bookDTO){
        return new Book(UUIDUtils.generateUUID(), bookDTO.getAuthor(),bookDTO.getTitle(),bookDTO.getISBN());
    }
}
