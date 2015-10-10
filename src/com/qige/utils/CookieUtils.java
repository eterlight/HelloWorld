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
		//设置路径，这个路径即该工程下都可以访问该cookie 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
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
