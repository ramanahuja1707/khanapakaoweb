package com.khanapakao.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.khanapakao.dto.Ingredients;
import com.khanapakao.dto.Recipe;
import com.khanapakao.dto.RecipeUserComments;
import com.khanapakao.dto.User;
import com.khanapakao.dto.UserRating;
import com.khanapakao.dto.UserReminder;

@SuppressWarnings("serial")
public class ObjectifyRegisterService extends HttpServlet {

	// @Override
	// public void init() throws ServletException {
	// ObjectifyService.register(User.class);
	// ObjectifyService.register(Recipe.class);
	// ObjectifyService.register(User.class);
	// ObjectifyService.register(RecipeUserComments.class);
	// ObjectifyService.register(Ingredients.class);
	// ObjectifyService.register(UserReminder.class);
	// }

	static {
		ObjectifyService.register(User.class);
		ObjectifyService.register(Recipe.class);
		ObjectifyService.register(RecipeUserComments.class);
		ObjectifyService.register(Ingredients.class);
		ObjectifyService.register(UserReminder.class);
		ObjectifyService.register(UserRating.class);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.sendRedirect("adminLogin.jsp");
	}

	public static Objectify registerService() {
		return ObjectifyService.begin();
	}

	public static ObjectifyFactory factory() {
		return ObjectifyService.factory();
	}

}
