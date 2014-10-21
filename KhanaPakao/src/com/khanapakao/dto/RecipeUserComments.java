package com.khanapakao.dto;

import java.util.ArrayList;

import javax.persistence.Id;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class RecipeUserComments {
	// stored in form of (reciepName_userMailId_comment+commentNo)
	@Id
	String commentId;
	String recipeName;
	String userMailId;
	String comments;

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

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

}
