package problems.SOLID.LibraryManagement.utilities;

import java.io.IOException;

public interface FileWriter {
	void write(String content) throws IOException;
	void close() throws IOException;
	void clearFileContent() throws IOException;
}
