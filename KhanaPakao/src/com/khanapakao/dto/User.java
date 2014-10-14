package com.khanapakao.dto;

import java.util.ArrayList;

import javax.persistence.Id;

public class User {

	@Id
	String userMailId;
	ArrayList<String> userWish;

	public String getUserMailId() {
		return userMailId;
	}

	public void setUserMailId(String userMailId) {
		this.userMailId = userMailId;
	}

	public ArrayList<String> getUserWish() {
		return userWish;
	}

	public void setUserWish(ArrayList<String> userWish) {
		this.userWish = userWish;
	}

}
