package com.khanapakao.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.khanapakao.dto.Recipe;
import com.khanapakao.dto.UserRating;
import com.khanapakao.services.ObjectifyRegisterService;

@SuppressWarnings("serial")
public class RateRecipe extends HttpServlet {

	JSONObject jsonData;

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/json");
		try {
			String userMailId = req.getParameter("usermailid");
			String recipeName = req.getParameter("recipename");
			String rateString = req.getParameter("rate");
			Float rate = Float.parseFloat(rateString);
			Objectify ob = ObjectifyRegisterService.registerService();
			Query<Recipe> q = (Query<Recipe>) ob.query(Recipe.class).filter(
					"recipeName", req.getParameter("recipename"));
			if (q.list().size() == 1) {
				jsonData = new JSONObject();
				// calculating totalRating of Recipe
				float rating = q.list().get(0).getTotalRating();
				Recipe recipe1 = q.list().get(0);
				recipe1.setTotalRating(((rating + rate) / 2));
				Objectify objectify = ObjectifyService.begin();
				objectify.put(recipe1);
				// saving of the rating by user
				UserRating userRating = new UserRating();
				userRating.setRating(rate);
				userRating.setRatingId(recipeName + "_" + userMailId);
				userRating.setRecipeName(recipeName);
				userRating.setUserMailId(userMailId);
				objectify.put(userRating);

				// totalRating updated and added to jsonData
				Recipe recipe = q.list().get(0);
				jsonData.put("recipename", recipe.getRecipeName());
				jsonData.put("totalrating", recipe.getTotalRating());

				jsonData.put("ratingstatus", "ok");
				// jsonData.put("data", q.list());
				// Gson gsonData = new Gson();
				// String data = gsonData.toJson(q.list(), ArrayList.class);
				out.println(jsonData.toJSONString());
			} else {
				jsonData = new JSONObject();
				jsonData.put("ratingstatus", "not_ok");
				jsonData.put("recipename", req.getParameter("recipename"));
				out.println(jsonData);
			}
		} catch (Exception e) {
			jsonData = new JSONObject();
			jsonData.put("ratingstatus", "not_ok");
			jsonData.put("error", e);
			out.println(jsonData.toString());
		}
	}
}
