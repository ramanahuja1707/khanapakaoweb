<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Khana Pakao</title>
</head>
<body>
	<%
		HttpSession s = request.getSession(false);
		if (s.getAttribute("username") == null) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/notInSession.jsp");
			rd.forward(request, response);
		}
	%>
	<h1>Successfully Logged In !!!!</h1>
	<br>
	<br>
	<a href="addRecipe.jsp"><input type="button" value="Add New Recipe" /></a>
	<br>
	<br>
	<a href="adminlogout"><input type="button" value="Logout" /></a>


</body>
</html>