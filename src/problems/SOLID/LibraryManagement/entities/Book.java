package problems.SOLID.LibraryManagement.entities;

import java.util.Arrays;

/**
 * This object will be responsible for serializing and deserializing in addition to object properties accessor
 */
public class Book implements Id{
    String author,title,ISBN;
    Id id;
    public Book(Id id,String author, String title, String ISBN) {
        this.id=id;
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
        return STR."id=\{this.id.getId()}, author=\{author}, title=\{title}, ISBN=\{ISBN}\n";
    }


    @Override
    public String getId() {
        return this.id.getId();
    }

    @Override
    public void setId(String id) {
         this.id.setId(id);
    }

    @Override
    public boolean isEqual(Id id) {
        return this.id.isEqual(id);
    }
}

