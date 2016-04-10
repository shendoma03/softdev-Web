package com.softdev.core.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	protected Connection getConnection() {
		Connection connection = null;
		try {
			String url = "jdbc:mysql://localhost:3306/mydb";
			String user = "root";
			String password = "";
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		System.out.println("Opened database successfully");
		return connection;
	}

	protected void close(PreparedStatement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
				stmt = null;
			} catch (SQLException e) {
			}
		}

	}

	protected void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
			}
		}

	}
	
	protected void close(Connection c){
		if (c != null) {
			try {
				c.close();
				c = null;
			} catch (SQLException e) {
			}
		}
	}
}
