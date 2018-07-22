<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update PcMember</title>
</head>
<body>
<p>Update PC Member</p>
		<form action="<c:url value='/PcMemberServlet'/>" method="post">
			<input type="hidden" name="method" value="login"/>
				Email	<input type="text" name="email" value = "${pcmember.email}"/><br/>
				Name：	<input type="text" name="name" value = "${pcmember.name}"/><br/> 
			<input type="submit" value="Submit"/>
		</form>
</body>
</html>


