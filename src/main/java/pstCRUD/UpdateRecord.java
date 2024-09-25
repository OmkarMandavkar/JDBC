package pstCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateRecord {
	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/course";
		String user = "postgres";
		String password = "root";

		try {
			Class.forName("org.postgresql.Driver");

			Connection connection = DriverManager.getConnection(url, user, password);

			// Statement stm = connection.createStatement();

			String sql = "UPDATE pstdemo SET location = ?  WHERE id=? ";

			PreparedStatement psmt = connection.prepareStatement(sql);
//			psmt.setString(3, "Santacruz");
//			psmt.execute();

		    psmt.setString(1, "Santacruz"); 
		    psmt.setInt(2, 1);
			psmt.execute();

			System.out.println("Record Updated");

			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
