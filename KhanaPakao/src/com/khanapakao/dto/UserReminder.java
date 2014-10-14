package com.khanapakao.dto;

import java.util.Date;

import javax.persistence.Id;

public class UserReminder {
	@Id
	String userMailId;
	String recipeName;
	Date remiderDate;
	public String getUserMailId() {
		return userMailId;
	}
	public void setUserMailId(String userMailId) {
		this.userMailId = userMailId;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public Date getRemiderDate() {
		return remiderDate;
	}
	public void setRemiderDate(Date remiderDate) {
		this.remiderDate = remiderDate;
	}

}
