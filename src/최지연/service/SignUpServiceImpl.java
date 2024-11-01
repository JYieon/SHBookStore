package 최지연.service;

import 최지연.dao.SignUpDAO;

import java.util.Scanner;

import 정성호.member_dto.MemberDTO;

public class SignUpServiceImpl implements SignUpService{
	SignUpDAO dao;
	String name = null,  id = null, pwd = null, pwd2 = null;
	String addr = null, phone = null;
	Scanner input = new Scanner(System.in);
	
	public SignUpServiceImpl(){
		dao = new SignUpDAO();
	}
	
	public void signUp() {
		
		
		System.out.println("------------------------ [회원가입] -------------------------");
		
		int result = signUpInsert();
		
		if(result == 1) {
			System.out.println("[회원가입 성공]");
		}else {
			System.out.println("[회원가입 실패]");
		}
	}
	
	public int signUpInsert() {
		int result = 0;
		System.out.print("회원 이름\t\t: ");
		name = input.next();
		while(true) {
			System.out.print("회원 전화번호(-제외)\t: "); //long로 변경
			phone = input.next();
			if (phone.length() >= 10 && phone.length() <= 11) { //번호를 문자열로 저장해 값 비교
				if (!phone.matches("^[0-9]*$")) {
					System.out.println("[입력 오류 : 숫자 이외의 문자가 입력되었습니다]");
				}else {
					break;
				}
            } else {
                System.out.println("[입력 오류 : 전화번호는 10자리 또는 11자리 숫자여야 합니다]");
            }
			
		} //dao가 안에 들어가니까 숫자를 입력해도 숫자 이외의 문자가 입력되었다는 오류 발생. 그냥 밖으로 빼냄.  
		if(dao.phoneCheck(phone)) { //새로운 전화번호. 회원가입 가능
			System.out.println("[이미 계정이 있는 번호입니다]");
		}else {
			System.out.print("회원 주소\t\t: ");
			input.nextLine(); //엔터값 지우기
			addr = input.nextLine();
			System.out.print("회원 id\t\t: ");
			id = input.next();
			while(true) {
				System.out.print("회원 pwd\t\t: ");
				pwd = input.next();
				System.out.print("pwd 확인\t\t: ");
				pwd2 = input.next();
				if(pwd.equals(pwd2)) {
					break;
				}
				else {
					System.out.println("[비밀번호 확인이 틀렸습니다]");
				}
			}
			result = dao.insert(id, pwd, name, phone, addr);
		}
		return result;
	}
}


