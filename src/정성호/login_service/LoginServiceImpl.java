package 정성호.login_service;

import java.util.Scanner;

import 정성호.login_dao.LoginDAO;
import 정성호.member_dto.MemberDTO;

public class LoginServiceImpl implements LoginService {
	LoginDAO dao;
	public LoginServiceImpl() {
		dao = new LoginDAO();
	}
	
	@Override
	public String login() {
		Scanner input = new Scanner(System.in);
		String id,pwd,send_id=null;
		System.out.println("아이디 : ");
		id = input.next();
		System.out.println("비밀번호 :");
		pwd = input.next();
		MemberDTO dto = dao.login(id, pwd);
		if(dto != null) {
			System.out.println(dto.getM_name()+"님 로그인 성공 하셨습니다.");
			send_id = dto.getM_id();
		}else {
			System.out.println("존재하는 id가 없습니다.");
			System.out.println("다시 로그인하세요!!!");
		}
		return send_id;
	}


	@Override
	public MemberDTO logout() {
		System.out.println("로그아웃 하셨습니다.");
		return null;
	}

	@Override
	public MemberDTO login2() {
		Scanner input = new Scanner(System.in);
		String id,pwd;
		System.out.println("아이디 : ");
		id = input.next();
		System.out.println("비밀번호 :");
		pwd = input.next();
		MemberDTO dto = dao.login(id, pwd);
		if(dto == null) {
//			System.out.println("존재하는 id가 없습니다.");
			System.out.println("다시 로그인하세요!!!");
		}else if(dto.getM_id().equals("admin")) {
			System.out.println("관리자 로그인 하셨습니다.");
		}
		else {
			System.out.println(dto.getM_name()+"님 로그인 성공 하셨습니다.");
		}
		return dto;
	}
	
	
	
}
