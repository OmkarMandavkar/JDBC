package pstCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecord {
	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/course";
		String user = "postgres";
		String password = "root";

		try {
			Class.forName("org.postgresql.Driver");

			Connection connection = DriverManager.getConnection(url, user, password);

			String sql = "DELETE FROM pstdemo WHERE id=? ";

			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setInt(1,4);
			psmt.execute();
			
			System.out.println("Record Deleted");

			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
