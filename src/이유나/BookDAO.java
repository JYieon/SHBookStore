package 이유나;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DBConnect;

public class BookDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

    public BookDAO() {
        con = DBConnect.getConnect();
    }
    
    public ArrayList<BookDTO> getList() {
    	 ArrayList<BookDTO> books = new ArrayList<BookDTO>();
    	String sql = "select * from booklist";
    	
    	try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				BookDTO book = new BookDTO();
				book.setId(rs.getInt("b_id"));
				book.setName(rs.getString("b_name"));
				book.setAuthor(rs.getString("b_author")) ;
				book.setPublisher(rs.getString("b_publisher"));
				book.setCategory(rs.getString("b_category"));
				book.setPrice(rs.getInt("b_price"));
				
				books.add(book);
				}
		} catch (Exception e) {
			 e.printStackTrace();
		}
    	return books;
    	
    	
    		
    	
    }
}


















