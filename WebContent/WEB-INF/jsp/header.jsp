<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Fixed navbar -->
 <nav class="navbar navbar-inverse navbar-fixed-top">
   <div class="container">
     <div class="navbar-header">
       <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
         <span class="sr-only">Toggle navigation</span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
       </button>
       <a class="navbar-brand" href="#">会议室预定系统</a>
     </div>
     <div id="navbar" class="navbar-collapse collapse">
       <ul class="nav navbar-nav">
         <li class="active"><a href="#">首页</a></li>
         <li><a href="/MRReservation/about.do">关于</a></li>
         <li><a href="/MRReservation/reservedetail.do">会议室详细信息</a></li>
         <li class="dropdown">
           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">我的 <span class="caret"></span></a>
           <ul class="dropdown-menu">
             <li><a href="/MRReservation/myreserve.do">我的预定</a></li>
             <li><a href="/MRReservation/myinfo.do">个人信息</a></li>
             <!--  
             <li><a href="#">Something else here</a></li>
             <li role="separator" class="divider"></li>
             <li class="dropdown-header">Nav header</li>
             <li><a href="#">Separated link</a></li>
             <li><a href="#">One more separated link</a></li>
             -->
           </ul>
         </li>
         <!--  
         <li class="dropdown">
           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
           <ul class="dropdown-menu">
             <li><a href="#">Action</a></li>
             <li><a href="#">Another action</a></li>
             <li><a href="#">Something else here</a></li>
             <li role="separator" class="divider"></li>
             <li class="dropdown-header">Nav header</li>
             <li><a href="#">Separated link</a></li>
             <li><a href="#">One more separated link</a></li>
           </ul>
         </li>
         -->
       </ul>
     </div><!--/.nav-collapse -->
   </div>
 </nav>
</body>
</html>