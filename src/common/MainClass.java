package common;

import java.util.Scanner;

import 김수지.DB_SERVICE.*;//전영민
import 이유나.이유나_DB_Service.BookServiceImpl;
import common.DBConnect;

import 이유나.이유나_DB_Service.*;

import 정성호.login_service.AdminService;
import 정성호.login_service.AdminServiceImpl;
import 정성호.login_service.LoginService;
import 정성호.login_service.LoginServiceImpl;
import 정성호.member_dto.MemberDTO;
import 최지연.service.SignUpService;
import 최지연.service.SignUpServiceImpl;


public class MainClass {
   public static MemberDTO d = null; // 해당 아이디의 member 전체 값
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int num;
      BookServiceImpl bookimpl = new BookServiceImpl();
      String n = null; // m_id값
      LoginService lo = new LoginServiceImpl();
      SignUpService su = new SignUpServiceImpl();
      AdminService am = new AdminServiceImpl();
      MyPage_ServiceImp myPageService = new MyPage_ServiceImp(); 
      BookServiceImpl book = new BookServiceImpl();
      SearchServiceImpl sea = new SearchServiceImpl();
      
      boolean bool = true;
      while(bool) {
         if(d == null) {
            System.out.println("[성호 서점]");
            System.out.println("1. 로그인"); //정성호
            System.out.println("2. 회원가입"); //최지연
            System.out.println("3. 서비스 종료");
            System.out.print(">>> ");
            num = input.nextInt();
            switch(num){

            case 1: //로그인
               d = lo.login2(); 
               break;
            case 2: //회원가입
               su.signUp();
               break;
            case 3: //도서구매
               bool = false;
               System.out.println("[서비스를 종료합니다]");
               break;
            }
         }else if(d.getM_id().equals("admin")) {
            d=am.adminstart();
         }else {
        	System.out.println("-------------------------------------------------");
            System.out.println("1. 로그아웃"); 
            System.out.println("2. 도서 검색");            
            System.out.println("3. 도서 구매"); 
            System.out.println("4. 마이페이지");    
            System.out.println("5. 서비스 종료"); 
            System.out.print(">>> ");
            num = input.nextInt();
            switch(num){
            case 1: 
               d = lo.logout();
               break;
            case 2:
            	sea.search();
            	break;
            case 3: 
               book.display(d.getM_id());
               //도서구매
               break;
            case 4: //마이페이지
               d = myPageService.UpdateDelete(d);
               break;
            case 5: // 종료
               return;
            }
         }
      }
   }
}