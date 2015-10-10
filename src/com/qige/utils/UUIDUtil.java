package com.qige.utils;

import java.util.UUID;

public class UUIDUtil {
	public static String createRandomUUID(){
		String uuid = "";
		UUID u = UUID.randomUUID();
		uuid = u.toString();
		return uuid;
	}

}
