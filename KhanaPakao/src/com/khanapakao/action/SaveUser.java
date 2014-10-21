package com.khanapakao.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.Query;
import com.khanapakao.dto.User;
import com.khanapakao.services.ObjectifyRegisterService;

public class SaveUser extends HttpServlet {
	JSONObject jsonData;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try {
			Objectify ob = ObjectifyRegisterService.registerService();
			Query<User> query = ob.query(User.class).filter("userMailId",
					req.getParameter("usermailid"));
			if (!(query.list().size() == 1)) {
				jsonData = new JSONObject();
				// getting data
				String userMailId = req.getParameter("usermailid");
				// setting data
				User user = new User();
				user.setUserMailId(userMailId);
				user.setUserWish(null);
				// saving to datastore
				ob.put(user);
				jsonData.put("usersavedstatus", "ok");
				out.println(jsonData.toString());
			} else {
				jsonData = new JSONObject();
				jsonData.put("usersavedstatus", "not_ok");
				jsonData.put("error", "user_already_exists");
				out.println(jsonData.toString());
			}
		} catch (Exception e) {
			jsonData = new JSONObject();
			jsonData.put("usersavedstatus", "not_ok");
			jsonData.put("error", e);
			out.println(jsonData.toString());
		}

	}
}
