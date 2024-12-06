package problems.SOLID.LibraryManagement;

import problems.SOLID.LibraryManagement.entities.Book;

public class BookCreatorFactory {

    public static Book create(String title, String author, String ISBN){
        //validate and sanitize if needed
        return new Book(author,title,ISBN);
    }


}
