package 이유나.이유나_DB_Service;

import java.util.ArrayList;
import java.util.Scanner;
import 이유나.이유나_DB_DAO.SearchDAO;
import 이유나.이유나_DB_DTO.BookDTO;
import 이유나.이유나_DB_DTO.SearchDTO;

public class SearchServiceImpl implements SearchService {
	private SearchDAO dao;
	
	public SearchServiceImpl() {
		dao = new SearchDAO();
		BookServiceImpl dis = new BookServiceImpl();
	}
	public void search() { //도서검색 
		
		Scanner input = new Scanner(System.in);
		BookDTO dto = null;
		String name;
		
	
		while(true) {
		ArrayList<BookDTO> books = null ;
		System.out.println("[도서 검색]");
		System.out.println("1. 책 제목");
		System.out.println("2. 작가 이름");
		System.out.println("3. 출판사");
		System.out.println("4. 카테고리");
		System.out.println("5. 뒤로가기");
		System.out.print(">> ");
		int num = input.nextInt();
		
		switch(num) {
		case 1:
			System.out.println("책 제목 입력 : ");
			name = input.next();
			
			ArrayList<BookDTO> sb = new ArrayList<BookDTO>();
			sb = dao.searchBook(num, name);
			System.out.printf("%-10s %-30s %20s %20s %10s%n", "책 번호", "책 이름", "작가", "출판사", "가격");
			for(BookDTO a : sb) {
				
				System.out.printf("%-10d %-30s %20s %20s %10d%n", 
                        a.getB_id(), 
                        a.getName(), 
                        a.getAuthor(), 
                        a.getPublisher(), 
                        a.getPrice());
                       
			}
			
			break;
		case 2:
			System.out.println("작가 이름 입력 : ");
			name = input.next();
			
			sb = dao.searchBook(num, name);
			System.out.printf("%-10s %-30s %20s %20s %10s%n", "책 번호", "책 이름", "작가", "출판사", "가격");
			for(BookDTO a : sb) {
				
				System.out.printf("%-10d %-30s %20s %20s %10d%n", 
                        a.getB_id(), 
                        a.getName(), 
                        a.getAuthor(), 
                        a.getPublisher(), 
                        a.getPrice());
                       
			}
			//searchAuthor();
			break;
		case 3:
			System.out.println("출판사 입력 : ");
			name = input.next();
			
			sb = dao.searchBook(num, name);
			System.out.printf("%-10s %-30s %20s %20s %10s%n", "책 번호", "책 이름", "작가", "출판사", "가격");
			for(BookDTO a : sb) {
				
				System.out.printf("%-10d %-30s %20s %20s %10d%n", 
                        a.getB_id(), 
                        a.getName(), 
                        a.getAuthor(), 
                        a.getPublisher(), 
                        a.getPrice());
                       
			
			//searchPublisher();
			break;
			}
		case 4:
			System.out.println("카테고리 입력 : ");
			name = input.next();
			
			sb = dao.searchBook(num, name);
			System.out.printf("%-10s %-30s %20s %20s %10s%n", "책 번호", "책 이름", "작가", "출판사", "가격");
			for(BookDTO a : sb) {
				
				System.out.printf("%-10d %-30s %20s %20s %10d%n", 
                        a.getB_id(), 
                        a.getName(), 
                        a.getAuthor(), 
                        a.getPublisher(), 
                        a.getPrice());
                       
			}
			break;
		case 5://뒤로가기
			return;
			
		}
		
		}
	}
}

	

