package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnect() { 
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String id, pwd, url;
			id = "c##hosystem";
			pwd = "sh0923";
			url = "jdbc:oracle:thin:@192.168.51.10:1521:xe";
			con = DriverManager.getConnection(url, id, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return con;
	}
}
