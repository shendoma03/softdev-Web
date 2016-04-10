package com.softdev.core.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.softdev.core.bean.User;
import com.softdev.core.db.DBConnection;

public class UserDAO extends DBConnection {

	public User getByUserName(String userName) {
		
		String sql  = "SELECT id, fname, lname, username, password, type FROM user WHERE username = ?";
		User user = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFname(rs.getString("fname"));
				user.setLname(rs.getString("lname"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setType(rs.getString("type"));
				
			}
			
		} catch (Exception e) {
			System.out.println("Error in retrieving user info");
			throw new RuntimeException(e);
		} finally {
			close(rs);
			close(ps);
			close(connection);
		}
		return user;
		//return null;
	}
	
	public User addUser(User user) {
		
		String sql  = "insert into user (fname, lname, username, password, type, FARM_id ) values ( ?, ?, ?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, user.getFname());
			ps.setString(2, user.getLname());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setString(5, "U");
			ps.setInt(6, 1);
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error adding user info");
			throw new RuntimeException(e);
		} finally {
			close(ps);
			close(connection);
		}
		return user;
		//return null;
	}
	
}
