package com.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchExecution {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/course?user=postgres&password=root";
		String driver = "org.postgresql.Driver";

		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection connection = DriverManager.getConnection(url)) {

			Statement stm = connection.createStatement();

			String s1 = "INSERT INTO student VALUES (6, 'Amini', '8877221199')";

			String s2 = "INSERT INTO student VALUES (7, 'Stefhen', '9911557799')";

			String s3 = "INSERT INTO student VALUES (8, 'Rife', '9999999999')";

			String s4 = "DELETE FROM student WHERE sid=7";

			stm.addBatch(s1);
			stm.addBatch(s2);
			stm.addBatch(s3);
			stm.addBatch(s4);

			int[] executeBatch = stm.executeBatch();

			System.out.println("Number of rows affected");
			for (int i = 0; i < executeBatch.length; i++) {
				System.out.print(executeBatch[i] + " ");
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}