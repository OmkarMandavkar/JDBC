package com.option.closeConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class closeConnectionEg2 {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/course?user=postgres&password=root";
		String driver = "org.postgresql.Driver";

		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(url)) {

			Statement smt = connection.createStatement();

			String sql = "SELECT * FROM student";
			smt.execute(sql);

			System.out.println("Query Executed");

		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
