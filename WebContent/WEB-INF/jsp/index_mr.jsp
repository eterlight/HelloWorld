<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="images/favicon.ico">

    <title>会议室预订系统首页</title>

    <!-- Bootstrap core CSS -->
    <link href="bootstap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="bootstap/dist/css/bootstrap-theme.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="bootstap/css/theme.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="bootstap/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body>
 <jsp:include page="header.jsp"></jsp:include>
 <div class="container theme-showcase" role="main">
	 <!-- Main jumbotron for a primary marketing message or call to action -->
	 <div class="jumbotron" align="center">
	   <h1 >最新会议室预定情况</h1>
	   <div>
	   <marquee style="text-align:center;" scrolldelay="200" direction="up" onmouseover="this.stop()" onmouseout="this.start()">
	   <p>张三 预定<font color="red">1号会议室</font> 时间是:<font color="red">2015-09-30 上午AM</font></p>
	   <p>李四 预定<font color="red">2号会议室</font> 时间是:<font color="red">2015-09-30 下午PM</font></p>
	   <p>王五 预定<font color="red">2号会议室</font> 时间是:<font color="red">2015-09-31 下午PM</font></p>
	   </marquee>
	   </div>
	 </div>
	 
	 <div class="page-header">
        <h1></h1>
     </div>
     
     <center><button type="button" class="btn btn-lg btn-success" onclick="javascript:window.location.href='user/reserveroomlist.do'" onfocus="cursor:pointer;">进入我的预定</button></center>
 </div>
 
 <!-- Bootstrap core JavaScript
 ================================================== -->
 <!-- Placed at the end of the document so the pages load faster -->
 <script src="outerjs/jquery-1.11.3.min.js"></script>
 <script src="bootstap/dist/js/bootstrap.min.js"></script>
 <script src="bootstap/assets/js/docs.min.js"></script>
 <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
 <script src="bootstap/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>