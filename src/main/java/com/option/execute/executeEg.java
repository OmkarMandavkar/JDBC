package com.option.execute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class executeEg {
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
			String s1 = "INSERT INTO student VALUES(6, 'Matt', 8877554422)";
			boolean res1 = stm.execute(s1);
			System.out.println(res1); //false --> resultset is not returning
			
			//QUERY WILL GET EXECUTED
			String s2 = "SELECT * FROM student";
			boolean res2 = stm.execute(s2);
			System.out.println(res2); //true
			
			System.out.println("Query Executed");
			
			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
