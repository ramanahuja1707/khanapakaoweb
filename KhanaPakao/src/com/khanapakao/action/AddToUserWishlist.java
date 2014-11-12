package com.khanapakao.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.Query;
import com.khanapakao.dto.User;
import com.khanapakao.services.ObjectifyRegisterService;

@SuppressWarnings("serial")
public class AddToUserWishlist extends HttpServlet {
	JSONObject jsonData;

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		try {
			if (!(req.getParameter("recipe").equals(""))) {
				Objectify ob = ObjectifyRegisterService.registerService();
				Query<User> query = ob.query(User.class).filter("userMailId",
						req.getParameter("usermailid"));
				if ((query.list().size() == 1)) {
					jsonData = new JSONObject();
					// getting data
					String userMailId = req.getParameter("usermailid");
					// setting data
					User user = new User();
					user.setUserMailId(userMailId);

					if (query.list().get(0).getUserWish() != null) {
						boolean recipeAlreadyExist = false;
						for (String recipeString : query.list().get(0)
								.getUserWish()) {
							if ((recipeString
									.equals(req.getParameter("recipe")))) {
								recipeAlreadyExist = true;
							}
						}
						if (recipeAlreadyExist == false) {
							ArrayList<String> wishlist = query.list().get(0)
									.getUserWish();
							wishlist.add(req.getParameter("recipe"));
							user.setUserWish(wishlist);
							jsonData.put("wishliststatus", "added");
						} else {
							ArrayList<String> wishlist = query.list().get(0)
									.getUserWish();
							user.setUserWish(wishlist);
							jsonData.put("wishliststatus", "already_added");
						}
					} else {
						ArrayList<String> wishlist = new ArrayList<>();
						wishlist.add(req.getParameter("recipe"));
						user.setUserWish(wishlist);
						jsonData.put("wishliststatus", "added");
					}
					// saving to datastore
					ob.put(user);
					jsonData.put("userstatus", "exist");
					out.println(jsonData.toString());
				} else {
					jsonData = new JSONObject();
					jsonData.put("userstatus", "not_exist");
					jsonData.put("wishliststatus", "not_added");
					out.println(jsonData.toString());
				}
			} else {
				jsonData = new JSONObject();
				jsonData.put("userstatus", "cannot_be_judged");
				jsonData.put("wishliststatus", "not_added");
				jsonData.put("error", "recipe_empty");
				out.println(jsonData.toString());
			}
		} catch (Exception e) {
			jsonData = new JSONObject();
			jsonData.put("userstatus", "exist");
			jsonData.put("wishliststatus", "not_added");
			jsonData.put("error", e);
			out.println(jsonData.toString());
		}

	}
}
