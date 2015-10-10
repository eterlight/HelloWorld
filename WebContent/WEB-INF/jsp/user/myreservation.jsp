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
    <script src="${basePath}/My97DatePicker/WdatePicker.js"></script>

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
	   <h1 >我的预定情况</h1>
	 </div>
	 <div class="col-md-6" align="center" style="font-size:14px;width:100%;">
         <table class="table table-striped">
           <thead>
              <tr>
                <th>#</th>
                <th>预定会议室id</th>
                <th>预定者姓名</th>
                <th>预定日期</th>
                <th>上午/下午</th>
                <th>是否退订</th>
              </tr>
           </thead>
           <tbody>
           <c:forEach var="rv" items="${rvlist}" varStatus="i">
           	<tr style="color:green;font-weight:24;">
                <td>${i.count}</td>
                <td>${rv.mr_id}</td>
                <td>${rv.user_name}</td>
                <td>${rv.start_booktime}</td>
                <td>${rv.time}</td>
                <td>
                	<button title="${rv.id}" type="button" class="btn btn-sm btn-default" onclick="cancelconform(this.title);"><font>退  订</font></button>
                </td>
             </tr>
           </c:forEach>
              
           </tbody>
         </table>
       </div>
     </div>
	 <div class="page-header">
        <h1></h1>
     </div>
     
     
 </div>
 <script>
 function cancelconform(id) { 
     if(!confirm("确认要取消该预定？")) { 
         window.event.returnValue = false; 
     }else{
    	 cancelsubmit(id);
     }
 } 
 function cancelsubmit(id){
	 window.location.href="/MRReservation/offreserve.do?flag="+id;
 }
 	
 </script>
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