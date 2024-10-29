package 김수지.DB_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnect;
import 김수지.DB_DTO.Basket_DTO;
import 김수지.DB_DTO.Buy_DTO;

public class Buy_DAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public Buy_DAO() {
		con = DBConnect.getConnect();
	}
	public ArrayList<Buy_DTO> BuyList (String inputId ){
		String sql ="select * from BuyList where lm_id=?";
		ArrayList<Buy_DTO> ls = new ArrayList<Buy_DTO>();

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, inputId);
			rs = ps.executeQuery();

			while(rs.next()){
				Buy_DTO db = new Buy_DTO();

				db.setL_count(rs.getInt("L_count"));

				db.setL_date(rs.getDate("L_date"));

				db.setL_name(rs.getString("L_name"));

				db.setL_num(rs.getInt("L_num"));

				db.setL_price(rs.getInt("L_price"));

				db.setL_total_price(rs.getInt("L_total_price"));

				db.setLb_id(rs.getInt("Lb_id"));

				db.setLm_id(rs.getString("Lm_id"));

				ls.add(db);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}
}




