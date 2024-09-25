package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecord {
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
			
			String sql = "DELETE FROM student WHERE sid=3 ";

			// STEP-4: EXECUTE THE QUERY			
			stm.execute(sql);
			System.out.println("Record Deleted");
			
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
