package co.friend.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	public Connection conn;
	
	protected DAO(){
		String url = "jdbc:sqlite:C:/sqlite/db/dd.db";
		try {
			conn =  DriverManager.getConnection(url);
			System.out.println("연결성공!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
