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
import com.khanapakao.dto.Feedback;

@SuppressWarnings("serial")
public class SubmitFeedback extends HttpServlet {
	JSONObject jsonData;

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try {
			Objectify ob = ObjectifyService.begin();

			// getting data
			String userMailId = req.getParameter("usermailid");
			String feedback = req.getParameter("feedback");

			if (!(userMailId.equals("")) && (!(feedback.equals("")))) {
				// setting data
				Feedback userFeedback = new Feedback();
				userFeedback.setId(userMailId + "_" + feedback);
				userFeedback.setFeedback(feedback);
				userFeedback.setUserMailId(userMailId);
				// saving to datastore
				ob.put(userFeedback);
				jsonData = new JSONObject();
				jsonData.put("feedbackstatus", "taken");
				out.println(jsonData.toJSONString());
			} else {
				jsonData = new JSONObject();
				jsonData.put("feedbackstatus", "not_taken");
				jsonData.put("error", "input_empty");
				out.println(jsonData.toJSONString());
			}

		} catch (Exception e) {
			jsonData = new JSONObject();
			jsonData.put("feedbackstatus", "not_taken");
			jsonData.put("error", e);
			out.println(jsonData.toJSONString());
		}
	}
}
