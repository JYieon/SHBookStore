package 최지연.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnect;

public class SignUpDAO {
	Connection con = DBConnect.getConnect();
	PreparedStatement ps;
	ResultSet rs;
	
	public SignUpDAO() {
		con = DBConnect.getConnect();
	}
	
	public int insert(String id, String pwd, String name, String phone, String addr) {
		String sql = "insert into member values(?, ?, ?, ?, ?)";
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			ps.setString(3, name);
			ps.setString(4, addr);
			ps.setString(5, phone);
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("동일한 아이디가 존재합니다");
			e.printStackTrace();
		}
		return result;
	}
}
