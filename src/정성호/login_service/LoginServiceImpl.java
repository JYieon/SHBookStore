package 정성호.login_service;

import java.util.Scanner;

import 정성호.member_dto.MemberDTO;

public class LoginServiceImpl implements LoginService {

	
	
	@Override
	public void login() {
		Scanner input = new Scanner(System.in);
		String id,pwd;
		System.out.println("아이디 : ");
		id = input.next();
		System.out.println("비밀번호 :");
		pwd = input.next();
		MemberDTO dto;
	}
	
}
