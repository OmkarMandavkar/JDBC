package com.option.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementEx {
	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/course";
		String user = "postgres";
		String password = "root";

		try {
			// STEP-1:
			Class.forName("org.postgresql.Driver");

			// STEP-2:
			Connection connection = DriverManager.getConnection(url, user, password);

			// STEP-3:
			String sql = "INSERT INTO student VALUES(?,?,?)";

			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, 4);
			pstm.setString(2, "ExCali");
			pstm.setLong(3, 5544338899L);

			// STEP-4:
			pstm.execute();
			System.out.println("Data Inserted");

			// STEP 5:
			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
