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
	<center>
		<h1>
			<u>Add Ingredient</u>
		</h1>
		<a href="adminPage.jsp"><input type="button" value="Back"></a>
		<br> <br>
		<form action="addingredients" method="post">
			Recipe Name:<input type="text" name="recipeName" /><br> <br>
			Ingredient Name:<input type="text" name="ingredientName" /><br>
			<br>Ingredient Description:
			<textarea rows="10" cols="30" name="ingredientDescription"></textarea>
			<br /> <br />Ingredient Quantity: Ingredient Name:<input
				type="text" name="ingredientQuantity" /> <br /> <br />Ingredient
			Image Name:<input type="text" name="ingredientImageName" /> <input
				type="submit" value="Add Recipe">
		</form>
	</center>
</body>
</html>