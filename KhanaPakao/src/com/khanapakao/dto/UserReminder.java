package com.khanapakao.dto;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class UserReminder {
	@Id
	String userMailId;
	String recipeName;
	@Temporal(TemporalType.DATE)
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
