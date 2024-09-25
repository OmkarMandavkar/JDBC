package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateRecord {
	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/course";
		String user = "postgres";
		String password = "root";
		
		try {
			// STEP-1: LOADING THE DRIVER
			Class.forName("org.postgresql.Driver");
			
			// STEP-2: CREATE THE CONNECTION
			Connection connection = DriverManager.getConnection(url, user, password);
			
			// STEP-3: CREATE STATEMENT
			Statement stm = connection.createStatement();
			
			String sql = "UPDATE student SET phone = 9876543210 WHERE sid=3 ";

			// STEP-4: EXECUTE THE QUERY			
			stm.execute(sql);
			System.out.println("Record Updated");
			
			//STEP 5: CLOSE THE CONNECTION
			connection.close();
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
