package com.khanapakao.dto;

import java.util.ArrayList;

import javax.persistence.Id;

public class RecipeUserComments {

	@Id
	String recipeName;
	String userMailId;
	ArrayList<String> comments;
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getUserMailId() {
		return userMailId;
	}
	public void setUserMailId(String userMailId) {
		this.userMailId = userMailId;
	}
	public ArrayList<String> getComments() {
		return comments;
	}
	public void setComments(ArrayList<String> comments) {
		this.comments = comments;
	}

}
