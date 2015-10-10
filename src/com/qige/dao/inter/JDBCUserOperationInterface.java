package com.qige.dao.inter;

import com.qige.entity.User;

public interface JDBCUserOperationInterface {
	User findUserById(int id);
	User findUser(String name,String password);
	User findUserByUUID(String uuid,int id);
	User updateUserWithAtuoLogin(String autologin,int id);
	User updateUserSetALEmp(int id);
}
