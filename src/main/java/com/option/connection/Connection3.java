package com.option.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connection3 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("db.properties");

			Properties properties = new Properties();
			properties.load(fin);

			String url = properties.getProperty("url");

			String driver = properties.getProperty("driver");

			System.out.println(url);
			System.out.println(driver);

			Class.forName(driver);

			Connection connection = DriverManager.getConnection(url, properties);

			System.out.println("Driver loaded and connection is created");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}