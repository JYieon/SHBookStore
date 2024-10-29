package 김수지.DB_SERVICE;

import java.util.Scanner;

import 전영민.dao.UpdateDeleteDAO;
import 전영민.service.UpdateDeleteService;
import 김수지.DB_SERVICE.*;

public class MyPage_ServiceImp implements UpdateDeleteService {
    Scanner input = new Scanner(System.in);
    int num;
    UpdateDeleteDAO dao = new UpdateDeleteDAO();
    Buy_ServiceImp buy = new Buy_ServiceImp();
    Basket_ServiceImp basket = new Basket_ServiceImp();
    
    public MyPage_ServiceImp() {
    	dao = new UpdateDeleteDAO();
    }

    public void UpdateDelete(String uid) {
        while (true) {
            System.out.println("1. 장바구니");
            System.out.println("2. 구매내역");
            System.out.println("3. 회원정보 수정 및 탈퇴");
            System.out.println("4. 뒤로가기");
            num = input.nextInt();
            input.nextLine();

            switch (num) {
                case 1: 
                	basket.display(uid);
                    break;
                case 2:
                	buy.play(uid);
                    break;
                case 3:
                    System.out.println("1. 회원정보 수정 | 2. 회원탈퇴");//전영민
                    int choice = input.nextInt();
                    input.nextLine();

                    if (choice == 1) {
                        update(uid); // 회원정보 수정
                    } else if (choice == 2) {
                        delete(uid); // 회원정보 탈퇴
                    }
                    break;
                case 4:
                	return;
                default:
                    System.out.println("올바른 번호를 입력하세요.");
                    break;
            }
        }
    }

    // 회원정보 수정
    public void update(String uid) {
        System.out.println("현재 아이디 : " + uid);
        //아이디는 고정, 변경 x
        System.out.println("새 비밀번호 입력: ");
        String pwd = input.nextLine();
        System.out.println("이름 입력: ");
        String name = input.nextLine();
        System.out.println("전화번호 입력: ");
        String phone = input.nextLine();
        System.out.println("주소 입력: ");
        String addr = input.nextLine();

        int result = dao.update(uid, pwd, name, phone, addr);
        if (result > 0) {
            System.out.println("회원정보가 수정되었습니다.");
        } else {
            System.out.println("회원정보 수정 실패.");
        }
    }

    // 회원탈퇴
    public void delete(String uid) {
        int result = dao.delete(uid);
        if (result > 0) {
            System.out.println("회원탈퇴가 완료되었습니다.");
        } else {
            System.out.println("회원탈퇴 실패.");
        }
    }
}