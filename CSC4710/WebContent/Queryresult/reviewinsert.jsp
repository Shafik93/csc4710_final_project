<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Review</title>
</head>
<body>

<form action="UserControllerReview" method ="post">

    <input type="hidden" name="method" value="login"/>
		Comment :	<input type="text" name="comment"  /><br/>
		Recommendation :	<input type="text" name="recommendation" /><br/>
		PaperId :	<input type="text" name="paperid" /><br/>
		Email :	<input type="text" name="email"  /><br/>
	<input type="submit" value="Submit" name = "frminsert" />
</form>
</body>
</html>