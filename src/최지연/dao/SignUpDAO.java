package 최지연.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import common.DBConnect;
import 정성호.member_dto.MemberDTO;

public class SignUpDAO {
	Connection con = DBConnect.getConnect();
	PreparedStatement ps;
	ResultSet rs;
	MemberDTO dto = null;
	
	public SignUpDAO() {
		con = DBConnect.getConnect();
	}
	
	public int insert(String id, String pwd, String name, Long phone, String addr) {
	    String sql = "INSERT INTO member VALUES (?, ?, ?, ?, ?)";
	    int result = 0;
	    try {
	        ps = con.prepareStatement(sql);
	        ps.setString(1, id);
	        ps.setString(2, pwd);
	        ps.setString(3, name);
	        ps.setString(4, addr);
	        ps.setLong(5, phone); // 전화번호를 Long 타입으로 설정
	        result = ps.executeUpdate();
	    } catch (Exception e) {
	    	System.out.println("이미 사용중인 아이디입니다");
	        e.printStackTrace();
	    }
	    return result;
	}

	
	public boolean phoneCheck(Long phone) {
		dto = new MemberDTO();
		String sql = "select * from member where m_phone=" + phone;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) { //번호가 이미 존재함
				dto.setM_addr(rs.getString("m_phone"));
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
