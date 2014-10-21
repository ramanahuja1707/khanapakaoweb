package com.khanapakao.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.googlecode.objectify.Objectify;
import com.khanapakao.dto.RecipeUserComments;
import com.khanapakao.dto.User;
import com.khanapakao.services.ObjectifyRegisterService;

public class CommentOnRecipe extends HttpServlet {
	JSONObject jsonData;
	static int commentNo = 0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter out = resp.getWriter();

		try {
			jsonData = new JSONObject();
			Objectify ob = ObjectifyRegisterService.registerService();
			// getting data
			String comment = req.getParameter("comment");
			String recipeName = req.getParameter("recipename");
			String userMailId = req.getParameter("usermailid");

			// setting data
			RecipeUserComments comments = new RecipeUserComments();
			comments.setCommentId(recipeName + "_" + userMailId + "_" + comment
					+ (++commentNo));
			comments.setComments(comment);
			comments.setRecipeName(recipeName);
			comments.setUserMailId(userMailId);
			// saving to datastore
			ob.put(comments);
			jsonData.put("usercommentstatus", "ok");
			out.println(jsonData.toString());

		} catch (Exception e) {
			jsonData = new JSONObject();
			jsonData.put("usercommentstatus", "not_ok");
			jsonData.put("error", e);
			out.println(jsonData.toString());
		}

	}
}
