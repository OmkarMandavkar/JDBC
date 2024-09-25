package com.option.closeConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class closeConnectionEg2 {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/course";
		String user = "postgres";
		String password = "root";
		String driver = "org.postgresql.Driver";
		Connection connection = null;

		try {
			Class.forName(driver)

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		
		try() {
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (connection != null) {
					connection.close();
					System.out.println("Query Executed and Connection Closed");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
