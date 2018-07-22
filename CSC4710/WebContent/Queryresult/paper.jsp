<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<h3 align="center"> Paper Table </h3>
	<table border="1" width="70%" align="center">
	<tr>
		<th>paper_id</th>
		<th>title</th>
		<th>abstract</th>
		<th>pdf</th>
		<th colspan=2>action</th>
	</tr>
	<c:forEach items="${requestScope.PaperList}" var="paper">
	<tr>
		<td>${paper.paperid}</td>
		<td>${paper.title}</td>
		<td>${paper.abs}</td>
		<td>${paper.pdf}</td>
		<td><a href="UserControllerPaper?action=edit&paperid=<c:out value="${paper.paperid}"/>">Update</a></td>
        <td><a href="UserControllerPaper?action=delete&paperid=<c:out value="${paper.paperid}"/>">Delete</a></td>
	</tr>
</c:forEach>
</table>
<p align="center"><a href="UserControllerPaper?action=insert">Insert Paper</a></p>
</body>
</html>