package com.khanapakao.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.khanapakao.dto.AlternateIngredients;

@SuppressWarnings("serial")
public class AddAlternateIngredient extends HttpServlet {
	ArrayList<String> jsonData;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try {
			Objectify ob = ObjectifyService.begin();

			// getting data
			String ingredientName = req.getParameter("ingredientName");
			String ingredientAlternateName = req
					.getParameter("ingredientAlternateName");
			String ingredientDescription = req
					.getParameter("ingredientDescription");
			String ingredientAlternateDescription = req
					.getParameter("ingredientAlternateDescription");
			String ingredientQuantity = req.getParameter("ingredientQuantity");
			String ingredientAlternateQuantity = req
					.getParameter("ingredientAlternateQuantity");
			String ingredientImageName = req
					.getParameter("ingredientImageName");
			String ingredientAlternateImageName = req
					.getParameter("ingredientAlternateImageName");

			if (!(ingredientName.equals(""))
					&& (!(ingredientAlternateName.equals("")))) {
				// setting data
				AlternateIngredients ingredients = new AlternateIngredients();
				ingredients.setIngredientDescription(ingredientDescription);
				ingredients.setIngredientImageName(ingredientImageName);
				ingredients.setIngredientName(ingredientName);
				ingredients.setIngredientQuantity(ingredientQuantity);
				ingredients
						.setIngredientAlternateDescription(ingredientAlternateDescription);
				ingredients
						.setIngredientAlternateImageName(ingredientAlternateImageName);
				ingredients.setIngredientAlternateName(ingredientAlternateName);
				ingredients
						.setIngredientAlternateQuantity(ingredientAlternateQuantity);

				// saving to datastore
				ob.put(ingredients);
				out.println("<a href='" + "adminPage.jsp"
						+ "'>Back</a><br><br>");
				out.println("<a href='" + "addAlternateIngredient.jsp"
						+ "'>Add More Alternate Ingredients</a><br><br>");
			} else {
				jsonData = new ArrayList<>();
				if (ingredientName.equals("")) {
					jsonData.add("Ingredient Name Is Empty");
				}
				if (ingredientAlternateName.equals("")) {
					jsonData.add("Alternate Ingredient name is empty");
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
