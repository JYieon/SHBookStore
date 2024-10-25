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
		String sql = "SELECT * from member where m_id= ? and m_pwd = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
//			 System.out.println("Executing query: " + sql + " with id: " + id + " and pwd: " + pwd);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setM_id(rs.getString("m_id"));
				dto.setM_name(rs.getString("m_name"));
				dto.setM_pwd(rs.getString("m_pwd"));
			}else {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
}
