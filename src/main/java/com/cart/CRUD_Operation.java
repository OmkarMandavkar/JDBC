package com.cart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD_Operation {

	private static Connection createConnection() {
		Connection connection = null;

		try {
			Class.forName("org.postgresql.Driver");

			connection = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/cart?user=postgres&password=root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static String save(int id, String name, double price, String description) {
		Connection connection = createConnection();

		try {
			// Updated query with column names
			PreparedStatement pst = connection
					.prepareStatement("INSERT INTO product (id, name, price, description) VALUES (?, ?, ?, ?)");
			pst.setInt(1, id);
			pst.setString(2, name);
			pst.setDouble(3, price);
			pst.setString(4, description);

			pst.execute();
			return "record with id: " + id + " is saved";

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "something went wrong/duplicate key";
	}

	public static void fetch(int id) {
		Connection connection = createConnection();

		try {
			PreparedStatement pst = connection.prepareStatement("SELECT * FROM product WHERE ID = ?");
			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				System.out.println("\nProdut Details");
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getDouble(3));
				System.out.println(rs.getString(4));
			} else {
				System.out.println("Record with given id does not exist");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void fetchAllRecords() {
		Connection connection = createConnection();

		try {
			Statement stm = connection.createStatement();

			ResultSet rs = stm.executeQuery("SELECT * FROM product ORDER BY ID ASC");

			System.out.println("Product Details\n");
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double price = rs.getDouble(3);
				String description = rs.getString(4);

				System.out.println(id);
				System.out.println(name);
				System.out.println(price);
				System.out.println(description);
				System.out.println();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String updateRecords(int id, double price) {
		Connection connection = createConnection();

		try {
			PreparedStatement pst = connection.prepareStatement("UPDATE product SET price = ? WHERE id=?");
			pst.setDouble(1, price);
			pst.setInt(2, id);

			pst.execute();
			return "Records Updated";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Something went wrong:update";
	}

	public static String deleteRecords(int id) {
		Connection connection = createConnection();

		try {
			PreparedStatement pst = connection.prepareStatement("DELETE FROM product WHERE id=?");

			pst.setInt(1, id);

			pst.execute();
			return "Records Updated";

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Something went wrong:delete";
	}

	public static void main(String[] args) {
		// save(101, "Mobile", 20000.00, "iPhone");

		fetchAllRecords();
//		fetch(101);
//		fetch(102);
//		updateRecords(102, 40000.0);
//		fetch(102);
//		deleteRecords(101);
//		fetch(101);
	}
}
