package problems.SOLID.LibraryManagement.utilities.impl;

import problems.SOLID.LibraryManagement.utilities.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SimpleFileReader implements FileReader {
	private Scanner reader;
	private File file;

	public SimpleFileReader(File file) throws FileNotFoundException {
		this.file = file;
		this.open();
	}

	public void setupReader() throws FileNotFoundException {
		this.reader=new Scanner(file);
	}

	public void open() throws FileNotFoundException {
		this.setupReader();
	}
	@Override
	public String readLine() {

		return this.reader.nextLine();

	}

	@Override
	public boolean hasLine() {
		return this.reader.hasNextLine();
	}

	public void close(){
		this.reader.close();
	}
}
