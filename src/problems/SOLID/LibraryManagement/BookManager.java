package problems.SOLID.LibraryManagement;

import java.io.*;
import java.util.Scanner;


public class BookManager {
    final private String persistenceFileName = "books.txt";
    void saveBook(String title,String author,String ISBN) throws IOException{
        File db= new File(this.persistenceFileName);
        db.createNewFile();
        FileWriter writer = new FileWriter(this.persistenceFileName,true);
        writer.append(STR."\{title} \{author} \{ISBN}\n");
        writer.close();

    }

    Book findBook(String title) throws FileNotFoundException {
        File file = new File(this.persistenceFileName);
        Scanner reader = new Scanner(file);
        while(reader.hasNextLine()){
            String record = reader.nextLine();
            String[]bookDetails =record.split(" ");
            System.out.println(record);
            if(bookDetails[0].contains(title)){
               return new Book(bookDetails[0],bookDetails[1],bookDetails[2] );
            }

        }
        return null;
    }

    public static void main(String[] args) throws IOException,FileNotFoundException {

        BookManager manager = new BookManager();
        File file = new File(manager.persistenceFileName);
        file.delete();
        manager.saveBook("Transformers","MartinBay","12321B1231BB");
        Book book= manager.findBook("Transformers");
        manager.saveBook("Transformers2","MartinBay","12321B1231BB");
        manager.saveBook("Transformers3","MartinBay","12321B1231BB");

        book= manager.findBook("Transformers2");
        System.out.println(book);
    }
}
