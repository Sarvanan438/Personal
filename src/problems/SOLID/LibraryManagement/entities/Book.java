package problems.SOLID.LibraryManagement.entities;

import java.util.Arrays;

/**
 * This object will be responsible for serializing and deserializing in addition to object properties accessor
 */
public class Book{
    String author,title,ISBN;

    public Book(String author, String title, String ISBN) {
        this.author = author;
        this.title = title;
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return STR."author=\{author}, title=\{title}, ISBN=\{ISBN}\n";
    }


}

