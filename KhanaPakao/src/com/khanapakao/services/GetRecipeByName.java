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
import com.khanapakao.dto.Recipe;

@SuppressWarnings("serial")
public class GetRecipeByName extends HttpServlet {
	JSONObject jsonData;

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/json");
		try {
			Objectify ob = ObjectifyRegisterService.registerService();
			Query<Recipe> q = (Query<Recipe>) ob.query(Recipe.class).filter(
					"recipeName", req.getParameter("recipename"));
			if (q.list().size() > 0) {
				jsonData = new JSONObject();
				Recipe recipe = q.list().get(0);
				jsonData.put("category", recipe.getCategory());
				jsonData.put("description", recipe.getDescription());
				jsonData.put("imagename", recipe.getImageName());
				jsonData.put("instructions", recipe.getInstructions());
				jsonData.put("recipename", recipe.getRecipeName());
				jsonData.put("recipeorigin", recipe.getRecipeOrigin());
				// jsonData.put("recipeposteddate",
				// recipe.getRecipePostedDate());
				jsonData.put("recipetaste", recipe.getRecipeTaste());
				jsonData.put("serving", recipe.getServing());
				jsonData.put("timetocook", recipe.getTimeTocook());
				jsonData.put("timetoprepare", recipe.getTimeToPrepare());
				jsonData.put("totalcomment", recipe.getTotalComment());
				jsonData.put("totallikes", recipe.getTotalLikes());
				jsonData.put("totalrating", recipe.getTotalRating());
				jsonData.put("totaltime", recipe.getTotalTime());
				jsonData.put("type", recipe.getType());
				jsonData.put("videolink", recipe.getVideoLink());
				jsonData.put("imagestatus", recipe.getImageStatus());
				jsonData.put("videostatus", recipe.getVideoStatus());

				jsonData.put("status", "ok");
				// jsonData.put("data", q.list());
				// Gson gsonData = new Gson();
				// String data = gsonData.toJson(q.list(), ArrayList.class);
				out.println(jsonData.toJSONString());
			} else {
				jsonData = new JSONObject();
				jsonData.put("status", "not_ok");
				jsonData.put("recipe", "no_data");
				out.println(jsonData);
			}
		} catch (Exception e) {
			jsonData = new JSONObject();
			jsonData.put("status", "not_ok");
			jsonData.put("recipe", "no_data");
			jsonData.put("error", e);
			out.println(jsonData);
		}
	}
}
