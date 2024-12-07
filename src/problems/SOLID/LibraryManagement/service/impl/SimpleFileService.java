package problems.SOLID.LibraryManagement.service.impl;

import problems.SOLID.LibraryManagement.service.FileService;

import java.io.*;
import java.util.Scanner;

public class SimpleFileService implements FileService
{
    private  File file;
    private FileWriter writer;
    private PrintWriter printWriter;
    private Scanner reader;
   public SimpleFileService(File file) throws IOException {
        this.file=file;
        this.setupWriter();
        this.setupReader();

    }

    public void setupReader() throws FileNotFoundException {
        this.reader=new Scanner(file);
    }

    public void setupWriter() throws IOException {
         this.writer=new FileWriter(this.file,true);
        this.printWriter = new PrintWriter(this.file);
    }

    @Override
    public void write(String content) throws IOException {
        this.writer.write(content);
        this.writer.flush();
    }

    @Override
    public String readLine() {

            return this.reader.nextLine();

    }

    @Override
    public boolean hasLine() {
        return this.reader.hasNextLine();
    }

    @Override
    public void clearAll() throws IOException {
        this.reader.close();
        this.writer.close();
        this.printWriter.close();
        this.setupWriter();
        this.setupReader();
    }
}
