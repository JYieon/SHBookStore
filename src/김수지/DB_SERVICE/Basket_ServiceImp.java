package 김수지.DB_SERVICE;

import java.util.ArrayList;
import java.util.Scanner;
import 김수지.DB_DAO.Basket_DAO;
import 김수지.DB_DTO.Basket_DTO;

public class Basket_ServiceImp implements Basket_Service{
	Scanner input = new Scanner(System.in);
	Buy_ServiceImp bs = new Buy_ServiceImp();
	
	int num;
	
	Basket_DAO dao;
	public Basket_ServiceImp() {
		dao = new Basket_DAO();
	}
	
	public void display(String id) {
		while(true) {
			System.out.println("1. 장바구니 확인");
			System.out.println("2. 구매내역 확인");
			System.out.println("3. 내 정보 수정");
			System.out.println("4. 회원 탈퇴");
			num = input.nextInt();
			
			switch(num) {
			case 1 : 
				ArrayList<Basket_DTO> list = dao.BasketList(id);
				System.out.println("회원 id\t책 id\t책 이름\t\t\t책 가격\t책 개수\t총 금액");
				for(Basket_DTO bk : list) {
					System.out.println(bk.getKm_id()+"\t"+bk.getKb_id()+"\t"+bk.getK_name()+"\t\t"+
										bk.getK_price()+"\t"+bk.getK_count()+"\t"+bk.getK_total_price());
				}
				break; 
			case 2 : 
				bs.play(id);
				break; 
			case 3 : 
				
				break; 
			case 4 : 
				
				break; 
			}


		}

	}


}


