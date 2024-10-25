package common;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.util.Scanner;
import common.DBConnect;
import 정성호.login_service.LoginService;
import 정성호.login_service.LoginServiceImpl;
import 정성호.member_dto.MemberDTO;

public class MainClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num;
		String n = null;
		LoginService lo = new LoginServiceImpl();
		MemberDTO d = null;
		while(true) {
//			System.out.println("1. 로그인"); //정성호
//			System.out.println("2. 회원가입"); //최지연
//			System.out.println("3. 도서 구매"); //이유나
//			System.out.println("4. 마이페이지"); //김수지, 전영민 	
//			System.out.println("5. 서비스 종료"); //최지연
//			System.out.print(">>> ");
//			num = input.nextInt();
			if(n == null) {
				System.out.println("1. 로그인"); //정성호
				System.out.println("2. 회원가입"); //최지연
				System.out.print(">>> ");
				num = input.nextInt();
				switch(num){
				case 1: //로그인
//					d = lo.login();
					n = lo.login();
					break;
				case 2: //회원가입
					System.out.println(n);
					break;
				}
			}else {
				System.out.println("3. 도서 구매"); //이유나
				System.out.println("4. 마이페이지"); //김수지, 전영민 	
				System.out.println("5. 로그아웃"); //정성호
				System.out.println("6. 서비스 종료"); //최지연
				System.out.print(">>> ");
				num = input.nextInt();
				switch(num){
				case 3: //도서구매
					break;
				case 4: //마이페이지
					break;
				case 5: // 로그아웃
					n = lo.logout();
					break;
				case 6: // 종료
					break;
				}
			}
		}
	}
}
//dto에서 db데이터를 저장시킨 객체를 