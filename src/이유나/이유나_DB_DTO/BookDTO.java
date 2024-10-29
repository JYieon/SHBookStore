package 이유나.이유나_DB_DTO;

public class BookDTO {
  private String author, name, publisher, category,m_id;
  private int price,b_id,count,total;
  public BookDTO() {}
  public BookDTO(String authour, String name, String publisher, String category,
		  int price, String id) {
	  this.author = author; this.name = name; this.m_id = id; this.category = category;
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
public String getM_id() {
	return m_id;
}
public void setM_id(String m_id) {
	this.m_id = m_id;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getB_id() {
	return b_id;
}
public void setB_id(int b_id) {
	this.b_id = b_id;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total += this.count * this.price;
}



}
