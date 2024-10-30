package 김수지.DB_SERVICE;

import java.util.ArrayList;
import java.util.Scanner;
import 김수지.DB_DAO.Basket_DAO;
import 김수지.DB_DTO.Basket_DTO;
import 김수지.DB_DTO.Buy_DTO;
import 이유나.이유나_DB_DAO.BookDAO;

public class Basket_ServiceImp implements Basket_Service{
	Scanner input = new Scanner(System.in);
	Buy_ServiceImp bs = new Buy_ServiceImp();
	BookDAO book_dao = new BookDAO();
	int num;
	
	Basket_DAO dao;
	public Basket_ServiceImp() {
		dao = new Basket_DAO();
	}
	
	public void display(String id) {
		ArrayList<Basket_DTO> list = dao.BasketList(id);
		System.out.println("------------------------ [장바구니] -------------------------");
		System.out.printf("%-9s %-8s %-35s\t%-10s %-10s%n", 
                "회원 id", "책 id", "책 이름", "책 가격", "책 개수");
		
		if(list != null && !list.isEmpty()) {
			for (Basket_DTO bk : list) {
		        System.out.printf("%-10s %-8d %-35s",
		                          bk.getKm_id(), bk.getKb_id(), 
		                          bk.getK_name());
		        System.out.print("\t");
		        System.out.printf("%-5d %10d%n",
	                    bk.getK_price(), bk.getK_count());
		    }
			basket_delete(id);
		}
	}
	
	public void basket_delete(String id) {
		System.out.println("-----------------------------------------------------------");
		System.out.println("1번 구매하기");
		System.out.println("2번 장바구니 삭제하기");
		System.out.println("3번 뒤로가기");
		System.out.print(">>> ");
		String num3 = input.next();
		switch(num3) {
		case "1":
			int a = 0;
			a = book_dao.all_buy(id);
			if(a == 1) {
				System.out.println("[구매 완료 되었습니다]");
				dao.delete(id);
			}
			break;
		case "2":
			dao.delete(id);
			break;
		case "3":
			return;
		default :
        	System.out.println("[잘못된 입력]\n");
        	
		}
	}

}


