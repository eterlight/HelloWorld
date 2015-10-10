package com.qige.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MeetingRoomRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int value) throws SQLException {
		MeetingRoom mr = new MeetingRoom();
		mr.setId(rs.getInt("id"));
		mr.setName(rs.getString("name"));
		mr.setPosition(rs.getString("position"));
		mr.setLarge(rs.getInt("large"));
		mr.setProjector(rs.getString("projector"));
		mr.setAvailable(rs.getString("available"));
		return mr;
	}

}
















