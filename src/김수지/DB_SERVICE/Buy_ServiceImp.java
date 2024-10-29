package 김수지.DB_SERVICE;

import java.util.ArrayList;
import java.util.Scanner;
import 김수지.DB_DAO.Buy_DAO;
import 김수지.DB_DTO.Buy_DTO;

public class Buy_ServiceImp implements Buy_Service {
	Scanner input = new Scanner(System.in);
	int num;

	Buy_DAO d;
	public Buy_ServiceImp() {
		d = new Buy_DAO();
	}
	public void play(String id) {
		ArrayList<Buy_DTO> ls = d.BuyList(id);
		System.out.println("주문번호\t회원 id\t책 id\t책 이름\t\t책 가격\t\t구매 개수\t최종 결제 금액\t구매 날짜");
		for(Buy_DTO u : ls ) {
			System.out.println(u.getL_num()+"\t"+u.getLm_id()+"\t"+u.getLb_id()+"\t"+
					u.getL_name()+"\t\t"+u.getL_price()+"\t\t"+u.getL_count()+
					"\t"+u.getL_total_price()+"\t\t"+u.getL_date());
		}
	}

}
