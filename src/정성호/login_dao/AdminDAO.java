package 정성호.login_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnect;
import 정성호.member_dto.MemberDTO;

public class AdminDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public AdminDAO() {
		con = DBConnect.getConnect();
	}
	public int m_add(String id, String pwd, String name, int phone, String addr) {
		int result=0;
		String sql = "insert into member values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			ps.setString(3, name);
			ps.setString(4, addr);
			ps.setInt(5, phone);
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("동일한 아이디가 존재합니다");
			e.printStackTrace();
		}
		return result;
	}
	public int m_update(String id, String pwd, String name, int phone, String addr) {
		String sql = "update member set m_name = ?, m_phone = ?, m_addr = ?, m_pwd = ? where m_id = ?";
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, phone);
			ps.setString(3, addr);
			ps.setString(4, pwd);
			ps.setString(5, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("동일한 아이디가 존재합니다");
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<MemberDTO> m_alllist() {
		String sql = "select * from member";
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setM_id(rs.getString("m_id"));
				dto.setM_name(rs.getString("m_name"));
				dto.setM_pwd(rs.getString("m_pwd"));
				dto.setM_addr(rs.getString("m_addr"));
				dto.setM_phone(rs.getInt("m_phone"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public MemberDTO m_search(String id) {
		MemberDTO dto = null;
		String sql = "SELECT * from member where m_id= ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
//			 System.out.println("Executing query: " + sql + " with id: " + id + " and pwd: " + pwd);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setM_id(rs.getString("m_id"));
				dto.setM_name(rs.getString("m_name"));
				dto.setM_pwd(rs.getString("m_pwd"));
				dto.setM_addr(rs.getString("m_addr"));
				dto.setM_phone(rs.getInt("m_phone"));
			}else {
				System.err.println("해당 아이디가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public int m_delete(String id) {
		int result =0;
		String sql = "delete from member where m_id= ?";
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1,id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
}
