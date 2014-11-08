package com.khanapakao.dto;

import javax.persistence.Id;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class UserRating {
	// stored in form of (reciepName_userMailId_rating)
	@Id
	String ratingId;
	String recipeName;
	String userMailId;
	float rating;

	public String getRatingId() {
		return ratingId;
	}

	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
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

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

}
