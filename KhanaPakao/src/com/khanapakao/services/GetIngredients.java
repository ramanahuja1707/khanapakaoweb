package com.khanapakao.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.Query;
import com.khanapakao.dto.Ingredients;
import com.khanapakao.dto.Recipe;

public class GetIngredients extends HttpServlet {
	JSONObject jsonData;

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
				jsonData.put("recipeName", recipeName);
				jsonData.put("ingredientname", q.list().get(0)
						.getIngredientName());
				jsonData.put("ingredientquantity", q.list().get(0)
						.getIngredientQuantity());
				jsonData.put("ingredientdescription", q.list().get(0)
						.getIngredientDescription());
				jsonData.put("ingredientimagename", q.list().get(0)
						.getIngredientName());
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
