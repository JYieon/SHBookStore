package 이유나;

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
	
	public void display() {
		Scanner input = new Scanner(System.in);
		int num;
		while(true) {
			System.out.println("--- 구매 가능한 도서 목록 ---");
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
			System.out.println("책 번호");
			int booknum = input.nextInt();
			System.out.println("1. 장바구니 2. 바로구매");
			num = input.nextInt();
			
			BookDTO b2 = books.get(booknum);
			switch (num) {
			case 1 :
				System.out.println("장바구니");
				dao.cart(b2);
				break;
			case 2 :
				System.out.println("결제가 완료되었습니다");
				break;
			case 3 :
				System.out.println("구매 취소");
				break;
			}
          
        }

        
			
		
			
		
	}
}
