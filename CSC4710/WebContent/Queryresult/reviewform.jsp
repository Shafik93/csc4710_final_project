<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update review</title>
</head>
<body>

<form action="UserControllerReview" method ="post">

    <input type="hidden" name="method" value="login"/>
		Comment :	<input type="text" name="comment"  value="${review.comment}" /><br/>
		Recommendation :	<input type="text" name="recommendation"  value="${review.recommendation}" /><br/>
		PaperId :	<input type="text" name="paperid" value="${review.paperid}" /><br/>
		Email :	<input type="text" name="email" value="${review.email}" /><br/>
	<input type="submit" value="Submit" name = "frmsub" />
</form>
</body>
</html>