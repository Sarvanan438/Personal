package problems.SOLID.LibraryManagement.utilities;

import java.io.FileNotFoundException;

public interface FileReader {
	String readLine();
	boolean hasLine();
	void open() throws FileNotFoundException;
	void close();
}
