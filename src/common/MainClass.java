package common;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.util.Scanner;
import common.DBConnect;
import 김수지.DB_DTO.Basket_DTO;
import 김수지.DB_SERVICE.Basket_ServiceImp;
import 정성호.login_service.LoginService;
import 정성호.login_service.LoginServiceImpl;
import 정성호.member_dto.MemberDTO;

public class MainClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num;
		String n = null; // m_id값
		LoginService lo = new LoginServiceImpl();
		MemberDTO d = null; // 해당 아이디의 member 전체 값
		Basket_ServiceImp b = new Basket_ServiceImp();
		while(true) {
//			System.out.println("1. 로그인"); //정성호
//			System.out.println("2. 회원가입"); //최지연
//			System.out.println("3. 도서 구매"); //이유나
//			System.out.println("4. 마이페이지"); //김수지, 전영민 	
//			System.out.println("5. 서비스 종료"); //최지연
//			System.out.print(">>> ");
//			num = input.nextInt();
			if(d == null) {
				System.out.println("1. 로그인"); //정성호
				System.out.println("2. 회원가입"); //최지연
				System.out.println("3. 서비스 종료"); //최지연
				System.out.print(">>> ");
				num = input.nextInt();
				switch(num){
				case 1: //로그인
					d = lo.login2(); // 모든 정보 값
//					n = lo.login(); // id 값
					break;
				case 2: //회원가입
					System.out.println(n);
					break;
				case 3: // 종료
					return;
				}
			}else {
				System.out.println("1. 로그아웃"); //정성호
				System.out.println("2. 도서 구매"); //이유나
				System.out.println("3. 마이페이지"); //김수지, 전영민 	
				System.out.println("4. 서비스 종료"); //최지연
				System.out.print(">>> ");
				num = input.nextInt();
				switch(num){
				case 1: // 로그아웃
//					n = lo.logout();
					d = null;
					break;
				case 2: //도서구매
					break;
				case 3: //마이페이지
					 b.display(d.getM_id());
					 
					break;
				case 4: // 종료
					
					
					return;
				}
			}
		}
	}

	private static void Basket_ServiceImp() {
		// TODO Auto-generated method stub
		
	}
}
//dto에서 db데이터를 저장시킨 객체를 