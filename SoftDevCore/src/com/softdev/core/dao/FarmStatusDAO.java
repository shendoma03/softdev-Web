package com.softdev.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.softdev.core.bean.FarmStatus;
import com.softdev.core.db.DBConnection;

public class FarmStatusDAO extends DBConnection {
	public void addStatus(FarmStatus farmStatus) {
		
		String sql  = "insert into tfarm_section_status (soil_moisture_level, analog_SML, temperature, water_level, create_user, create_date_time, FARM_SECTION_id ) values ( ?, ?, ?, ?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, farmStatus.getSmlvl());
			ps.setDouble(2, farmStatus.getAnalogSmlvl());
			ps.setDouble(3, farmStatus.getTemp());
			ps.setString(4, farmStatus.getWlvl());
			ps.setString(5, "sprinklrws");
			ps.setTimestamp(6, new Timestamp((new Date().getTime())));
			ps.setInt(7, 1);
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error adding farm status");
			throw new RuntimeException(e);
		} finally {
			close(ps);
			close(connection);
		}
	}
	public FarmStatus getLatestStatus() {
		String sql  = "SELECT id, soil_moisture_level, analog_SML, temperature, water_level, create_user, create_date_time, FARM_SECTION_id  FROM tfarm_section_status ORDER BY create_date_time DESC LIMIT 1";
		FarmStatus request = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				request = new FarmStatus();
				request.setFarmStatusId(rs.getInt("id"));
				request.setSmlvl(rs.getString("soil_moisture_level"));
				request.setAnalogSmlvl(rs.getDouble("analog_SML"));
				request.setTemp(rs.getDouble("temperature"));
				request.setWlvl(rs.getString("water_level"));
				request.setCreateUser(rs.getString("create_user"));
				Timestamp dtime = rs.getTimestamp("create_date_time");
				Date date = new Date(dtime.getTime());
				request.setCreateDate(date);
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
	public List<FarmStatus> getMonthlyReport(String month) {
		String sql  = "SELECT soil_moisture_level, analog_SML, temperature, water_level, create_date_time FROM tfarm_section_status WHERE DATE_FORMAT(create_date_time,'%m-%Y') = '"+ month +"-2016'";
		FarmStatus request = null;
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<FarmStatus> results = new ArrayList<FarmStatus>();
		
		try {
			connection = getConnection();
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				request = new FarmStatus();
				request.setSmlvl(rs.getString("soil_moisture_level"));
				request.setAnalogSmlvl(rs.getDouble("analog_SML"));
				request.setTemp(rs.getDouble("temperature"));
				request.setWlvl(rs.getString("water_level"));
				Timestamp dtime = rs.getTimestamp("create_date_time");
				Date date = new Date(dtime.getTime());
				request.setCreateDate(date);
				results.add(request);
			}
			return results;
		} catch (Exception e) {
			System.out.println("Error in retrieving user info");
			throw new RuntimeException(e);
		} finally {
			close(rs);
			close(ps);
			close(connection);
		}
	}
	
}
