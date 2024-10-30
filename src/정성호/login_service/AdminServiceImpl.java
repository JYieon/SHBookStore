package 정성호.login_service;

import java.util.ArrayList;
import 최지연.service.*;
import java.util.Scanner;

import 김수지.DB_DAO.Basket_DAO;
import 정성호.login_dao.AdminDAO;
import 정성호.member_dto.MemberDTO;
import 정성호.login_service.*;

public class AdminServiceImpl implements AdminService{
	Scanner input = new Scanner(System.in);
	AdminDAO dao;
	Basket_DAO dao2 = new Basket_DAO();
	LoginServiceImpl lo = new LoginServiceImpl();
	boolean bool = true;
	
	public AdminServiceImpl() {
		dao = new AdminDAO();
	}
	
	
	@Override
	public MemberDTO adminstart() {
		while(bool) {
			System.out.println("1. 로그아웃"); //정성호
			System.out.println("2. 회원 추가"); 
			System.out.println("3. 회원 수정"); 	
			System.out.println("4. 전체 회원 보기");
			System.out.println("5. 회원 찾기");
			System.out.println("6. 회원 삭제");
			System.out.print(">>> ");
			int num = input.nextInt();
			switch(num){
			case 1: // 로그아웃
				lo.logout();
				System.out.println("[관리자 로그아웃 하셨습니다]");
				bool = false;
				break;
			case 2: //회원 추가
				memberadd();
				break;
			case 3: //회원 수정
				memberupdate();
				break;
			case 4: // 전체 회원 보기
				allmember();
				break;
			case 5: // 회원 찾기
				MemberDTO m = new MemberDTO();
				m = membersearch();
				if(m != null) {
				System.out.println("이름 : " + m.getM_name());
				System.out.println("전화번호 : " + m.getM_phone());
				System.out.println("주소 : " + m.getM_addr());
				System.out.println("id : " + m.getM_id());
				System.out.println("pwd : " + m.getM_pwd());
				}else {
					
				}
				break;
			case 6: // 회원 삭제
				memberdelete();
				break;
				}
		}
		return null;
	}


	@Override
	public MemberDTO logout() {
		System.out.println("관리자 로그아웃 하셨습니다.");
		return null;
	}

	@Override
	public void memberadd() {
		SignUpServiceImpl sign = new SignUpServiceImpl();
		sign.signUp();
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
			String phone = input.next();
			if(phone == null) {
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
			dao2.delete(id);
		}
	}
	
}
