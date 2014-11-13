package com.khanapakao.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.khanapakao.dto.CookingMethods;

@SuppressWarnings("serial")
public class AddCookingMethods extends HttpServlet {
	ArrayList<String> jsonData;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try {
			Objectify ob = ObjectifyService.begin();

			// getting data
			String methodName = req.getParameter("methodName");
			String methodImageName = req.getParameter("methodImageName");
			String methodDescription = req.getParameter("methodDescription");
			String methodVideoLink = req.getParameter("methodVideoLink");
			String methodIngredients = req.getParameter("methodIngredients");
			String methodInstructions = req.getParameter("methodInstructions");

			if (!(methodName.equals(""))) {
				// setting data
				CookingMethods method = new CookingMethods();
				method.setMethodName(methodName);
				method.setDateofPosting(new Date());
				method.setMethodDescription(methodDescription);
				method.setMethodImageName(methodImageName);
				method.setMethodIngredients(methodIngredients);
				method.setMethodInstructions(methodInstructions);
				method.setMethodVideoLink(methodVideoLink);

				// saving to datastore
				ob.put(method);
				out.println("<a href='" + "adminPage.jsp"
						+ "'>Back</a><br><br>");
				out.println("<a href='" + "addCookingMethods.jsp"
						+ "'>Add More Cooking Methods</a><br><br>");
			} else {
				jsonData = new ArrayList<>();
				if (methodName.equals("")) {
					jsonData.add("Cooking Method Name Is Empty");
				}

				out.println("Error generated !!!");
				out.println("<br><br>");
				for (String error : jsonData) {
					out.println(error);
					out.println("<br><br>");
				}

				out.println("<br><br>");
				out.println("<a href='" + "adminPage.jsp"
						+ "'>Back</a><br><br>");
			}

		} catch (Exception e) {
			out.println("Error generated :" + e);
			out.println("<br><br>");
			out.println("<a href='" + "adminPage.jsp" + "'>Back</a><br><br>");
		}
	}
}
