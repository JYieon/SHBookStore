package common;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import common.DBConnect;
import 정성호.login_service.AdminService;
import 정성호.login_service.AdminServiceImpl;
import 정성호.login_service.LoginService;
import 정성호.login_service.LoginServiceImpl;
import 정성호.member_dto.MemberDTO;
import 최지연.service.*;

public class MainClass {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num;
		String n = null; // m_id값
		LoginService lo = new LoginServiceImpl();
		SignUpService su = new SignUpServiceImpl();
		AdminService am = new AdminServiceImpl();
		MemberDTO d = null; // 해당 아이디의 member 전체 값
		boolean bool = true;
		while(bool) {
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
				System.out.println("3. 서비스 종료");
				System.out.print(">>> ");
				num = input.nextInt();
				switch(num){
				case 1: //로그인
					d = lo.login2(); // 모든 정보 값
//					n = lo.login(); // id 값
					break;
				case 2: //회원가입
					su.SignUp();
					break;
				case 3:
					bool = false;
					System.out.println("[서비스를 종료합니다]");
					break;
				}
			}else if(d.getM_id().equals("admin")) {
				System.out.println("1. 로그아웃"); //정성호
				System.out.println("2. 회원 추가"); 
				System.out.println("3. 회원 수정"); 	
				System.out.println("4. 전체 회원 보기");
				System.out.println("5. 회원 찾기");
				System.out.println("6. 회원 삭제");
				System.out.println("7. 서비스 종료");
				System.out.print(">>> ");
				num = input.nextInt();
				switch(num){
				case 1: // 로그아웃
//					n = lo.logout();
					d = lo.logout();
					break;
				case 2: //회원 추가
					am.memberadd();
					break;
				case 3: //회원 수정
					am.memberupdate();
					break;
				case 4: // 전체 회원 보기
					am.allmember();
					break;
				case 5: // 회원 찾기
					MemberDTO m = new MemberDTO();
					m = am.membersearch();
					if(m != null) {
					System.out.println("이름 : " + m.getM_name());
					System.out.println("전화번호 : " + m.getM_phone());
					System.out.println("주소 : " + m.getM_addr());
					System.out.println("id : " + m.getM_id());
					System.out.println("pwd : " + m.getM_pwd());
					}else {
						
					}
					break;
				case 6: // 회원 삭제
					am.memberdelete();
					break;
				case 7: // 종료
					bool = false;
					System.out.println("[서비스를 종료합니다]");
					break;
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
					d = lo.logout();
					break;
				case 2: //도서구매
					break;
				case 3: //마이페이지
					break;
				case 4: // 종료
					return;
				}
			}
		}
	}
}
//dto에서 db데이터를 저장시킨 객체를 