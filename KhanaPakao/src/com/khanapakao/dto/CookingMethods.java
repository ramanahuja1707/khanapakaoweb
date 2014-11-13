package com.khanapakao.dto;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CookingMethods {
	@Id
	String methodName;
	String methodImageName;
	String methodDescription;
	String methodVideoLink;
	String methodIngredients;
	String methodInstructions;
	Date dateofPosting;

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getMethodImageName() {
		return methodImageName;
	}

	public void setMethodImageName(String methodImageName) {
		this.methodImageName = methodImageName;
	}

	public String getMethodDescription() {
		return methodDescription;
	}

	public void setMethodDescription(String methodDescription) {
		this.methodDescription = methodDescription;
	}

	public String getMethodVideoLink() {
		return methodVideoLink;
	}

	public void setMethodVideoLink(String methodVideoLink) {
		this.methodVideoLink = methodVideoLink;
	}

	public String getMethodIngredients() {
		return methodIngredients;
	}

	public void setMethodIngredients(String methodIngredients) {
		this.methodIngredients = methodIngredients;
	}

	public String getMethodInstructions() {
		return methodInstructions;
	}

	public void setMethodInstructions(String methodInstructions) {
		this.methodInstructions = methodInstructions;
	}

	public Date getDateofPosting() {
		return dateofPosting;
	}

	public void setDateofPosting(Date dateofPosting) {
		this.dateofPosting = dateofPosting;
	}

}
