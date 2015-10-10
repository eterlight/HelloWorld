package com.qige.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.qige.dao.inter.JDBCUserOperationInterface;
import com.qige.entity.User;
import com.qige.entity.UserRowMapper;

@Service
public class JDBCUserOperation implements JDBCUserOperationInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public User findUserById(int id) {
		User user = null;
		String sql = "SELECT * FROM user WHERE id="+id;
		
		try{
			user = jdbcTemplate.queryForObject(sql, new UserRowMapper());
		}catch(Exception e){
			System.out.println("���idδ�ܻ�ȡ��User����");
		}
		return user;
	}

	@Override
	public User findUser(String name, String password) {
		User user = null;
		String sql = "SELECT * FROM user WHERE name='"+name+"' and password='"+password+"'";
		try{
			user = jdbcTemplate.queryForObject(sql, new UserRowMapper());
		}catch(Exception e){
			System.out.println("���name��passwordδ�ܻ�ȡ��User����");
		}
		
		return user;
	}

	@Override
	public User findUserByUUID(String uuid, int id) {
		User user = null;
		String sql = "SELECT * FROM user where id='"+id+"' and autologin='"+uuid+"'";
		System.out.println("Method findUserByUUID's sql::"+ sql);
		try{
			user = jdbcTemplate.queryForObject(sql, new UserRowMapper());
		}catch(Exception e){
			System.out.println("���id��autologinδ�ܻ�ȡ��User����");
		}
		return user;
	}

	@Override
	public User updateUserWithAtuoLogin(String autologin, int id) {
		User user = null;
		String sql = "UPDATE user SET autologin='"+autologin+"' WHERE id="+id;
		
		try{
			int affect = jdbcTemplate.update(sql);
			if(affect == 1){
				user = findUserById(id);
			}
			
		}catch(Exception e){
			System.out.println("���autologinδ�ܸ�����User����");
		}
		return user;
	}

	@Override
	public User updateUserSetALEmp(int id) {
		User user = null;
		String sql = "UPDATE user SET autologin='' WHERE id="+id;
		
		try{
			int affect = jdbcTemplate.update(sql);
			if(affect == 1){
				user = findUserById(id);
			}
			
		}catch(Exception e){
			System.out.println("���Զ���¼�����ÿղ���ʧ����");
		}
		return user;
	}

}
