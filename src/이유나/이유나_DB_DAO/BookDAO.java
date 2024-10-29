package 이유나;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import common.DBConnect;
import 이유나.이유나_DB_DTO.BookDTO;

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
				book.setB_id(rs.getInt("b_id"));
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
    public int cart(BookDTO b2 ) {
    	int result =0;
    	String sql = "insert into basket values(?, ?, ?, ?, ?, ?)";
    	
    	try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, b2.getM_id() );
			ps.setInt(2, b2.getB_id());
			ps.setString(3, b2.getName());
			ps.setInt(4, b2.getPrice());
			ps.setInt(5, b2.getCount());
			ps.setInt(6, b2.getTotal());
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("동일한 아이디가 존재합니다");
			e.printStackTrace();
		}
		return result;
    }
}


















