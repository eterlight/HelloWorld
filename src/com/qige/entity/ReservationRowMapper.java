package com.qige.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ReservationRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int value) throws SQLException {
		Reservation rv = new Reservation();
		rv.setId(rs.getInt("id"));
		rv.setMrId(rs.getInt("mr_id"));
		rv.setUserId(rs.getInt("user_id"));
		rv.setUser_name(rs.getString("user_name"));
		rv.setStart_booktime(rs.getString("start_booktime"));
		rv.setTime(rs.getString("time"));
		return rv;
	}

}
















