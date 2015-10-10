package com.qige.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int value) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setPassword(rs.getString("password"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setTelphone(rs.getString("telphone"));
		user.setLevel(rs.getInt("level"));
		user.setDepartmentId(rs.getInt("department_id"));
		return user;
	}

}
















