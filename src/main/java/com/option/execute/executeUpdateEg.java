package com.option.execute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class executeUpdateEg {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/course";
		String user = "postgres";
		String password = "root";
		String driver = "org.postgresql.Driver";

		try {
			Class.forName(driver);

			Connection connection = DriverManager.getConnection(url, user, password);

			Statement stm = connection.createStatement();

			//QUERY WILL GET EXECUTED
			String s1 = "INSERT INTO student VALUES(11, 'Matt', 8877554422)";
			int update = stm.executeUpdate(s1);
			System.out.println("Rows Affected: "+update);
			
			//QUERY WILL NOT GET EXECUTED
			String s2 = "SELECT * FROM student";
//			stm.executeUpdate(s2);
			//org.postgresql.util.PSQLException: A result was returned when none was expected.
			
			String s3 = "UPDATE student SET name = 'Martin' where phone=8877554422";
			stm.executeUpdate(s3);
					
			System.out.println("Query Executed");
			
			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
