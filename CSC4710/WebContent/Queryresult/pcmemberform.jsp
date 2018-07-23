<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding= "ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update PcMember</title>
</head>
<body>

<form action="UserControllerPcMember" method ="post">

    <input type="hidden" name="method" value="login"/>
		Email :	<input type="text" name="email" value="${pcmember.email}" /><br/>
		Name :	<input type="text" name="name"  value="${pcmember.name}" /><br/>
	<input type="submit" value="Submit" name = "frmsubpc" />
</form>
</body>
</html>
