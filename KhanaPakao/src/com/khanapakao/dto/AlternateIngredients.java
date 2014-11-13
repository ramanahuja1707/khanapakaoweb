package com.khanapakao.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AlternateIngredients {
	@Id
	String ingredientName;
	String ingredientAlternateName;
	String ingredientImageName;
	String ingredientAlternateImageName;
	String ingredientQuantity;
	String ingredientAlternateQuantity;
	String ingredientDescription;
	String ingredientAlternateDescription;
	public String getIngredientName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public String getIngredientAlternateName() {
		return ingredientAlternateName;
	}
	public void setIngredientAlternateName(String ingredientAlternateName) {
		this.ingredientAlternateName = ingredientAlternateName;
	}
	public String getIngredientImageName() {
		return ingredientImageName;
	}
	public void setIngredientImageName(String ingredientImageName) {
		this.ingredientImageName = ingredientImageName;
	}
	public String getIngredientAlternateImageName() {
		return ingredientAlternateImageName;
	}
	public void setIngredientAlternateImageName(String ingredientAlternateImageName) {
		this.ingredientAlternateImageName = ingredientAlternateImageName;
	}
	public String getIngredientQuantity() {
		return ingredientQuantity;
	}
	public void setIngredientQuantity(String ingredientQuantity) {
		this.ingredientQuantity = ingredientQuantity;
	}
	public String getIngredientAlternateQuantity() {
		return ingredientAlternateQuantity;
	}
	public void setIngredientAlternateQuantity(String ingredientAlternateQuantity) {
		this.ingredientAlternateQuantity = ingredientAlternateQuantity;
	}
	public String getIngredientDescription() {
		return ingredientDescription;
	}
	public void setIngredientDescription(String ingredientDescription) {
		this.ingredientDescription = ingredientDescription;
	}
	public String getIngredientAlternateDescription() {
		return ingredientAlternateDescription;
	}
	public void setIngredientAlternateDescription(
			String ingredientAlternateDescription) {
		this.ingredientAlternateDescription = ingredientAlternateDescription;
	}
}
