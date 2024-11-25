package problems.SOLID.LibraryManagement;

import java.io.EOFException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SimpleFileService implements FileService
{
    private  File file;
    private FileWriter writer;
    private Scanner reader;
    SimpleFileService(File file) throws IOException {
        this.file=file;
        this.writer=new FileWriter(this.file,true);
        this.reader=new Scanner(file);
    }
    @Override
    public void write(String content) throws IOException {
        this.writer.write(content);
    }

    @Override
    public String readLine() {
        if(this.hasLine()){
            return this.reader.nextLine();
        }
        return "";
    }

    @Override
    public boolean hasLine() {
        return this.reader.hasNextLine();
    }
}
