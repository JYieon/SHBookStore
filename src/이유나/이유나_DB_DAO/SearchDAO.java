package 이유나.이유나_DB_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnect;
import 이유나.이유나_DB_DTO.BookDTO;
import 이유나.이유나_DB_DTO.SearchDTO;
import 정성호.member_dto.MemberDTO;

public class SearchDAO {
	Connection con = DBConnect.getConnect();
	PreparedStatement ps;
	ResultSet rs;
	
	
	public SearchDAO() {
		con = DBConnect.getConnect();
	}
	
	public ArrayList<SearchDTO> searchBook(String name) {
		ArrayList<SearchDTO> books = new ArrayList<SearchDTO>();
		String sql = "select * from booklist where b_name = '" + name +"'";
	
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while(rs.next()) {
		
				SearchDTO book = new SearchDTO();
				
				book.setName(rs.getString("b_name"));
				book.setAuthor(rs.getString("b_author"));
				book.setPublisher(rs.getString("b_publisher"));
				book.setCategory(rs.getString("b_category"));
				
				books.add(book);
				
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return books;
	}
	public void searchAuthor(String author) {
		
	}
	public void searchPublisher(String publisher) {
		
	}
	public void searchname(String name) {
		
	}
	public void searchcategory(String category) {
		
	}
}
