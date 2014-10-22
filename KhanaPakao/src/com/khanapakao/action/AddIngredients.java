package com.khanapakao.action;

import java.io.IOException;
import java.io.PrintWriter;
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
	JSONObject jsonData;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try {
			Objectify ob = ObjectifyService.begin();

			// getting data
			String recipeName = req.getParameter("recipe");
			String ingredientName = req.getParameter("name");
			String ingredientQuantity = req.getParameter("quantity");
			String ingredientImageName = req.getParameter("imagename");
			String ingredientDescription = req.getParameter("description");

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
				jsonData = new JSONObject();
				jsonData.put("ingredientsavedstatus", "ok");
				out.println(jsonData.toString());
			} else {

				jsonData = new JSONObject();
				jsonData.put("ingredientsavedstatus", "not_ok");
				if (recipeName.equals("")) {
					jsonData.put("recipenamestatus", "empty");
				}
				if (ingredientName.equals("")) {
					jsonData.put("ingredientnamestatus", "empty");
				}
				if (ingredientDescription.equals("")) {
					jsonData.put("ingredientdescriptionstatus", "empty");
				}
				if (ingredientImageName.equals("")) {
					jsonData.put("ingredientimagenamestatus", "empty");
				}
				if (ingredientQuantity.equals("")) {
					jsonData.put("ingredientquantitystatus", "empty");
				}
				out.println(jsonData.toString());
			}

		} catch (Exception e) {
			jsonData = new JSONObject();
			jsonData.put("ingredientsavedstatus", "not_ok");
			jsonData.put("error", e);
			out.println(jsonData.toString());
		}
	}
}
