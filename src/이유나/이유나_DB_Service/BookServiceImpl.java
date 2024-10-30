package 이유나.이유나_DB_Service;

import java.util.ArrayList;
import java.util.Scanner;

import 이유나.이유나_DB_DAO.BookDAO;
import 이유나.이유나_DB_DTO.BookDTO;

public class BookServiceImpl implements BookService {
	BookDAO dao;
	private Scanner input;
	
	public BookServiceImpl() {
		dao = new BookDAO();
		input = new Scanner(System.in);
	}
	
	public void display(String u_id) {
		Scanner input = new Scanner(System.in);
		String num,sel;
		while(true) {
			System.out.println("------------------------ [도서 구매] -------------------------");
			System.out.println("1. 도서 구매하기 | 2. 뒤로가기");
			System.out.println(">>> ");
			sel = input.next();
			switch(sel) {
			case "1":
				System.out.println("------------------------ 구매 가능한 도서 목록 -------------------------");
				ArrayList<BookDTO> books = new ArrayList<BookDTO>();
				books = dao.getList();
				System.out.printf("%-10s %-30s %20s %20s %10s%n", "책 번호", "책 이름", "작가", "출판사", "가격");
				for(BookDTO b : books) {
					
					System.out.printf("%-10d %-30s %20s %20s %10d%n", 
	                        b.getB_id(), 
	                        b.getName(), 
	                        b.getAuthor(), 
	                        b.getPublisher(), 
	                        b.getPrice());
				}
				System.out.print("구매 할 책 번호 : ");
				int booknum = input.nextInt();
				System.out.print("구매 할 수량 : ");
				int b_count = input.nextInt();
				System.out.println("1. 장바구니 | 2. 바로구매");
				System.out.println(">>> ");
				num = input.next();
				
				BookDTO b2 = books.get(booknum-1);
				switch (num) {
				case "1" :
					System.out.println("[장바구니로 이동하였습니다]");
					dao.cart(b2,b_count,u_id);
					break;
				case "2" :
					System.out.printf("%-10s %-30s %20s %20s %10s%n", "책 번호", "책 이름", "작가", "출판사", "가격");
					System.out.printf("%-10d %-30s %20s %20s %10d%n", 
	                        b2.getB_id(), 
	                        b2.getName(), 
	                        b2.getAuthor(), 
	                        b2.getPublisher(), 
	                        b2.getPrice());
					System.out.println("수량 : " + b_count + "\t 결제 금액 : " + (b2.getPrice()*b_count));
					System.out.println("1. 결제 | 2. 결제 취소");
					System.out.println(">>> ");
					String num2 = input.next();
					if(num2 == "1") {
						System.out.println("[결제가 완료되었습니다]");
						dao.buy(b2,b_count,u_id);
					}else if(num2 == "2") {
						System.out.println("[결제가 취소되었습니다]");	
					}else {
		            	System.out.println("[잘못된 입력 : 다시 입력해주세요]");
					}
					break;
				case "3" :
					System.out.println("[구매가 취소되었습니다]");
					break;
				default :
	            	System.out.println("[잘못된 입력 : 다시 입력해주세요]");
				}
				break;
			case "2":
				return;
			default :
            	System.out.println("[잘못된 입력 : 다시 입력해주세요]");
			}
          
        }

        
			
		
			
		
	}
}
