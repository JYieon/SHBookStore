package 정성호_login_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DBConnect;

public class LoginDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public LoginDAO() {
		con = DBConnect.getConnect();
	}
	
	
}
