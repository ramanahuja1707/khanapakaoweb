package com.khanapakao.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.khanapakao.dto.Recipe;
import com.khanapakao.dto.User;
import com.khanapakao.services.ObjectifyRegisterService;

public class SaveUser extends HttpServlet {
	JSONObject jsonData;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		try {
			jsonData = new JSONObject();
			Objectify ob = ObjectifyRegisterService.registerService();
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

		} catch (Exception e) {
			jsonData = new JSONObject();
			jsonData.put("usersavesstatus", "not_ok");
			jsonData.put("error", e);
			out.println(jsonData.toString());

		}

	}
}
