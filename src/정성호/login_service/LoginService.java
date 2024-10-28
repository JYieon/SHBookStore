package 정성호.login_service;

import 정성호.member_dto.MemberDTO;

public interface LoginService {
	public String login();
	public MemberDTO login2();
	public MemberDTO logout();
}
