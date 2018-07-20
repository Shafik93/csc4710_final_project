<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h1>Database Info</h1>
    <br>
    <c:choose>
    	<c:when test="${empty sessionScope.session_manager and not empty sessionScope.session_user}">
    <a href="<c:url value='/findAll'/>" target="body">Please list all the user in the table</a><br>
 	<a href="<c:url value='/PaperServlet'/>" target="body">Please list all the paper in the table</a><br>
 	<a href="<c:url value='/AuthorServlet'/>" target="body">Please list all the author in the table</a><br>
 	<a href="<c:url value='/ReviewServlet'/>" target="body">Please list all the Review in the table</a><br>
 	<a href="<c:url value='/WritePaperServlet'/>" target="body">Please list all the Write Paper in the table</a><br>
 	<a href="<c:url value='/findAll'/>" target="body">Please list Pc Members who reviews the most</a><br>
 	<a href="<c:url value='/findAll'/>" target="body">Please list Pc Members who doesn't have reviews</a><br>
    <a href="<c:url value='/findAll'/>" target="body">Please list all accepted papers</a>&nbsp;&nbsp;
    	</c:when>
    	<c:otherwise>
    <a href="<c:url value='/findAll'/>" target="body">Please list all the user in the table</a><br>
 	<a href="<c:url value='/PaperServlet'/>" target="body">Please list all the paper in the table</a><br>
 	<a href="<c:url value='/PcMemberServlet'/>" target="body">Please list all the Pc Member in the table</a><br>
 	<a href="<c:url value='/AuthorServlet'/>" target="body">Please list all the author in the table</a><br>
 	<a href="<c:url value='/ReviewServlet'/>" target="body">Please list all the Review in the table</a><br>
 	<a href="<c:url value='/WritePaperServlet'/>" target="body">Please list all the Write Paper in the table</a><br>
 	<a href="<c:url value='/findAll'/>" target="body">Please list Pc Members who reviews the most</a><br>
 	<a href="<c:url value='/findAll'/>" target="body">Please list Pc Members who doesn't have reviews</a><br>
    <a href="<c:url value='/findAll'/>" target="body">Please list all accepted papers</a>&nbsp;&nbsp;	
    	</c:otherwise>
    </c:choose>
  </body>
</html>
