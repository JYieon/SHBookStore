package 김수지.DB_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import common.DBConnect;
import 김수지.DB_DTO.Basket_DTO;

public class Basket_DAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public Basket_DAO() {
		con = DBConnect.getConnect();
	}

	public ArrayList<Basket_DTO> BasketList(String inputId ) {
		String sql = "select * from Basket where km_id=?";
		ArrayList<Basket_DTO> list = new ArrayList<Basket_DTO>();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, inputId);
	        rs = ps.executeQuery();
			while(rs.next()){
				Basket_DTO dto = new Basket_DTO();
				
				dto.setK_count(rs.getInt("k_count"));
				
				dto.setK_name(rs.getString("k_name"));

				dto.setK_price(rs.getInt("k_price"));

				dto.setK_total_price(rs.getInt("k_total_price"));
				
				dto.setKb_id(rs.getInt("Kb_id"));

				dto.setKm_id(rs.getString("Km_id"));

				list.add(dto);

				for(Basket_DTO d : list) {
					System.out.println(d.getK_count());
					System.out.println(d.getKb_id());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			
		}
		return list;
	}
	public int update( Basket_DTO d ) {
		int result = 0;
		String sql = "update Basket set  K_total_price = ?, kb_id = ?, k_name = ?, k_price = ? k_count where km_id =?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, d.getKm_id());
			ps.setInt(2, d.getKb_id());
			ps.setString(3, d.getK_name());
			ps.setInt(4, d.getK_price());
			ps.setInt(5, d.getK_count());
			ps.setInt(6, d.getK_total_price());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int delete( String b_name ) {
		int result = 0;
		String sql = "delete from Basket where km_id=?";
		try {
			ps = con.prepareStatement(sql);
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	







}



























