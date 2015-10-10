<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="images/favicon.ico">
<title>Signin</title>
<!-- Bootstrap core CSS -->
<link href="bootstap/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="bootstap/css/signin.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../bootstap/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="bootstap/assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body>
	<div class="container">

    <form class="form-signin" id="loginForm" action="loginin.do" method="post">
      <h2 class="form-signin-heading">
      <c:if test="${not empty message}">
      	<p style="color:red;font-size:18px;">${message}</p>
      </c:if>
      <c:if test="${empty message}">
      	<p style="font-size:18px;">请登录</p>
      </c:if>
      </h2>
      <label for="username" class="sr-only">Email address</label>
      <input type="text" id="username" name="username" class="form-control" placeholder="用户名" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword" name="password" class="form-control" placeholder="密码" required>
      <div class="checkbox">
        <label>
          <input type="checkbox" name="checkbox" value="remember-me"> 一周内自动登录
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </form>

  </div> <!-- /container -->


  <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  <script src="bootstap/assets/js/ie10-viewport-bug-workaround.js"></script>
  <script>
  	window.onload = function(){
  		var message = "${message}";
  		//alert(message);
  		if(getCookie("autologin") && message==""){
  			document.getElementById("loginForm").submit();
  		}
  	}
  	function getCookie(name)
  	{
	  	var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
	  	if(arr=document.cookie.match(reg))
	  		return unescape(arr[2]);
	  	else
	  		return null;
  	}
  </script>
</body>
</html>