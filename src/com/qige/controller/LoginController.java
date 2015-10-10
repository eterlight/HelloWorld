package com.qige.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

import com.qige.dao.inter.JDBCUserOperationInterface;
import com.qige.entity.User;
import com.qige.utils.CookieUtils;
import com.qige.utils.UUIDUtil;

@Controller
@Scope("prototype")
public class LoginController {
	@Autowired
	private JDBCUserOperationInterface jdbcOperatrionInterface;
	private ModelAndView mav = new ModelAndView();
	
	@RequestMapping(value="loginin.do",method=RequestMethod.POST)
	public String login(@RequestParam String username,@RequestParam String password,@RequestParam(required=false,value="checkbox") String[] checkbox, HttpServletRequest request,HttpServletResponse response){
		System.out.println("username="+username+",pwd="+password+",checkbox="+checkbox);
		String returningStr = "";
		Cookie[] cookies = request.getCookies(); 
		String autoLogin = CookieUtils.getCookie("autologin", cookies);
		String userId = CookieUtils.getCookie("user", cookies);
		if(!"".equals(autoLogin) && !"".equals(userId) && userId!=null){
			User validUser = jdbcOperatrionInterface.findUserByUUID(autoLogin, Integer.parseInt(userId));
			if(validUser!=null){
				returningStr = "index_mr";
			}
		}else{
			 if(username!=null && password!=null){
				User user = jdbcOperatrionInterface.findUser(username, password);
				if(user != null){
					request.getSession().setAttribute("userObj", user);
					returningStr = "index_mr";
					System.out.println("returningStr="+returningStr);
					if(checkbox!=null && !"".equals(checkbox[0])){
						String uuid = UUIDUtil.createRandomUUID();
						CookieUtils.setCookie("autologin", uuid, response);
						CookieUtils.setCookie("user", String.valueOf(user.getId()), response);
						jdbcOperatrionInterface.updateUserWithAtuoLogin(uuid, user.getId());
					}else{
						CookieUtils.setCookie("autologin", null, response, 0, "/");
						CookieUtils.setCookie("user", null, response,0,"/");
						jdbcOperatrionInterface.updateUserSetALEmp(user.getId());
					}
				}else{
					request.setAttribute("message", "用户名或密码不正确");
					response.setHeader("contentType", "text/html; charset=utf-8");
					returningStr = "login/login";
				}
			}else if(userId==null || "".equals(userId)){
				request.setAttribute("message", "请重新登录");
				response.setHeader("contentType", "text/html; charset=utf-8");
				returningStr = "login/login";
			}
			
		}
		
		return returningStr;
	}

}
