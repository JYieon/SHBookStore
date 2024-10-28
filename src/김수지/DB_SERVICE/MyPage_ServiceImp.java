package 김수지.DB_SERVICE;

import java.util.Scanner;

import 전영민.dao.UpdateDeleteDAO;
import 전영민.service.UpdateDeleteService;

public class MyPage_ServiceImp implements UpdateDeleteService {
    Scanner input = new Scanner(System.in);
    int num;
    UpdateDeleteDAO dao = new UpdateDeleteDAO();

    public void UpdateDelete() {
        while (true) {
            System.out.println("1. 장바구니");
            System.out.println("2. 구매내역");
            System.out.println("3. 회원정보 수정 및 탈퇴");
            num = input.nextInt();
            input.nextLine();

            switch (num) {
                case 1: 
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("1. 회원정보 수정 | 2. 회원탈퇴");//전영민
                    int choice = input.nextInt();
                    input.nextLine();

                    if (choice == 1) {
                        update(); // 회원정보 수정
                    } else if (choice == 2) {
                        delete(); // 회원정보 탈퇴
                    }
                    break;
                default:
                    System.out.println("올바른 번호를 입력하세요.");
                    break;
            }
        }
    }

    // 회원정보 수정
    public void update() {
        System.out.println("현재 아이디 입력: ");
        String id = input.nextLine();//아이디는 고정, 변경 x
        System.out.println("새 비밀번호 입력: ");
        String pwd = input.nextLine();
        System.out.println("이름 입력: ");
        String name = input.nextLine();
        System.out.println("전화번호 입력: ");
        String phone = input.nextLine();
        System.out.println("주소 입력: ");
        String addr = input.nextLine();

        int result = dao.update(id, pwd, name, phone, addr);
        if (result > 0) {
            System.out.println("회원정보가 수정되었습니다.");
        } else {
            System.out.println("회원정보 수정 실패.");
        }
    }

    // 회원탈퇴
    public void delete() {
        System.out.println("탈퇴할 아이디 입력: ");
        String id = input.nextLine();

        int result = dao.delete(id);
        if (result > 0) {
            System.out.println("회원탈퇴가 완료되었습니다.");
        } else {
            System.out.println("회원탈퇴 실패.");
        }
    }
}