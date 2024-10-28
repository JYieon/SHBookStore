package 이유나;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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
			System.out.println("----- 도서 구매 -----");
			System.out.println("1. 도서 목록");
			System.out.println("2. 구매 종료");
			System.out.println(" >>>>> ");
			num = input.nextInt();
			
			switch (num) {
			case 1 :
				System.out.println("--- 구매 가능한 도서 목록 ---");
				ArrayList<BookDTO> books = new ArrayList<BookDTO>();
				books = dao.getList();
				System.out.printf("%-10s %-30s %20s %20s %10s%n", "책 번호", "책 이름", "작가", "출판사", "가격");
				for(BookDTO b : books) {
					
					System.out.printf("%-10d %-30s %20s %20s %10d%n", 
                            b.getId(), 
                            b.getName(), 
                            b.getAuthor(), 
                            b.getPublisher(), 
                            b.getPrice());
					
					
				}
			}
		}
	}
}
