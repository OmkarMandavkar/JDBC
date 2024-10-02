package com.ty;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallProcedure {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/course?user=postgres&password=root";
		String driver = "org.postgresql.Driver";

		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(url)) {
			CallableStatement cstm = connection.prepareCall("CALL insert_student_data(?,?,?,?,?)");

			cstm.setInt(1, 33);
			cstm.setString(2, "Dummy");
			cstm.setString(3, "CS");
			cstm.setString(4, "ANDHERI");
			cstm.setString(5, "B+");

			cstm.execute();
			System.out.println("Procedure is Executed");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
