package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertRecord {
	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/course";
		String user = "postgres";
		String password = "root";
		
		try {
			// STEP-1: LOADING THE DRIVER
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver is Loaded");

			// STEP-2: CREATE THE CONNECTION
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connection is Created");

			// STEP-3: CREATE STATEMENT
			Statement stm = connection.createStatement();
			System.out.println("Statement is created");

			String sql = "INSERT INTO student VALUES(3, 'Jeff', 3434235355)";

			// STEP-4: EXECUTE THE QUERY			
			stm.execute(sql);
			System.out.println("Record Inserted");
			
			//STEP 5: CLOSE THE CONNECTION
			connection.close();
			System.out.println("Connection closed");
			
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
