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
import com.khanapakao.dto.Recipe;

public class GetRecipesByCategory extends HttpServlet {
	JSONObject jsonData;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/json");
		try {
			Objectify ob = ObjectifyRegisterService.registerService();
			Query<Recipe> q = (Query<Recipe>) ob.query(Recipe.class).filter(
					"category", req.getParameter("category"));
			if (q.list().size() > 0) {
				jsonData = new JSONObject();
				JSONArray recipes = new JSONArray();
				for (Recipe recipe : q) {
					JSONObject tempObject = new JSONObject();
					tempObject.put("category", recipe.getCategory());
					tempObject.put("description", recipe.getDescription());
					tempObject.put("imagename", recipe.getImageName());
					tempObject.put("instructions", recipe.getInstructions());
					tempObject.put("recipename", recipe.getRecipeName());
					tempObject.put("recipeorigin", recipe.getRecipeOrigin());
					tempObject.put("recipeposteddate",
							recipe.getRecipePostedDate());
					tempObject.put("recipetaste", recipe.getRecipeTaste());
					tempObject.put("serving", recipe.getServing());
					tempObject.put("timetocook", recipe.getTimeTocook());
					tempObject.put("timetoprepare", recipe.getTimeToPrepare());
					tempObject.put("totalcomment", recipe.getTotalComment());
					tempObject.put("totallikes", recipe.getTotalLikes());
					tempObject.put("totalrating", recipe.getTotalRating());
					tempObject.put("totaltime", recipe.getTotalTime());
					tempObject.put("type", recipe.getType());
					tempObject.put("videolink", recipe.getVideoLink());
					tempObject.put("imagestatus", recipe.getImageStatus());
					tempObject.put("videostatus", recipe.getVideoStatus());

					recipes.put(tempObject);
				}
				jsonData.put("recipes", recipes);
				jsonData.put("status", "ok");
				// jsonData.put("data", q.list());
				// Gson gsonData = new Gson();
				// String data = gsonData.toJson(q.list(), ArrayList.class);
				out.println(jsonData.toJSONString());
			} else {
				jsonData = new JSONObject();
				jsonData.put("status", "not_ok");
				jsonData.put("recipes", "no_data");
				out.println(jsonData);
			}
		} catch (Exception e) {
			jsonData = new JSONObject();
			jsonData.put("status", "not_ok");
			jsonData.put("recipes", "no_data");
			jsonData.put("error", e);
			out.println(jsonData);
		}
	}
}
