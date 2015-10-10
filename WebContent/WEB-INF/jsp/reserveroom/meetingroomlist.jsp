<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
pageContext.setAttribute("basePath",basePath);
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="${basePath}/images/favicon.ico">

    <title>会议室可预订列表</title>

    <!-- Bootstrap core CSS -->
    <link href="${basePath}/bootstap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="${basePath}/bootstap/dist/css/bootstrap-theme.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${basePath}/bootstap/css/theme.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../bootstap/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body>
 <jsp:include page="../header.jsp"></jsp:include>
 <div class="container theme-showcase" role="main">
	 <!-- Main jumbotron for a primary marketing message or call to action -->
	 <div class="jumbotron" align="center">
	   <h1 >可预订会议室列表</h1>
	   <c:forEach var="mr" items="${mrlist}" varStatus="i">
	   	<c:if test="${i.index==0 ||i.index%5==0}">
	   	 <p>
	   	</c:if>
<button type="button" class="btn btn-lg btn-info" title="
名称:${mr.name}
位置:${mr.position}
容纳人数:${mr.large}
是否有投影仪:${mr.projector}
是否可用:${mr.available}&#10;" 
 onclick="javascript:window.location.href='../user/reserveroomdetail.do?id=${mr.id}'">${mr.name}</button>
		<c:if test="${i.index%5==4}">
	   	 </p>
	   	</c:if>
	   </c:forEach>
	 </div>
	 
	 <div class="page-header">
        <h1></h1>
     </div>
     
     
 </div>
 
 <!-- Bootstrap core JavaScript
 ================================================== -->
 <!-- Placed at the end of the document so the pages load faster -->
 <script src="${basePath}/outerjs/jquery-1.11.3.min.js"></script>
 <script src="${basePath}/bootstap/dist/js/bootstrap.min.js"></script>
 <script src="${basePath}/bootstap/assets/js/docs.min.js"></script>
 <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
 <script src="${basePath}/bootstap/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>