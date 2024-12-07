package problems.SOLID.LibraryManagement.dto;

public class BookDTO {
	private  String author, ISBN,title;

	public BookDTO(String author, String ISBN, String title) {
		this.author = author;
		this.ISBN = ISBN;
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getTitle() {
		return title;
	}
}
