<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.getRequestDispatcher("WEB-INF/jsp/login/login.jsp").forward(request, response);
	out.clear(); 
	out = pageContext.pushBody();
%>