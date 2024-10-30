package 김수지.DB_SERVICE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		System.out.println("------------------------ [구매내역] -------------------------");
		System.out.printf("%-8s %-8s %-8s %-35s\t%-10s %-10s %-10s %-10s%n", 
                "주문번호", "회원 id", "책 id", "책 이름", "책 가격", "구매 개수", "최종 결제 금액", "구매 날짜");

		Collections.sort(ls, new Comparator<Buy_DTO>() { //주문번호 오름차순으로 정렬
            @Override
            public int compare(Buy_DTO b1, Buy_DTO b2) {
                return Integer.compare(b1.getL_num(), b2.getL_num());
            }
        });
		
		for (Buy_DTO u : ls) {
	        System.out.printf("%-10d %-8s %-8d %-35s",
	                          u.getL_num(), u.getLm_id(), u.getLb_id(), 
	                          u.getL_name());
	        System.out.print("\t");
	        System.out.printf("%-15d %-10d %-10d %-10s%n",
                    u.getL_price(), 
                    u.getL_count(), u.getL_total_price(), 
                    u.getL_date());
	    }
	}
	@Override
	public void alllist() {
		ArrayList<Buy_DTO> ls2 = d.allBuyList();
		System.out.printf("%-8s %-8s %-8s %-35s\t%-10s %-10s %-10s %-10s%n", 
                "주문번호", "회원 id", "책 id", "책 이름", "책 가격", "구매 개수", "최종 결제 금액", "구매 날짜");

		Collections.sort(ls2, new Comparator<Buy_DTO>() { //주문번호 오름차순으로 정렬
            @Override
            public int compare(Buy_DTO b1, Buy_DTO b2) {
                return Integer.compare(b1.getL_num(), b2.getL_num());
            }
        });
		
		for (Buy_DTO u : ls2) {
	        System.out.printf("%-10d %-8s %-8d %-35s",
	                          u.getL_num(), u.getLm_id(), u.getLb_id(), 
	                          u.getL_name());
	        System.out.print("\t");
	        System.out.printf("%-15d %-10d %-10d %-10s%n",
                    u.getL_price(), 
                    u.getL_count(), u.getL_total_price(), 
                    u.getL_date());
	    }
		
	}

	
}
