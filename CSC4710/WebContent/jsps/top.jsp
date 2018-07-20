<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		background: #4682B4; 
	}
	a {
		text-transform:none;
		text-decoration:none;
	} 
	a:hover {
		text-decoration:underline;
	}
</style>
  </head>
  
  <body>
<h1 style="text-align: center;">CSC4710!!!!!!!</h1>
<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user and empty sessionScope.session_manager}">
			<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Login</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">Register</a> |&nbsp;
			<a href="<c:url value='/jsps/managerLogin.jsp'/>" target="_parent">Manager Login</a>
		</c:when>
		<c:when test="${not empty sessionScope.session_manager}">
			Hello：${sessionScope.session_manager.musername };
			<a href="<c:url value='/jsps/item.jsp'/>" target="body">Query Result</a>&nbsp;&nbsp;
			
		</c:when>
		<c:when test="${not empty sessionScope.session_user}">
			Hello：${sessionScope.session_user.username };
			<a href="<c:url value='/jsps/item.jsp'/>" target="body">Query Result</a>&nbsp;&nbsp;
			
		</c:when>
		
	</c:choose>

</div>
  </body>
</html>
