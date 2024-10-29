package 김수지.DB_SERVICE;

import java.util.Scanner;

import 김수지.DB_DAO.Basket_DAO;
import 전영민.dao.UpdateDeleteDAO;
import 전영민.dto.UpdateDeleteDTO;
import 전영민.service.UpdateDeleteService;
import 정성호.member_dto.MemberDTO;

public class MyPage_ServiceImp implements UpdateDeleteService {
	Basket_DAO dao2 = new Basket_DAO();
	Scanner input = new Scanner(System.in);
	int num;
	UpdateDeleteDAO dao = new UpdateDeleteDAO();
	MemberDTO dto = new MemberDTO();
	public MyPage_ServiceImp() {
		dao = new UpdateDeleteDAO();
	}


	public MemberDTO UpdateDelete(MemberDTO d) {
		int a =0;
		MemberDTO d1 = d;
		while (a==0) {
			System.out.println("1. 장바구니");
			System.out.println("2. 구매내역");
			System.out.println("3. 회원정보 수정 및 탈퇴");
			System.out.println("4. 뒤로가기");
			num = input.nextInt();
			input.nextLine();

			switch (num) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				System.out.println("1. 회원정보 수정 | 2. 회원탈퇴");// 전영민
				int choice = input.nextInt();
				input.nextLine();

				if (choice == 1) {
					update(d); // 회원정보 수정
				} else if (choice == 2) {
					a = delete(d); // 회원 탈퇴
				}
				if(a!=0) {
					d1 =null;
					return d1;
				}
				break;
			default:
				System.out.println("올바른 번호를 입력하세요.");
				break;
			case 4:
				return d1;
			}
		}
		return d1;
	}

	// 회원정보 수정
	public void update(MemberDTO d) {
		System.out.println("현재 아이디 : " + d.getM_id());
		// 아이디는 고정, 변경 x
		String pwd = null, name = null,  addr = null, pwd2 = null;
		Long phone ;
		
		
		
		while (true) {
			System.out.println("수정할 항목을 선택하세요.");
			System.out.println("1. 비밀번호");
			System.out.println("2. 이름");
			System.out.println("3. 전화번호");
			System.out.println("4. 주소");
			System.out.println("5. 수정 완료");
   

			int num = input.nextInt();
			input.nextLine();

			switch (num) {
			case 1:
				System.out.println("새 비밀번호 입력: ");
				pwd = input.next();
				System.out.println("비밀번호 확인   : ");
				pwd2 = input.next();
				if(pwd.equals(pwd2)) {
					System.out.println("비밀번호 수정 완료");
					d.setM_pwd(pwd);
				}else {
					System.out.println("비밀번호 확인 실패");
				}
				
				break;
			case 2:
				System.out.println("기존 이름 : " + d.getM_name() );
				System.out.println("이름 입력: ");
				name = input.nextLine();
				d.setM_name(name);
				break;
			case 3:
				System.out.println("기존 전화번호 : " + d.getM_phone());
				System.out.println("전화번호 입력: ");
				phone = input.nextLong();
				d.setM_phone(phone);
				break;
			case 4:
				System.out.println("기존 주소 : " + d.getM_addr());
				System.out.println("주소 입력: ");
				addr = input.nextLine();
				d.setM_addr(addr);
				break;
			case 5:
				int result = dao.update(d);
				if (result > 0) {
					System.out.println("회원정보가 수정되었습니다.");
				} else {
					System.out.println("회원정보 수정 실패.");
				}
				return;
			default:
				System.out.println("올바른 번호를 입력하세요.");
				break;
			}
		}
	}

	// 회원탈퇴
	public int delete(MemberDTO d) {
		int result =0;
		System.out.println("비밀번호 입력: "); // pw입력+확인
		String id = input.nextLine();

		result = dao.delete(d.getM_pwd());
		if (result > 0) {
			System.out.println("회원탈퇴가 완료되었습니다.");
			dao2.delete(d.getM_id());
		} else {
			System.out.println("회원탈퇴 실패.");
		}
		return result;
	}
}