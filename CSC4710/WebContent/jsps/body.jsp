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
    <h1>Welcome to The Conference</h1>
    <c:choose>
		<c:when test="${empty sessionScope.session_user and empty sessionScope.session_manager}">
			<form action="<c:url value='/Sql'/>" method = "post">
 				<label for="myComments">Click the button to initialize database<br></label>
 				<input type="submit" name="sql" value="Initialize Database"/>
 			</form>		
		</c:when>
		<c:when test="${not empty sessionScope.session_user and empty sessionScope.session_manager}">
		
		  	<p>Find all papers by author's last name as single authors:</p>
		<form action="<c:url value='/AuthorServlet'/>" method="post">
			<input type="hidden" name="method" value="login"/>
				Last Name：	<input type="text" name="lastname" /><br/>
			<input type="submit" value="Submit"/>
		</form>
		
			<p>Find all papers in which Author is listed as first:</p>
		<form action="<c:url value='/AuthorServlet'/>" method="post">
			<input type="hidden" name="method" value="login"/>
				Last Name：	<input type="text" name="lastname" /><br/>
			<input type="submit" value="Submit" name = "firstAuthor"/>
		</form>
		
		  	<p>Find all coauthored papers by two authors' last names</p>
		<form action="<c:url value='/AuthorServlet'/>" method="post">
			<input type="hidden" name="method" value="login"/>
				Author 1 Last Name：	<input type="text" name="lastname" /><br/>
				Author 2 Last Name：	<input type="text" name="lastname" /><br/>
			<input type="submit" value="Submit"/>
		
		</form>
			<p>Find all papers rejected by both Pc Members</p>
		<form action="<c:url value='/AuthorServlet'/>" method="post">
			<input type="hidden" name="method" value="login"/>
				First Name 1：	<input type="text" name="lastname" /><br/>
				First Name 2：	<input type="text" name="lastname" /><br/>
			<input type="submit" value="Submit"/>
		</form>
		
		<p>To assign at most three reviewers to a Paper: </p>
		<form action="<c:url value='/Reviewers'/>" method="post">
			<label> Email 1: </label>
			<input type="text" name="email1" value = ""/>
			<br>
			
			<label> Email 2: </label>
			<input type="text" name="email2" value = ""/>
			
			<br>
			<label> Email 3: </label>
			<input type="text" name="email3" value = ""/>
			<br>
			<label>Paper Id: </label>
			<input type = "text" name = "paperid" value = ""/>
			<br>
			<input type="submit" value="Submit" name ="sbtrv" />
		</form>
		
		</c:when>
	
	</c:choose>
   
  </body>
</html>
