package 이유나.이유나_DB_Service;

import java.util.Scanner;

public class SearchServiceImpl {
	public void search() { //도서검색
		Scanner input = new Scanner(System.in);
		String name = null;
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
			name = input.next();
			//searchBook(name);
			break;
		case 2:
			//searchAuthor();
			break;
		case 3:
			//searchPublisher();
			break;
		case 4:
			break;
		case 5://뒤로가기
			break;
		}
	}
}
