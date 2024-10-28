package 최지연.service;

import 최지연.dao.SignUpDAO;

import java.util.Scanner;

import 정성호.member_dto.MemberDTO;

public class SignUpServiceImpl implements SignUpService{
	SignUpDAO dao;
	String name = null,  id = null, pwd = null, pwd2 = null;
	String addr = null;
	Long phone;
	
	public SignUpServiceImpl(){
		dao = new SignUpDAO();
	}
	
	public void signUp() {
		Scanner input = new Scanner(System.in);
		boolean end = false;
		int result = 0;
		System.out.println("[회원가입]");
		System.out.print("회원 이름\t\t: ");
		name = input.next();
		while(true) {
			try {
				System.out.print("회원 전화번호(-제외)\t: "); //int로 변경
				phone = input.nextLong();
				if (String.valueOf(phone).length() >= 10 && String.valueOf(phone).length() <= 11) { //번호를 문자열로 저장해 값 비교
					break;
	            } else {
	                System.out.println("전화번호는 10자리 또는 11자리 숫자여야 합니다. 다시 입력하세요.");
	            }
			} catch (Exception e) {
				System.out.println("숫자 이외의 문자가 입력되었습니다. 전화번호를 다시 입력하세요");
				input.next(); // 잘못된 입력을 무시하고 다시 입력받는다
			}
		} //dao가 안에 들어가니까 숫자를 입력해도 숫자 이외의 문자가 입력되었다는 오류 발생. 그냥 밖으로 빼냄.  
		if(dao.phoneCheck(phone)) { //새로운 전화번호. 회원가입 가능
			System.out.println("이미 계정이 있는 번호입니다");
		}else {
			System.out.print("회원 주소\t\t: ");
			addr = input.next();
			System.out.print("회원 id\t\t: ");
			id = input.next();
			while(true) {
				System.out.print("회원 pwd\t\t: ");
				pwd = input.next();
				System.out.print("pwd 확인\t\t: ");
				pwd2 = input.next();
				if(pwd.equals(pwd2)) {
					System.out.println("ok");
					break;
				}
				else {
					System.out.println("비밀번호 확인이 틀렸습니다.");
				}
			}
			result = dao.insert(id, pwd, name, phone, addr);
		}
		
		if(result == 1) {
			System.out.println("[회원가입 성공]");
		}else {
			System.out.println("[회원가입 실패]");
		}
	}
}


