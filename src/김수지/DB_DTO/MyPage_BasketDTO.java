
package 김수지.DB_DTO;
//id(fk), b_id(fk), b_name(fk), price(fk), num, date 구매내역
//id(fk), b_id(fk), b_name(fk), price(fk), num 장바구니

public class MyPage_BasketDTO {
	private String id, b_id, b_name;
	private int price;
	
	public MyPage_BasketDTO() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}


