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
		System.out.println("-------------------------------------------------");
		System.out.println("[도서 검색]");
		System.out.println("1. 책 제목");
		System.out.println("2. 작가 이름");
		System.out.println("3. 출판사");
		System.out.println("4. 뒤로가기");
		System.out.print(">> ");
		String num = input.next();
		
		switch(num) {
		case "1" :
			System.out.print("책 제목 입력 : ");
			name = input.next();
			
			ArrayList<BookDTO> sb = new ArrayList<BookDTO>();
			sb = dao.searchBook(1, name);
			
			if (sb.isEmpty()) {
		        System.out.println("[검색 결과가 없습니다]\n");
		    } else {
		    	System.out.printf("%-8s %-40s\t%-10s %-10s %-10s\n", 
		                "책 id", "책 이름", "작가", "출판사", "가격");
				for(BookDTO a : sb) {
					System.out.printf("%-8d %-40s",
	                          a.getB_id(), a.getName());
					System.out.print("\t");
					System.out.printf("%-10s %-10s %-10d%n",
							a.getAuthor(), a.getPublisher(), a.getPrice());
				}
			}
			
			break;
		case "2":
			System.out.print("작가 이름 입력 : ");
			name = input.next();
			
			sb = dao.searchBook(2, name);
			if (sb.isEmpty()) {
				System.out.println("[검색 결과가 없습니다]\n");		    
			} else {
		    	System.out.printf("%-8s %-40s\t%-10s %-10s %-10s\n", 
		                "책 id", "책 이름", "작가", "출판사", "가격");
				for(BookDTO a : sb) {
					System.out.printf("%-8d %-40s",
	                          a.getB_id(), a.getName());
					System.out.print("\t");
					System.out.printf("%-10s %-10s %-10d%n",
							a.getAuthor(), a.getPublisher(), a.getPrice());
				}
			}
			
			break;
		case "3":
			System.out.print("출판사 입력 : ");
			name = input.next();
			
			sb = dao.searchBook(3, name);
			if (sb.isEmpty()) {
				System.out.println("[검색 결과가 없습니다]\n");
		    } else {
		    	System.out.printf("%-8s %-40s\t%-10s %-10s %-10s\n", 
		                "책 id", "책 이름", "작가", "출판사", "가격");
				for(BookDTO a : sb) {
					System.out.printf("%-8d %-40s",
	                          a.getB_id(), a.getName());
					System.out.print("\t");
					System.out.printf("%-10s %-10s %-10d%n",
							a.getAuthor(), a.getPublisher(), a.getPrice());
				}
			}
			break; 
			
		case "4":
			return; // 뒤로가기
		default :
			System.out.println("[잘못된 입력 : 다시 입력해주세요]\n");		
		}
	}
}
}
	

