package com.qige.controller;

import java.util.List;
import java.util.Map;

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

import com.qige.dao.inter.JDBCMeetingRoomOperationInterface;
import com.qige.dao.inter.JDBCUserOperationInterface;
import com.qige.entity.User;
import com.qige.utils.CookieUtils;
import com.qige.utils.UUIDUtil;

@Controller
public class HeaderController {
	@Autowired
	private JDBCMeetingRoomOperationInterface jdbcOperatrionInterface;
	private ModelAndView mav = new ModelAndView();
	
	@RequestMapping(value="/about.do",method=RequestMethod.GET)
	public String aboutme(HttpServletRequest request,HttpServletResponse response){
		String returningStr = "";
		
		returningStr = "aboutme";
		return returningStr;
	}
	@RequestMapping(value="/myreserve.do",method=RequestMethod.GET)
	public String myreserve(HttpServletRequest request,HttpServletResponse response){
		String returningStr = "";
		User user = (User)request.getSession().getAttribute("userObj");
		if(user!=null){
			List<Map<String, Object>> rvlist = jdbcOperatrionInterface.findReservationsByUserId(user.getId());
			request.setAttribute("rvlist", rvlist);
		}
		
		returningStr = "user/myreservation";
		return returningStr;
	}
	
	@RequestMapping(value="/myinfo.do",method=RequestMethod.GET)
	public String myinfo(HttpServletRequest request,HttpServletResponse response){
		String returningStr = "";
		User user = (User)request.getSession().getAttribute("userObj");
		if(user!=null){
			request.setAttribute("user", user);
		}
		
		returningStr = "user/myinfo";
		return returningStr;
	}

}
