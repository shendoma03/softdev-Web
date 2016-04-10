package com.softdev.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

import com.softdev.core.bean.SprinklerRequest;
import com.softdev.core.db.DBConnection;

public class SprinklerRequestDAO extends DBConnection {
	
	public void create(SprinklerRequest request) {
		String sql = "INSERT INTO sprinkler_request (status, operation, create_user, sprinkler_id) values (?, ?, ?, ?)"; 

		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, request.getStatus());
			ps.setBoolean(2, request.isOperation());
			ps.setString(3, request.getCreateUser());
			ps.setInt(4, 1);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error creating sprinkler request.");
			throw new RuntimeException(e);
		} finally {
			close(ps);
			close(connection);
		}
	}
	
	public SprinklerRequest getPendingSprinklerRequest() {
		String sql  = "SELECT id, status, operation, create_user, create_datetime FROM sprinkler_request WHERE status = 'NEW' ORDER BY create_datetime DESC";
		SprinklerRequest request = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				request = new SprinklerRequest();
				request.setSprinklerId(rs.getInt("id"));
				request.setStatus(rs.getString("status"));
				request.setOperation(rs.getBoolean("operation"));
				request.setCreateUser(rs.getString("create_user"));
				request.setCreateDate(rs.getDate("create_datetime"));
			}
			return request;
		} catch (Exception e) {
			System.out.println("Error in retrieving user info");
			throw new RuntimeException(e);
		} finally {
			close(rs);
			close(ps);
			close(connection);
		}
	}
	
	public void updatePendingRequest(String status, Integer rejectedByRequestId, String updateUser, int requestId) {
		String sql = "UPDATE sprinkler_request SET status=?, rejected_by_req_id=?, update_user=?, update_datetime=? WHERE id = " + requestId; 

		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1, status);
			ps.setObject(2, rejectedByRequestId);
			ps.setString(3, updateUser);
			ps.setTimestamp(4, new Timestamp((new Date().getTime())));
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error creating sprinkler request.");
			throw new RuntimeException(e);
		} finally {
			close(ps);
			close(connection);
		}
	}
}
