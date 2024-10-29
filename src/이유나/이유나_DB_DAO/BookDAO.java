package 이유나.이유나_DB_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DBConnect;
import 이유나.이유나_DB_DTO.*;
import 정성호.member_dto.MemberDTO;

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
				book.setPrice(rs.getInt("b_price"));
				
				books.add(book);
				}
		} catch (Exception e) {
			 e.printStackTrace();
		}
    	return books;
    	
    	
    		
    	
    }
    public int cart(BookDTO b2,int b_count,String u_id) {
    	int result =0;
    	String sql = "insert into basket values(?, ?, ?, ?, ?)";
    	
    	try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,u_id);
			ps.setInt(2, b2.getB_id());
			ps.setString(3, b2.getName());
			ps.setInt(4, b2.getPrice());
			ps.setInt(5, b_count);
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
    }
    public int buy(BookDTO b2,int b_count,String u_id) {
    	int result =0;
    	String sql = "insert into buylist values(buylist_SEQ.nextval,?, ?, ?, ?, ?,?,sysdate)";
    	
    	try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1,u_id);
			ps.setInt(2, b2.getB_id());
			ps.setString(3, b2.getName());
			ps.setInt(4, b2.getPrice());
			ps.setInt(5, b_count);
			ps.setInt(6, b_count * b2.getPrice());
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return result;
    } 
}


















