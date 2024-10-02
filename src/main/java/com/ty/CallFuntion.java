package com.ty;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallFuntion {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/course?user=postgres&password=root";
		String driver = "org.postgresql.Driver";

		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(url)) {
			
			String bloodGroup = "A+";
			
			CallableStatement cstm = connection.prepareCall("select createByBloodGroup(?)");

			cstm.setString(1, bloodGroup);

			ResultSet rs =  cstm.executeQuery();
			System.out.println("Function is Executed");
			
			if(rs.next()) {
				int res = rs.getInt(1);
				System.out.println("Number of student with BloodGroup" + bloodGroup + " is "+ res);
			}
			else {
				System.out.println("No student found");
			}
//			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
