package 정성호.login_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DBConnect;
import 정성호.member_dto.MemberDTO;

public class LoginDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public LoginDAO() {
		con = DBConnect.getConnect();
	}
	
	public MemberDTO login(String id,String pwd) {
		MemberDTO dto = null;
		String sql = "select m_id,m_pwd from member where id =";
		return dto;
	}
	
}
