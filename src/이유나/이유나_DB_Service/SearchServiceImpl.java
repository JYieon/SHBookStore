package 이유나.이유나_DB_Service;

import java.util.ArrayList;
import java.util.Scanner;

import 이유나.이유나_DB_DAO.SearchDAO;
import 이유나.이유나_DB_DTO.BookDTO;
import 이유나.이유나_DB_DTO.SearchDTO;

public class SearchServiceImpl implements SearchService {
	private SearchDAO dao;
	
	public void SearchServiceImpl() {
		dao = new SearchDAO();
	}
	public void search() { //도서검색 
		
		SearchDAO sd = new SearchDAO();
		Scanner input = new Scanner(System.in);
		String name = null;
		SearchDTO dto = null;
		String searchTerm;
		
	
		while(true) {
		ArrayList<SearchDTO> books = null ;
		System.out.println("[도서 검색]");
		System.out.println("1. 책 제목");
		System.out.println("2. 작가 이름");
		System.out.println("3. 출판사");
		System.out.println("4. 카테고리");
		System.out.print(">> ");
		int num = input.nextInt();
		
		switch(num) {
		case 1:
			System.out.println("책 제목 입력 : ");
			searchTerm = input.nextLine();
			
			ArrayList<SearchDTO> sb = dao.searchBook(name);
			sb = dao.searchBook(name);
			for(SearchDTO b : books) {
				
				System.out.printf("%-10d %-30s %20s %20s %10d%n", 
                        b.getName(), 
                        b.getAuthor(), 
                        b.getPublisher(), 
                        b.getCategory());
                       
			}
			
			break;
		case 2:
			System.out.println("작가 이름 입력 : ");
			String searchAuthor = input.next();
			sb = dao.searchBook(name);
			for(SearchDTO b : books) {
				
				System.out.printf("%-10d %-30s %20s %20s %10d%n", 
                        b.getName(), 
                        b.getAuthor(), 
                        b.getPublisher(), 
                        b.getCategory());
                       
			}
			//searchAuthor();
			break;
		case 3:
			System.out.println("출판사 입력 : ");
			String serchPublisher = input.next();
			//searchPublisher();
			break;
		case 4:
			System.out.println("카테고리 입력 : ");
			String searchCategory = input.next();
			
			break;
		case 5://뒤로가기
			return;
			}
		}
		
	}
	private void displayBooks(ArrayList<SearchDTO> books) {
        if (books.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            System.out.println("검색 결과:");
            for (SearchDTO book : books) {
                System.out.println("제목: " + book.getName());
                System.out.println("작가: " + book.getAuthor());
                System.out.println("출판사: " + book.getPublisher());
                System.out.println("카테고리: " + book.getCategory());
                System.out.println("--------------------");
            }
        }
	}
}
