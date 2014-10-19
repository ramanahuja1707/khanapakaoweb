package com.khanapakao.dto;

import java.util.Date;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class Recipe {
	@Id
	String recipeName;
	String category;
	String description;
	@ElementCollection(fetch = FetchType.EAGER)
	String instructions;
	String timeToPrepare;
	String timeTocook;
	String totalTime;
	boolean videoStatus;
	String videoLink;
	String imageName;
	boolean imageStatus;
	String recipeOrigin;
	String recipeTaste;
	long totalLikes;
	long totalComment;
	float totalRating;
	String type;
	@Temporal(TemporalType.DATE)
	Date recipePostedDate;
	long serving;

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getTimeToPrepare() {
		return timeToPrepare;
	}

	public void setTimeToPrepare(String timeToPrepare) {
		this.timeToPrepare = timeToPrepare;
	}

	public String getTimeTocook() {
		return timeTocook;
	}

	public void setTimeTocook(String timeTocook) {
		this.timeTocook = timeTocook;
	}

	public String getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}

	public void setVideoStatus(boolean videoStatus) {
		this.videoStatus = videoStatus;
	}

	public boolean getVideoStatus() {
		return videoStatus;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public boolean getImageStatus() {
		return imageStatus;
	}

	public void setImageStatus(boolean imageStatus) {
		this.imageStatus = imageStatus;
	}

	public String getRecipeOrigin() {
		return recipeOrigin;
	}

	public void setRecipeOrigin(String recipeOrigin) {
		this.recipeOrigin = recipeOrigin;
	}

	public String getRecipeTaste() {
		return recipeTaste;
	}

	public void setRecipeTaste(String recipeTaste) {
		this.recipeTaste = recipeTaste;
	}

	public long getTotalLikes() {
		return totalLikes;
	}

	public void setTotalLikes(long totalLikes) {
		this.totalLikes = totalLikes;
	}

	public long getTotalComment() {
		return totalComment;
	}

	public void setTotalComment(long totalComment) {
		this.totalComment = totalComment;
	}

	public float getTotalRating() {
		return totalRating;
	}

	public void setTotalRating(float totalRating) {
		this.totalRating = totalRating;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getRecipePostedDate() {
		return recipePostedDate;
	}

	public void setRecipePostedDate(Date recipePostedDate) {
		this.recipePostedDate = recipePostedDate;
	}

	public long getServing() {
		return serving;
	}

	public void setServing(long serving) {
		this.serving = serving;
	}
}
