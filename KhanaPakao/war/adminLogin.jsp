<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Khana Pakao</title>
</head>
<body>
	<form action="adminlogin" method="post">
		UserName:<input type="text" name="username" /> <br> <br>Password:<input
			type="password" name="password" /> <br> <br> <input
			type="submit" value="login" />
	</form>
	<%
		String logincheck = (String) request.getAttribute("logincheck");
		String logoutcheck = (String) request.getAttribute("logoutcheck");
		if (logincheck != null) {
			if (logincheck.equals("no"))
				out.println("<br>INVALID CREDENTIALS");
		}
		if (logoutcheck != null) {
			if (logoutcheck.equals("yes"))
				out.println("<br>LOGOUT SUCCESSFULLY");
		}
	%>
	<br>
	<a href="index.html"><input type="button" value="Home" /></a>
</body>
</html>