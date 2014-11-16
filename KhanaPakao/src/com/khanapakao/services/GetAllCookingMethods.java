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
import com.khanapakao.dto.CookingMethods;

@SuppressWarnings("serial")
public class GetAllCookingMethods extends HttpServlet {
	JSONObject jsonData;

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/json");
		try {
			Objectify ob = ObjectifyRegisterService.registerService();
			Query<CookingMethods> q = (Query<CookingMethods>) ob.query(
					CookingMethods.class);
			if (q.list().size() > 0) {
				JSONArray cookingMethods = new JSONArray();
				for (CookingMethods method : q) {
					JSONObject tempMethod = new JSONObject();
					tempMethod.put("methoddescription",
							method.getMethodDescription());
					tempMethod.put("methodimagename",
							method.getMethodImageName());
					tempMethod.put("methodingredients",
							method.getMethodIngredients());
					tempMethod.put("methodinstructions",
							method.getMethodInstructions());
					tempMethod.put("methodname", method.getMethodName());
					tempMethod.put("methodvideolink",
							method.getMethodVideoLink());
					cookingMethods.add(tempMethod);
				}
				jsonData = new JSONObject();
				jsonData.put("cookingmethods", cookingMethods);
				jsonData.put("cookingmethodstatus", "ok");
				// jsonData.put("data", q.list());
				// Gson gsonData = new Gson();
				// String data = gsonData.toJson(q.list(), ArrayList.class);
				out.println(jsonData.toJSONString());
			} else {
				jsonData = new JSONObject();
				jsonData.put("cookingmethods", null);
				jsonData.put("cookingmethodstatus", "not_ok");
				out.println(jsonData.toJSONString());
			}
		} catch (Exception e) {
			jsonData = new JSONObject();
			jsonData.put("cookingmethods", null);
			jsonData.put("cookingmethodstatus", "not_ok");
			jsonData.put("error", e);
			out.println(jsonData.toJSONString());
		}

	}
}
