<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Paper</title>
</head>
<body>

<form action="UserControllerPaper" method ="post">

    <input type="hidden" name="method" value="login"/>
		Title :	<input type="text" name="title" value="${paper.title}" /><br/>
		Abstract :	<input type="text" name="abstract"  value="${paper.abs}" /><br/>
		PDF :	<input type="text" name="pdf"  value="${paper.pdf}" /><br/>
	<input type="submit" value="Submit" name = "frmsub" />
</form>
</body>
</html>