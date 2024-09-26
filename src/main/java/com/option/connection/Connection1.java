package com.option.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection1 {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/course";
		String user = "postgres";
		String password = "root";
		String driver = "org.postgresql.Driver";
		Connection connection = null;

		try {
			Class.forName(driver);

			connection = DriverManager.getConnection(url, user, password);

			Statement stm = connection.createStatement();

			String s2 = "SELECT * FROM student";
			stm.execute(s2);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
					System.out.println("Connection Closed");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
