package com.khanapakao.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.Query;
import com.khanapakao.dto.AlternateIngredients;
import com.khanapakao.dto.CookingMethods;

@SuppressWarnings("serial")
public class GetAlternateIngredient extends HttpServlet {
	JSONObject jsonData;

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String ingredientName = req.getParameter("ingredientname");
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/json");
		try {
			Objectify ob = ObjectifyRegisterService.registerService();
			Query<AlternateIngredients> q = (Query<AlternateIngredients>) ob
					.query(AlternateIngredients.class).filter("ingredientName",
							ingredientName);
			if (q.list().size() > 0) {
				JSONArray alternateIngredients = new JSONArray();
				for (AlternateIngredients ingredient : q) {
					JSONObject tempMethod = new JSONObject();
					tempMethod.put("ingredientalternatedescription",
							ingredient.getIngredientAlternateDescription());
					tempMethod.put("ingredientalternateimagename",
							ingredient.getIngredientAlternateImageName());
					tempMethod.put("ingredientalternatename",
							ingredient.getIngredientAlternateName());
					tempMethod.put("ingredientalternatequantity",
							ingredient.getIngredientAlternateQuantity());
					tempMethod.put("ingredientdescription",
							ingredient.getIngredientDescription());
					tempMethod.put("ingredientimagename",
							ingredient.getIngredientImageName());
					tempMethod.put("ingredientquantity",
							ingredient.getIngredientQuantity());
					tempMethod.put("ingredientname",
							ingredient.getIngredientName());

					alternateIngredients.add(tempMethod);
				}
				jsonData = new JSONObject();
				jsonData.put("alternateingredients", alternateIngredients);
				jsonData.put("alternateingredientstatus", "ok");
				// jsonData.put("data", q.list());
				// Gson gsonData = new Gson();
				// String data = gsonData.toJson(q.list(), ArrayList.class);
				out.println(jsonData.toJSONString());
			} else {
				jsonData = new JSONObject();
				jsonData.put("alternateingredients", null);
				jsonData.put("alternateingredientstatus", "not_ok");
				out.println(jsonData.toJSONString());
			}
		} catch (Exception e) {
			jsonData = new JSONObject();
			jsonData.put("alternateingredients", null);
			jsonData.put("alternateingredientstatus", "not_ok");
			jsonData.put("error", e);
			out.println(jsonData.toJSONString());
		}

	}
}
