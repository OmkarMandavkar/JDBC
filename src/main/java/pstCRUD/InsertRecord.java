package pstCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRecord {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/course";
		String user = "postgres";
		String password = "root";

		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection(url, user, password);
			
			String sql = "INSERT INTO pstdemo VALUES(?,?,?)";

			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1, 1);
			pstm.setString(2, "John");
			pstm.setString(3, "Andheri");

//			pstm.setInt(1, 2);
//			pstm.setString(2, "Doe");
//			pstm.setString(3, "Bandra");
			
//			pstm.setInt(1, 3);
//			pstm.setString(2, "Victor");
//			pstm.setString(3, "Pali Hill");
			
//			pstm.setInt(1, 4);
//			pstm.setString(2, "Sara");
//			pstm.setString(3, "Versova");
			
			pstm.execute();
			System.out.println("Data Inserted");

			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}