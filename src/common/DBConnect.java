package common;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	public static Connection getConnect() { 
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이브 로드 성공");
			String id, pwd, url;
			id = "c##hosystem";
			pwd = "sh0923";
			url = "jdbc:oracle:thin:@192.168.51.10:1521:xe";
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return con;
	}
}
