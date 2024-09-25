package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchRecords {
	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/course";
		String user = "postgres";
		String password = "root";

		try {

			// STEP1
			Class.forName("org.postgresql.Driver");

			// STEP2
			Connection connection = DriverManager.getConnection(url, user, password);

			// STEP3
			Statement stm = connection.createStatement();
			String sql = "select * from student";

			// STEP4
			ResultSet rs = stm.executeQuery(sql);

			System.out.println("***  Student Details  ***");
			while (rs.next()) {
				int student_id = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				
				System.out.println(student_id);
				System.out.println(name);
				System.out.println(email);
				System.out.println();
			}

			// STEP5
			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}