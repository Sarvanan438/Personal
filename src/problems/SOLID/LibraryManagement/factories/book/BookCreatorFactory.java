package problems.SOLID.LibraryManagement.factories.book;

import problems.SOLID.LibraryManagement.dto.BookDTO;
import problems.SOLID.LibraryManagement.entities.Book;

public class BookCreatorFactory {

    public static Book createBook(String title, String author, String ISBN){
        //validate and sanitize if needed
        return new Book(author,title,ISBN);
    }

    public static BookDTO createDTO(String title, String author, String ISBN){
        return new BookDTO(author,ISBN,title);
    }

    public static Book createBookFromDTO(BookDTO bookDTO){
        return new Book(bookDTO.getAuthor(),bookDTO.getTitle(),bookDTO.getISBN());
    }
}
