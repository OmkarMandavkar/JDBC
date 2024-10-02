package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class transactionManagement {
	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/course?user=postgres&password=root";
		String driver = "org.postgresql.Driver";

		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(url)) {

			String sql = "INSERT INTO student VALUES (9, 'Warren', 9977443322)";
			connection.setAutoCommit(false);

			Statement smt = connection.createStatement();

			smt.execute(sql);
			System.out.println("Query Executed");
						
			if(true) {
				connection.commit();
				System.out.println("Record Saved");
				return;
			}
			connection.rollback();	//used to roolback
			System.out.println("ROllback / not saved");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
