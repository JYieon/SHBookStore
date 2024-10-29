package 김수지.DB_DTO;

import java.sql.Date;

public class Buy_DTO {
	private int l_num, lb_id, l_price, l_count, l_total_price;
	private String lm_id, l_name;
	private Date l_date;

	public Buy_DTO() {}
	public Buy_DTO(String lm_id, String l_name, int l_num, int lb_id, int l_price, int l_count, int l_total_price, Date l_date) {
		
		this.l_count = l_count; this.l_date = l_date; this.l_name = l_name; this.l_num = l_num; 
		this.l_price = l_price; this.l_total_price = l_total_price; this.lb_id = lb_id; this.lm_id = lm_id;
	}
	public int getL_num() {
		return l_num;
	}
	public void setL_num(int l_num) {
		this.l_num = l_num;
	}
	public int getLb_id() {
		return lb_id;
	}
	public void setLb_id(int lb_id) {
		this.lb_id = lb_id;
	}
	public int getL_price() {
		return l_price;
	}
	public void setL_price(int l_price) {
		this.l_price = l_price;
	}
	public int getL_count() {
		return l_count;
	}
	public void setL_count(int l_count) {
		this.l_count = l_count;
	}
	public int getL_total_price() {
		return l_total_price;
	}
	public void setL_total_price(int l_total_price) {
		this.l_total_price = l_total_price;
	}
	public Date getL_date() {
		return l_date;
	}
	public void setL_date(Date l_date) {
		this.l_date = l_date;
	}
	public String getLm_id() {
		return lm_id;
	}
	public void setLm_id(String lm_id) {
		this.lm_id = lm_id;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	

}