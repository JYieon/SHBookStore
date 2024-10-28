package 이유나;

public class BookDTO {
  private String author, name, publisher, category;
  private int price, id;
  public BookDTO() {}
  public BookDTO(String authour, String name, String publisher, String category,
		  int price, int id) {
	  this.author = author; this.name = name; this.id = id; this.category = category;
	  this.price = price; this.publisher = publisher;
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
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

}
