package 전영민.service;

import 정성호.member_dto.MemberDTO;

public interface UpdateDeleteService {
	public void update(MemberDTO d);
	public int delete(MemberDTO d);
	public MemberDTO UpdateDelete(MemberDTO d);
}