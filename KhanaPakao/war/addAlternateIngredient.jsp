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
			<u>Add Alternate Ingredient</u>
		</h1>
		<a href="adminPage.jsp"><input type="button" value="Back"></a>
		<br> <br>
		<form action="addalternateingredient" method="get">
			Ingredient Name:<input type="text" name="ingredientName" /><br>
			<br> Alternate Ingredient Name:<input type="text"
				name="ingredientAlternateName" /><br> <br>Ingredient
			Description:
			<textarea rows="10" cols="30" name="ingredientDescription"></textarea>
			<br /> <br />Alternate Ingredient Description:
			<textarea rows="10" cols="30" name="ingredientAlternateDescription"></textarea>
			<br /> <br />Ingredient Quantity: <input type="text"
				name="ingredientQuantity" /> <br /> <br />Alternate Ingredient
			Quantity: <input type="text" name="ingredientAlternateQuantity" /> <br />
			<br />Ingredient Image Name:<input type="text"
				name="ingredientImageName" /> <br> <br>Alternate Ingredient Image
			Name:<input type="text"
				name="ingredientAlternateImageName" /><br> <br> <input
				type="submit" value="Add">
		</form>
	</center>
</body>
</html>