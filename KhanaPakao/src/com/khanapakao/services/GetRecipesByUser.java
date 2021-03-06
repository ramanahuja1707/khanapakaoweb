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
import com.khanapakao.dto.User;

public class GetRecipesByUser extends HttpServlet {
	JSONObject jsonData;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/json");
		try {
			Objectify ob = ObjectifyRegisterService.registerService();
			Query<User> q = (Query<User>) ob.query(User.class).filter(
					"userMailId", req.getParameter("usermailid"));
			if (q.list().size() == 1) {
				jsonData = new JSONObject();
				if (q.list().get(0).getUserWish() != null) {
					JSONArray recipes = new JSONArray();
					for (String recipe : q.list().get(0).getUserWish()) {
						recipes.put(recipe);
					}
					jsonData.put("recipes", recipes);
				} else {
					jsonData.put("recipes", "no_data");
				}
				jsonData.put("status", "ok");
				jsonData.put("userstatus", "exist");
				// jsonData.put("data", q.list());
				// Gson gsonData = new Gson();
				// String data = gsonData.toJson(q.list(), ArrayList.class);
				out.println(jsonData.toJSONString());
			} else {
				jsonData = new JSONObject();
				jsonData.put("userstatus", "not_exist");
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
