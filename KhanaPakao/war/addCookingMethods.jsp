<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	<center>
		<h1>
			<u>Add Cooking Methods</u>
		</h1>
		<a href="adminPage.jsp"><input type="button" value="Back"></a>
		<br> <br>
		<form action="addcookingmethods" method="get">
			Cooking Method Name:<input type="text" name="methodName" /><br>
			<br>Cooking Method Image Name:<input type="text"
				name="methodImageName" /><br> <br>Cooking Method
			Description:
			<textarea rows="10" cols="30" name="methodDescription"></textarea>
			<br /> <br />Cooking Method Video Link: <input type="text"
				name="methodVideoLink" />
			</textarea>
			<br /> <br />Cooking Method Ingredients(Mention seperated by
			commas(,)): <input type="text" name="methodIngredients" /> <br /> <br />Cooking
			Method Instructions(Mention seperated by commas(,)) : <input
				type="text" name="methodInstructions" /> <br /> <br /> <input
				type="submit" value="Add">
		</form>
	</center>
</body>
</html>