package 이유나.이유나_DB_DTO;

public class SearchDTO {

	private String author, name, publisher, category;
	private int price, b_id;
	
	public SearchDTO() {}
	public SearchDTO(String author, String name, String publisher, String category) {
		this.author = author; this.category = category; this.name = name; this.publisher = publisher;
		this.b_id = b_id; this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}