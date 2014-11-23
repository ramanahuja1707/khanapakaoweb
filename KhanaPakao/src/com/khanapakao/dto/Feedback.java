package com.khanapakao.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Feedback {
	// id=userMailId+"_"+feedback
	@Id
	String id;
	String userMailId;
	String feedback;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserMailId() {
		return userMailId;
	}
	public void setUserMailId(String userMailId) {
		this.userMailId = userMailId;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}
