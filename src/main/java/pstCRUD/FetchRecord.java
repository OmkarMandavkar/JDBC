package pstCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchRecord {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/course";
		String user = "postgres";
		String password = "root";

		try {

			Class.forName("org.postgresql.Driver");

			Connection connection = DriverManager.getConnection(url, user, password);

			String sql = "select * from pstdemo";
			PreparedStatement pstm = connection.prepareStatement(sql);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String location = rs.getString(3);

				System.out.println(id);
				System.out.println(name);
				System.out.println(location);
				System.out.println();
			}

			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
