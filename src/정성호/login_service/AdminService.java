package 정성호.login_service;

import 정성호.member_dto.MemberDTO;

public interface AdminService {
	public MemberDTO logout();
	public void memberadd();
	public void memberupdate();
	public void allmember();
	public MemberDTO membersearch();
	public void memberdelete();
	public MemberDTO adminstart();
}
