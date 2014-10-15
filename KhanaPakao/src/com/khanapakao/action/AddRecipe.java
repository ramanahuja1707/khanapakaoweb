package com.khanapakao.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.khanapakao.dto.Recipe;

public class AddRecipe extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		Objectify ob = ObjectifyService.begin();

		// getting data
		String recipeName = req.getParameter("recipeName");
		String category = req.getParameter("category");
		String description = req.getParameter("description");
		String instructions = req.getParameter("instructions");
		String timeToPrepare = req.getParameter("timeToPrepare");
		String timeToCook = req.getParameter("timeToCook");
		String totalTime = req.getParameter("totalTime");
		String videoStatus = req.getParameter("videoStatus");
		String videoLink = req.getParameter("videoLink");
		String imageStatus = req.getParameter("imageStatus");
		String imageName = req.getParameter("recipeName");
		String recipeOrigin = req.getParameter("recipeOrigin");
		String recipeTaste = req.getParameter("recipeTaste");
		String type = req.getParameter("type");
		String serving = req.getParameter("serving");
		Long servingLong = new Long(serving);

		// setting data
		Recipe recipe = new Recipe();
		recipe.setCategory(category);
		recipe.setDescription(description);
		recipe.setImageName(imageName);
		if (imageStatus.equals("enable"))
			recipe.setImageStatus(true);
		else
			recipe.setImageStatus(false);
		recipe.setInstructions(instructions);
		recipe.setRecipeName(recipeName);
		recipe.setRecipeOrigin(recipeOrigin);
		recipe.setRecipePostedDate(new Date());
		recipe.setRecipeTaste(recipeTaste);
		recipe.setServing(servingLong);
		recipe.setTimeTocook(timeToCook);
		recipe.setTimeToPrepare(timeToPrepare);
		recipe.setTotalTime(totalTime);
		recipe.setTotalComment(0);
		recipe.setTotalLikes(0);
		recipe.setTotalRating(0);
		recipe.setType(type);
		recipe.setVideoLink(videoLink);
		if (videoStatus.equals("enable"))
			recipe.setVideoStatus(true);
		else
			recipe.setVideoStatus(false);

		// saving to datastore
		ob.put(recipe);
		resp.getWriter().println("Data Saved");
	}
}
