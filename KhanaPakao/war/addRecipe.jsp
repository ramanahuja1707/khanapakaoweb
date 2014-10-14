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
			<u>Add Recipe</u>
		</h1>
		<a href="adminPage.jsp"><input type="button" value="Back"></a>
		<br> <br>
		<form action="addrecipe" method="post">
			Recipe Name:<input type="text" name="recipeName" /><br> <br>
			Select Category:<select name="category">
				<option value="appetizers">APPETIZERS</option>
				<option value="bread">BREAD</option>
				<option value="beverages">BEVERAGES</option>
				<option value="cookies">COOKIES</option>
				<option value="desserts">DESSERTS</option>
				<option value="maincourse">MAIN COURSE</option>
				<option value="salads">SALADS</option>
			</select> <br /> <br /> Description:
			<textarea rows="10" cols="30" name="description"></textarea>
			<br /> <br />Instructions:
			<textarea rows="10" cols="30" name="instructions"></textarea>
			<br /> <br /> TIME TO PREPARE:<input type="text"
				name="timeToPrepare"><br /> <br /> Time To Cook:<input
				type="text" name="timeToCook"> <br /> <br />Total Time:<input
				type="text" name="totalTime"> <br /> <br /> Video Status:<select
				name="videoStatus">
				<option value="enable">Enable</option>
				<option value="disable">Disable</option>
			</select> <br /> <br /> Video Link: <input type="text" name="videoLink">
			<br /> <br /> Image Status: <select name="imageStatus">
				<option value="enable">Enable</option>
				<option value="disable">Disable</option>
			</select> <br /> <br /> Image Name: <input type="text" name="imageName">
			<br /> <br /> Recipe Origin: <input type="text" name="recipeOrigin">
			<br /> <br /> Recipe Taste: <input type="text" name="recipeTaste">
			<br /> <br /> Select Type:<select name="type">
				<option value="veg">Veg.</option>
				<option value="non-veg">Non-Veg.</option>
			</select> <br /> <br /> <input type="submit" value="Add Recipe">
		</form>
	</center>
</body>
</html>