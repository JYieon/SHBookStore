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
	String where;
	
	
	public SearchDAO() {
		con = DBConnect.getConnect();
	}
	
	public ArrayList<BookDTO> searchBook(int num, String name) {
		switch(num) {
		case 1: //책제목
			where = "b_name";
			break;
		case 2: //작가이름
			where = "b_author";
			break;
		case 3 : // 출판사
			where = "b_publisher";
			break;
		case 4 : // 카테고리
			where = "b_category";
			break;
		}
		ArrayList<BookDTO> books = new ArrayList<BookDTO>();
		BookDTO book = new BookDTO();
		String sql = "select * from booklist where "+where+" like '%" + name +"%'";
	
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while(rs.next()) {
		
				book.setB_id(rs.getInt("b_id"));
				book.setName(rs.getString("b_name"));
				book.setAuthor(rs.getString("b_author"));
				book.setPublisher(rs.getString("b_publisher"));
				book.setCategory(rs.getString("b_category"));
				book.setPrice(rs.getInt("b_price"));
				
				books.add(book);
				
			}
		} catch (Exception e) {
			
		}
		return books;
	}

}
