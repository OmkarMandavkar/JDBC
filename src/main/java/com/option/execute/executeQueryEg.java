package com.option.execute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class executeQueryEg {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/course";
		String user = "postgres";
		String password = "root";
		String driver = "org.postgresql.Driver";

		try {
			Class.forName(driver);

			Connection connection = DriverManager.getConnection(url, user, password);

			Statement stm = connection.createStatement();
			
			//QUERY WILL NOT GET EXECUTED
			String s1 = "INSERT INTO student VALUES(7, 'Matt', 8877554422)";
//			stm.executeQuery(s1); //Exception
			
			//QUERY WILL GET EXECUTED
			String s2 = "SELECT * FROM student";
			ResultSet rs = stm.executeQuery(s2); //DATA RETRIVED
			
			System.out.println("***  FETCHED DATA  ***\n");
			while (rs.next()) {
				int sid = rs.getInt(1);
				String name = rs.getString(2);
				long phone = rs.getLong(3);
				
				System.out.println(sid);
				System.out.println(name);
				System.out.println(phone);
				System.out.println();
			}
			
			System.out.println("Query Executed");
			
			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
