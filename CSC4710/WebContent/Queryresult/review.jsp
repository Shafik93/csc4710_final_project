<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<h3 align="center"> Review Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>reportid</th>
		<th>sdate</th>
		<th>comment</th>
		<th>recommendation</th>
		<th>paperid</th>
		<th>email</th>
		<th colspan=2>Action</th>
		
	</tr>
	<c:forEach items="${ReviewList}" var="review">
	<tr>
		<td>${review.reportid }</td>
		<td>${review.sdate }</td>
		<td>${review.comment }</td>
		<td>${review.recommendation }</td>
		<td>${review.paperid }</td>
		<td>${review.email }</td>
		<td><a href="UserController?action=edit&reportid=<c:out value="${review.reportid}"/>">Update</a></td>
        <td><a href="UserController?action=delete&reportid=<c:out value="${review.reportid}"/>">Delete</a></td>
	</tr>
</c:forEach>
</table>
 <p align="center"><a href="UserController?action=insert">Add Review</a></p>
</body>
</html>