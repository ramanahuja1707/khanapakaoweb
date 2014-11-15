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
import com.khanapakao.dto.Recipe;
import com.khanapakao.dto.User;

public class GetUserWishlist extends HttpServlet {
	JSONObject jsonData;
	JSONArray wishlistArray, imageNameArray, categoryArray;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String userMailId = req.getParameter("usermailid");
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/json");
		try {
			Objectify ob = ObjectifyRegisterService.registerService();
			Query<User> q = (Query<User>) ob.query(User.class).filter(
					"userMailId", userMailId);
			if (q.list().size() == 1) {
				jsonData = new JSONObject();
				if (q.list().get(0).getUserWish() == null) {
					jsonData.put("wishlist", null);
					jsonData.put("wishliststatus", "empty");
				} else {
					wishlistArray = new JSONArray();
					imageNameArray = new JSONArray();
					categoryArray = new JSONArray();
					for (String wishlist : q.list().get(0).getUserWish()) {
						wishlistArray.add(wishlist);
						Query<Recipe> q1 = (Query<Recipe>) ob.query(
								Recipe.class).filter("recipeName", wishlist);
						imageNameArray.add(q1.list().get(0).getImageName());
						categoryArray.add(q1.list().get(0).getCategory());
					}
					jsonData.put("wishlist", wishlistArray);
					jsonData.put("imagename", imageNameArray);
					jsonData.put("category", categoryArray);
					jsonData.put("wishliststatus", "not_empty");
				}
				jsonData.put("userstatus", "ok");
				// jsonData.put("data", q.list());
				// Gson gsonData = new Gson();
				// String data = gsonData.toJson(q.list(), ArrayList.class);
				out.println(jsonData.toJSONString());
			} else {
				jsonData = new JSONObject();
				jsonData.put("userstatus", "not_ok");
				jsonData.put("wishlist", null);
				jsonData.put("imagename", null);
				jsonData.put("category", null);
				jsonData.put("wishliststatus", "empty");
				out.println(jsonData.toJSONString());
			}
		} catch (Exception e) {
			jsonData = new JSONObject();
			jsonData.put("userstatus", "not_ok");
			jsonData.put("error", e);
			out.println(jsonData.toJSONString());
		}
	}
}
