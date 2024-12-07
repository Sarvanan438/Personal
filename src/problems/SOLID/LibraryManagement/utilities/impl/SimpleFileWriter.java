package problems.SOLID.LibraryManagement.utilities.impl;

import problems.SOLID.LibraryManagement.utilities.FileWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SimpleFileWriter implements FileWriter {

	private java.io.FileWriter writer ;
	private File file;
	private PrintWriter printWriter;
	public SimpleFileWriter(File file) throws IOException {
		this.file = file;
		this.setupWriter();
	}



	public void setupWriter() throws IOException {
		this.writer=new java.io.FileWriter(this.file,true);
		this.printWriter = new PrintWriter(this.file);
	}
	@Override
	public void write(String content) throws IOException {
		this.writer.write(content);
		this.writer.flush();
	}

	@Override
	public void close() throws IOException {
		this.writer.close();

	}

	@Override
	public void clearFileContent() throws IOException {
		this.writer.close();
		this.printWriter.close();
		this.setupWriter();
	}
}
