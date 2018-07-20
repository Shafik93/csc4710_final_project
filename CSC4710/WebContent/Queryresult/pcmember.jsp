<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<h3 align="center"> Pc Member Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>memberid</th>
		<th>email</th>
		<th>name</th>
		<th colspan=2>Action</th>
	</tr>
	<c:forEach items="${PcMemberList}" var="member">
	<tr>
		<td>${member.memberid }</td>
		<td>${member.email }</td>
		<td>${member.name }</td>
		<td><a href="UserController?action=edit&userId=<c:out value="${user.userid}"/>">Update</a></td>
        <td><a href="UserController?action=delete&userId=<c:out value="${user.userid}"/>">Delete</a></td>
	</tr>
</c:forEach>
</table>
 <p align="center"><a href="UserController?action=insert">Add Pc Member</a></p>
</body>
</html>