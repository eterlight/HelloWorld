package com.qige.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
	public static void setCookie(String key,String value,HttpServletResponse response){
		String path = "/";
		int maxAge = 3600*24*7;
		setCookie(key, value, response,maxAge,path);
	}
	public static void setCookie(String key,String value,HttpServletResponse response,int maxAge,String path){
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(maxAge);
		//����·�������·�����ù����¶����Է��ʸ�cookie ���������·������ôֻ�����ø�cookie·��������·�����Է���
		cookie.setPath(path);
		response.addCookie(cookie);
	}
	public static String getCookie(String key,Cookie[] cookies){
		String value = "";
		if(cookies!=null)     
		{     
		    for (int i = 0; i < cookies.length; i++)      
		    {     
		       Cookie c = cookies[i];          
		       if(c.getName().equalsIgnoreCase(key)){     
		    	   value = c.getValue();     
		       }        
		    }      
		}  
		return value;
	}
}
