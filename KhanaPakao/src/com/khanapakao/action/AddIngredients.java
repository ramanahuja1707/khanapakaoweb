package com.khanapakao.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.khanapakao.dto.Ingredients;
import com.khanapakao.dto.Recipe;

public class AddIngredients extends HttpServlet {
	ArrayList<String> jsonData;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try {
			Objectify ob = ObjectifyService.begin();

			// getting data
			String recipeName = req.getParameter("recipeName");
			String ingredientName = req.getParameter("ingredientName");
			String ingredientQuantity = req.getParameter("ingredientQuantity");
			String ingredientImageName = req
					.getParameter("ingredientImageName");
			String ingredientDescription = req
					.getParameter("ingredientDescription");

			if (!(recipeName.equals("")) && (!(ingredientName.equals("")))
					&& (!(ingredientDescription.equals("")))
					&& (!(ingredientImageName.equals("")))
					&& (!(ingredientQuantity.equals("")))) {
				// setting data
				Ingredients ingredients = new Ingredients();
				ingredients.setIngredientDescription(ingredientDescription);
				ingredients.setIngredientImageName(ingredientImageName);
				ingredients.setIngredientName(ingredientName);
				ingredients.setIngredientQuantity(ingredientQuantity);
				ingredients.setRecipeName(recipeName);

				// saving to datastore
				ob.put(ingredients);
				out.println("<a href='" + "adminPage.jsp"
						+ "'>Back</a><br><br>");
				out.println("<a href='" + "addIngredient.jsp"
						+ "'>Add More Ingredients</a><br><br>");
			} else {
				jsonData = new ArrayList<>();
				if (recipeName.equals("")) {
					jsonData.add("Recipe Name Is Empty");
				}
				if (ingredientName.equals("")) {
					jsonData.add("Ingredient name is empty");
				}
				if (ingredientDescription.equals("")) {
					jsonData.add("Ingredient Description Is Empty");
				}
				if (ingredientImageName.equals("")) {
					jsonData.add("Ingredient Image Name Is Empty");
				}
				if (ingredientQuantity.equals("")) {
					jsonData.add("Ingredient Quantity Is Empty");
				}
				out.println("Error generated !!!");
				out.println("<br><br>");
				for (String error : jsonData) {
					out.println(error);
					out.println("<br><br>");
				}

				out.println("<br><br>");
				out.println("<a href='" + "adminPage.jsp"
						+ "'>Back</a><br><br>");
			}

		} catch (Exception e) {
			out.println("Error generated :" + e);
			out.println("<br><br>");
			out.println("<a href='" + "adminPage.jsp" + "'>Back</a><br><br>");
		}
	}
}
