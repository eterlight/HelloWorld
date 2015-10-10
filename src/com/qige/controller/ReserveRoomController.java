package com.qige.controller;

import java.io.IOException;
import java.util.Date;
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
import com.qige.entity.MeetingRoom;
import com.qige.entity.User;
import com.qige.utils.CookieUtils;
import com.qige.utils.UUIDUtil;

@Controller
@Scope("prototype")
public class ReserveRoomController {
	@Autowired
	private JDBCMeetingRoomOperationInterface jdbcOperatrionInterface;
	
	@RequestMapping(value="user/reserveroomlist.do")
	public String mrlist(HttpServletRequest request,HttpServletResponse response){
		String returningStr = "";
		List<Map<String, Object>> mrlist = jdbcOperatrionInterface.findAllMeetingRoom();
		if(mrlist!=null && mrlist.size()>=1){
			request.setAttribute("mrlist", mrlist);
			returningStr = "reserveroom/meetingroomlist";
		}
		return returningStr;
	}
	@RequestMapping(value="user/reserveroomdetail.do",method=RequestMethod.GET)
	public String mrdetail(@RequestParam Integer id, HttpServletRequest request,HttpServletResponse response){
		System.out.println("id="+id);
		String returningStr = "";
		/*List<Map<String, Object>> mrlist = jdbcOperatrionInterface.findAllMeetingRoom();
		if(mrlist!=null && mrlist.size()>=1){
			request.setAttribute("mrlist", mrlist);
			returningStr = "reserveroom/meetingroomdetail.jsp";
		}*/
		MeetingRoom mr = jdbcOperatrionInterface.findMeetingRoomById(id);
		if(mr != null){
			request.setAttribute("mrObject", mr);
		}
		returningStr = "reserveroom/meetingroomdetail";
		return returningStr;
	}
	@RequestMapping(value="user/reserve.do",method=RequestMethod.POST)
	public String mrreserve(@RequestParam Integer mrid,@RequestParam String reservedate,@RequestParam String reservetime, HttpServletRequest request,HttpServletResponse response){
		User user = (User)request.getSession().getAttribute("userObj");
		System.out.println("mrid="+mrid+",reservedate="+reservedate+",reservetime="+reservetime+",user="+user);
		String returningStr = "";
		if(user==null){
			String message = "<font color=\"red\">请重新登录!</font>";
			request.setAttribute("message", message);
			returningStr = "reserveroom/reservesuccess";
		}
		int result = jdbcOperatrionInterface.insertReservation(user, mrid, reservedate, reservetime);
		if(result == 1){
			String message = "<font color=\"green\">预定会议室成功!</font>";
			request.setAttribute("message", message);
			returningStr = "reserveroom/reservesuccess";
		}else if(result == 2){//该会议室已经被预定
			String message = "<font color=\"red\">该时段该会议室已被预定!请重新预定会议室!</font>";
			request.setAttribute("message", message);
			returningStr = "reserveroom/reservesuccess";
		}
		
		return returningStr;
	}
	
	@RequestMapping(value="/offreserve.do",method=RequestMethod.GET)
	public String offreservation(@RequestParam Integer flag, HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("id="+flag);
		String returningStr = "";
		int result = jdbcOperatrionInterface.deleteReservationById(flag);
		if(result == 1){
			returningStr = "user/myreservation";
			response.sendRedirect("/MRReservation/myreserve.do");
		}
		returningStr = "user/myreservation";
		return returningStr;
	}
	
	@RequestMapping(value="/reservedetail.do",method=RequestMethod.GET)
	public String reservedetail(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String returningStr = "";
		
		returningStr = "reserveroom/reservedetail";
		return returningStr;
	}

}
