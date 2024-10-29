package 최지연.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import common.DBConnect;
import 정성호.member_dto.MemberDTO;

public class SearchDAO {
	Connection con = DBConnect.getConnect();
	PreparedStatement ps;
	ResultSet rs;
	MemberDTO dto = null;
	
	public SearchDAO() {
		con = DBConnect.getConnect();
	}
	
	public void searchBook(String book) {
		String sql = "select * from booklist where b_name = '" + book +"'";
		try {
			ps = con.prepareStatement(sql); 
			rs = ps.executeQuery(); 
			if(rs.next()) {
				dto = new MemberDTO();
			}
		} catch (Exception e) {
			
		}
	}
	public void searchAuthor(String author) {
		
	}
	public void searchPublisher(String publisher) {
		
	}
}
