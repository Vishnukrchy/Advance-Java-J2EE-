package DTO;

public class Book {
	private int id;
	private String name;
	private String title;
	private String AuthorName;
	private double price;

	public Book(int id, String name, String title, String authorName, double price) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		AuthorName = authorName;
		this.price = price;
	}

	public Book() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return AuthorName;
	}

	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BOOK [id=" + id + ", name=" + name + ", title=" + title + ", AuthorName=" + AuthorName + ", price="
				+ price + "]";
	}

}
