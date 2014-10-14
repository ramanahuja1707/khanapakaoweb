package com.khanapakao.dto;

import java.util.ArrayList;

import javax.persistence.Id;

public class User {

	@Id
	String userMailId;
	String userPassword;
	ArrayList<String> userWish;
	public String getUserMailId() {
		return userMailId;
	}
	public void setUserMailId(String userMailId) {
		this.userMailId = userMailId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public ArrayList<String> getUserWish() {
		return userWish;
	}
	public void setUserWish(ArrayList<String> userWish) {
		this.userWish = userWish;
	}
	
}
