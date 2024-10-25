package common;

import java.sql.Connection;
import java.util.Scanner;
import common.DBConnect;

public class MainClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num;
		
		while(true) {
			System.out.println("1. 로그인"); //정성호
			System.out.println("2. 회원가입"); //최지연
			System.out.println("3. 도서 구매"); //이유나
			System.out.println("4. 마이페이지"); //김수지, 전영민 	
			System.out.println("5. 서비스 종료"); //최지연
			System.out.print(">>> ");
			num = input.nextInt();
			switch(num){
				case 1: //로그인
					break;
				case 2: //회원가입
					break;
				case 3: //도서구매
					break;
				case 4: //마이페이지
					break;
				case 5: // 종료 
					break;
			}
		}
	}
}
