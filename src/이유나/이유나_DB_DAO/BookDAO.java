package 이유나.이유나_DB_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DBConnect;
import 김수지.DB_DAO.Basket_DAO;
import 김수지.DB_DTO.Basket_DTO;
import 이유나.이유나_DB_DTO.*;
import 정성호.member_dto.MemberDTO;

public class BookDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int jumun = 0;
	
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
    	String sql = "insert into buylist values((SELECT COALESCE(MAX(l_num), 0) + 1 FROM buylist),?, ?, ?, ?, ?,?,sysdate)";
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
    public int all_buy(String u_id) {
    	int result = 0;
    	
    	Basket_DAO dao = new Basket_DAO();
    	ArrayList<Basket_DTO> list = dao.BasketList(u_id);
    	String sql2 = "SELECT COALESCE(MAX(l_num), 0) FROM buylist";
    	try {
			PreparedStatement ps = con.prepareStatement(sql2);
			rs = ps.executeQuery();
			while(rs.next()) {
				jumun = rs.getInt("l_num");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    	String sql = "insert into buylist values(?,?, ?, ?, ?, ?,?,sysdate)";
    	for(Basket_DTO bk : list) {
    		try {
    			PreparedStatement ps = con.prepareStatement(sql);
    			
    			ps.setInt(1, jumun+1);
    			ps.setString(2, bk.getKm_id());
    			ps.setInt(3, bk.getKb_id());
    			ps.setString(4, bk.getK_name());
    			ps.setInt(5, bk.getK_price());
    			ps.setInt(6, bk.getK_count());
    			ps.setInt(7, bk.getK_count() * bk.getK_price());
    			result = ps.executeUpdate();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	return result;
    	
    }
}


















