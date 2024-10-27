package 최지연.service;

import 최지연.dao.SignUpDAO;

import java.util.Scanner;

import 정성호.member_dto.MemberDTO;

public class SignUpServiceImpl implements SignUpService{
	SignUpDAO dao;
	
	public SignUpServiceImpl(){
		dao = new SignUpDAO();
	}
	
	public void SignUp() {
		Scanner input = new Scanner(System.in);
		System.out.println("[회원가입]");
		System.out.print("회원 이름\t\t: ");
		String name = input.next();
		System.out.print("회원 전화번호(-제외)\t: "); //동일한 전화번호 가입못하도록 할 것
		String phone = input.next();
		System.out.print("회원 주소\t\t: ");
		String addr = input.next();
		System.out.print("회원 id\t\t: ");
		String id = input.next();
		System.out.print("회원 pwd\t\t: ");
		String pwd = input.next();
		
		int result = dao.insert(id, pwd, name, phone, addr);
		if(result == 1) {
			System.out.println("[회원가입 성공]");
		}else {
			System.out.println("[회원가입 실패]");
		}
	}
}
