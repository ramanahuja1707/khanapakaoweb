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
import com.khanapakao.dto.UserRating;

@SuppressWarnings("serial")
public class GetUserRating extends HttpServlet {
	JSONObject jsonData;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String recipeName = req.getParameter("recipename");
		String userMailId = req.getParameter("usermailid");
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/json");
		try {
			Objectify ob = ObjectifyRegisterService.registerService();
			Query<UserRating> q = (Query<UserRating>) ob
					.query(UserRating.class).filter("ratingId",
							recipeName + "_" + userMailId);
			if (q.list().size() > 0) {
				jsonData = new JSONObject();
				for (UserRating userRating : q) {

					jsonData.put("userrating", userRating.getRating());
					jsonData.put("recipename", userRating.getRecipeName());
					jsonData.put("usermailid", userRating.getUserMailId());
				}
				jsonData.put("userstatus", "ok");
				jsonData.put("ratingstatus", "ok");
				// jsonData.put("data", q.list());
				// Gson gsonData = new Gson();
				// String data = gsonData.toJson(q.list(), ArrayList.class);
				out.println(jsonData.toJSONString());
			} else {
				jsonData = new JSONObject();
				jsonData.put("userstatus", "not_ok");
				jsonData.put("ratingstatus", "not_ok");
				out.println(jsonData.toJSONString());
			}
		} catch (Exception e) {
			jsonData = new JSONObject();
			jsonData.put("userstatus", "ok");
			jsonData.put("ratingstatus", "no_ok");
			jsonData.put("error", e);
			out.println(jsonData.toJSONString());
		}
	}
}
