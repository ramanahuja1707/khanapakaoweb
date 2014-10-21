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
import com.khanapakao.dto.RecipeUserComments;

public class GetRecipeComments extends HttpServlet {
	JSONObject jsonData;
	JSONArray userIds;
	JSONArray comments;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/json");
		try {
			Objectify ob = ObjectifyRegisterService.registerService();
			Query<RecipeUserComments> q = (Query<RecipeUserComments>) ob.query(
					RecipeUserComments.class).filter("recipeName",
					req.getParameter("recipename"));
			if (q.list().size() > 0) {
				jsonData = new JSONObject();
				JSONArray recipes = new JSONArray();
				userIds = new JSONArray();
				comments = new JSONArray();
				for (RecipeUserComments recipe : q.list()) {
					userIds.put(recipe.getUserMailId());
					comments.put(recipe.getComments());
				}
				jsonData.put("comments", comments);
				jsonData.put("users", userIds);
				jsonData.put("status", "ok");
				jsonData.put("recipestatus", "exist");
				// jsonData.put("data", q.list());
				// Gson gsonData = new Gson();
				// String data = gsonData.toJson(q.list(), ArrayList.class);
				out.println(jsonData.toJSONString());
			} else {
				jsonData = new JSONObject();
				jsonData.put("recipestatus", "not_exist");
				jsonData.put("status", "not_ok");
				jsonData.put("comments", "no_data");
				jsonData.put("users", "no_data");
				out.println(jsonData);
			}
		} catch (Exception e) {
			jsonData = new JSONObject();
			jsonData.put("recipestatus", "exist");
			jsonData.put("status", "not_ok");
			jsonData.put("comments", "no_data");
			jsonData.put("users", "no_data");
			jsonData.put("error", e);
			out.println(jsonData);
		}

	}
}
