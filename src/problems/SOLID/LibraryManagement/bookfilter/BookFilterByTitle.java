package problems.SOLID.LibraryManagement.bookfilter;

import problems.SOLID.LibraryManagement.Book;

import java.util.ArrayList;
import java.util.List;


public class BookFilterByTitle implements BookFilter{

    @Override
    public Book[] find(List<Book> books, String pattern) {
        ArrayList<Book>filteredBooks = new ArrayList<>();
        for(Book book:books){
            if(book.getTitle().contains(pattern)) filteredBooks.add(book);
        }
        return filteredBooks.toArray(new Book[]{});
    }
}
