package com.khanapakao.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.Query;
import com.khanapakao.dto.Ingredients;

@SuppressWarnings("serial")
public class GetIngredients extends HttpServlet {
	JSONObject jsonData;

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String recipeName = req.getParameter("recipename");
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/json");
		try {
			Objectify ob = ObjectifyRegisterService.registerService();
			Query<Ingredients> q = (Query<Ingredients>) ob.query(
					Ingredients.class).filter("recipeName", recipeName);
			if (q.list().size() > 0) {
				jsonData = new JSONObject();
				jsonData.put("recipename", recipeName);
				org.json.simple.JSONArray ingredients = new org.json.simple.JSONArray();
				for (Ingredients ingredient : q) {
					JSONObject ingredientTemp = new JSONObject();

					ingredientTemp.put("ingredientname",
							ingredient.getIngredientName());

					ingredientTemp.put("ingredientquantity",
							ingredient.getIngredientQuantity());
					ingredientTemp.put("ingredientimagename",
							ingredient.getIngredientImageName());

					ingredientTemp.put("ingredientdescription",
							ingredient.getIngredientDescription());
					ingredients.add(ingredientTemp);
				}
				jsonData.put("ingredients", ingredients);

				jsonData.put("ingredientstatus", "ok");
				jsonData.put("recipestatus", "exist");
				// jsonData.put("data", q.list());
				// Gson gsonData = new Gson();
				// String data = gsonData.toJson(q.list(), ArrayList.class);
				out.println(jsonData.toJSONString());
			} else {
				jsonData = new JSONObject();
				jsonData.put("ingredientstatus", "not_ok");
				jsonData.put("recipestatus", "not_exist");
				out.println(jsonData.toJSONString());
			}
		} catch (Exception e) {
			jsonData = new JSONObject();
			jsonData.put("ingredientstatus", "not_ok");
			jsonData.put("recipestatus", "exist");
			jsonData.put("error", e);
			out.println(jsonData.toJSONString());
		}

	}
}
