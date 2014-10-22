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
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.khanapakao.dto.Recipe;

public class LikeRecipe extends HttpServlet {
	JSONObject jsonData;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/json");
		try {
			Objectify ob = ObjectifyRegisterService.registerService();
			Query<Recipe> q = (Query<Recipe>) ob.query(Recipe.class).filter(
					"recipeName", req.getParameter("recipename"));
			if (q.list().size() == 1) {
				long likes = q.list().get(0).getTotalLikes();
				Recipe recipe = q.list().get(0);
				recipe.setTotalLikes(likes + 1);
				Objectify objectify = ObjectifyService.begin();
				objectify.put(recipe);
				jsonData = new JSONObject();
				jsonData.put("category", q.list().get(0).getCategory());
				jsonData.put("description", q.list().get(0).getDescription());
				jsonData.put("imagename", q.list().get(0).getImageName());
				jsonData.put("instructions", q.list().get(0).getInstructions());
				jsonData.put("recipename", q.list().get(0).getRecipeName());
				jsonData.put("recipeorigin", q.list().get(0).getRecipeOrigin());
				jsonData.put("recipeposteddate", q.list().get(0)
						.getRecipePostedDate());
				jsonData.put("recipetaste", q.list().get(0).getRecipeTaste());
				jsonData.put("serving", q.list().get(0).getServing());
				jsonData.put("timetocook", q.list().get(0).getTimeTocook());
				jsonData.put("timetoprepare", q.list().get(0)
						.getTimeToPrepare());
				jsonData.put("totalcomment", q.list().get(0).getTotalComment());
				jsonData.put("totallikes", q.list().get(0).getTotalLikes());
				jsonData.put("totalrating", q.list().get(0).getTotalRating());
				jsonData.put("totaltime", q.list().get(0).getTotalTime());
				jsonData.put("type", q.list().get(0).getType());
				jsonData.put("videolink", q.list().get(0).getVideoLink());
				jsonData.put("imagestatus", q.list().get(0).getImageStatus());
				jsonData.put("videostatus", q.list().get(0).getVideoStatus());
				jsonData.put("likedstatus", "ok");
				// jsonData.put("data", q.list());
				// Gson gsonData = new Gson();
				// String data = gsonData.toJson(q.list(), ArrayList.class);
				out.println(jsonData.toJSONString());
			} else {
				jsonData = new JSONObject();
				jsonData.put("likedstatus", "not_ok");
				jsonData.put("recipename", req.getParameter("recipename"));
				out.println(jsonData.toJSONString());
			}
		} catch (Exception e) {
			jsonData = new JSONObject();
			jsonData.put("likedstatus", "not_ok");
			jsonData.put("error", e);
			out.println(jsonData.toJSONString());
		}
	}
}
