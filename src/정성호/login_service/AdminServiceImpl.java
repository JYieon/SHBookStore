package 정성호.login_service;

import java.util.ArrayList;
import java.util.Scanner;

import 정성호.login_dao.AdminDAO;
import 정성호.member_dto.MemberDTO;

public class AdminServiceImpl implements AdminService{
	Scanner input = new Scanner(System.in);
	AdminDAO dao;
	
	public AdminServiceImpl() {
		dao = new AdminDAO();
	}
	
	@Override
	public MemberDTO logout() {
		System.out.println("관리자 로그아웃 하셨습니다.");
		return null;
	}

	@Override
	public void memberadd() {
		System.out.println("[회원 추가]");
		System.out.print("회원 이름\t\t: ");
		String name = input.next();
		System.out.print("회원 전화번호(-제외)\t: "); //동일한 전화번호 가입못하도록 할 것
		int phone = input.nextInt();
		System.out.print("회원 주소\t\t: ");
		String addr = input.next();
		System.out.print("회원 id\t\t: ");
		String id = input.next();
		System.out.print("회원 pwd\t\t: ");
		String pwd = input.next();
		
		int result = dao.m_add(id, pwd, name, phone, addr);
		if(result == 1) {
			System.out.println("[회원추가 성공]");
		}else {
			System.out.println("[회원추가 실패]");
		}
	}

	@Override
	public void memberupdate() {
		System.out.println("[회원 수정]");
		System.out.print("수정하고 싶은 회원 id\t\t: ");
		String id = input.next();
		MemberDTO u_dto = dao.m_search(id);
		if(u_dto != null) {
			System.out.print("변결 할 회원 이름\t\t: ");
			String name = input.next();
			if(name == null) {
				name = u_dto.getM_name();
			}
			System.out.print("회원 전화번호(-제외)\t: "); //동일한 전화번호 가입못하도록 할 것
			int phone = input.nextInt();
			if(phone == 0) {
				phone = u_dto.getM_phone();
			}
			System.out.print("회원 주소\t\t: ");
			String addr = input.next();
			if(addr == null) {
				addr = u_dto.getM_name();
			}
			System.out.print("회원 pwd\t\t: ");
			String pwd = input.next();
			if(pwd == null) {
				pwd = u_dto.getM_name();
			}
			int result = dao.m_update(id,pwd,name,phone,addr);
		}
		
	}

	@Override
	public void allmember() {
		System.out.println("[전체 회원 보기]");
		ArrayList<MemberDTO> list = dao.m_alllist();
		for(int i=0; i < list.size(); i++) {
			MemberDTO d = list.get(i);
			System.out.println("이름 : " + d.getM_name());
			System.out.println("전화번호 : " + d.getM_phone());
			System.out.println("주소 : " + d.getM_addr());
			System.out.println("id : " + d.getM_id());
			System.out.println("pwd : " + d.getM_pwd());
			System.out.println("--------------------------------");
		}
	}

	@Override
	public MemberDTO membersearch() {
		System.out.println("[회원 찾기]");
		System.out.print("검색 할 회원 id\t\t: ");
		String id = input.next();
		MemberDTO dto = dao.m_search(id);
		if(dto == null) {
//			System.out.println("존재하는 id가 없습니다.");
		}else {
			System.out.println(dto.getM_name()+"님의 정보입니다.");
		}
		return dto;
	}

	@Override
	public void memberdelete() {
		System.out.println("[회원 삭제]");
		System.out.print("삭제 할 회원 id\t\t: ");
		String id = input.next();
		int result = dao.m_delete(id);
		if(result == 0) {
			System.out.println("해당 아이디가 없습니다.");
		}else {
			System.out.println(id +"삭제 완료");
		}
	}
	
}
