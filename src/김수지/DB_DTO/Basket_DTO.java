package 김수지.DB_DTO;

public class Basket_DTO {
	private int kb_id, k_price, k_count, k_total_price;
	private String km_id, k_name;

	public Basket_DTO(){}
	public Basket_DTO(int kb_id, int k_price, int k_count, int k_total_price, String km_id, String k_name){

		this.k_count = k_count; this.k_price = k_price; this.k_total_price = k_total_price; this.km_id = km_id;
		this.kb_id = kb_id; this.k_name = k_name;

	}
	public int getKb_id() {
		return kb_id;
	}
	public void setKb_id(int kb_id) {
		this.kb_id = kb_id;
	}
	public int getK_price() {
		return k_price;
	}
	public void setK_price(int k_price) {
		this.k_price = k_price;
	}
	public int getK_count() {
		return k_count;
	}
	public void setK_count(int k_count) {
		this.k_count = k_count;
	}
	public int getK_total_price() {
		return k_total_price;
	}
	public void setK_total_price(int k_total_price) {
		this.k_total_price = k_total_price;
	}
	public String getKm_id() {
		return km_id;
	}
	public void setKm_id(String km_id) {
		this.km_id = km_id;
	}
	public String getK_name() {
		return k_name;
	}
	public void setK_name(String k_name) {
		this.k_name = k_name;
	}

}

