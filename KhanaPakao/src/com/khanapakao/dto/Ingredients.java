package com.khanapakao.dto;

import javax.persistence.Id;

public class Ingredients {
	@Id
	String recipeName;
	String ingredientName;
	String ingredientQuantity;
	String ingredientImageName;
	String ingredientDescription;
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getIngredientName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public String getIngredientQuantity() {
		return ingredientQuantity;
	}
	public void setIngredientQuantity(String ingredientQuantity) {
		this.ingredientQuantity = ingredientQuantity;
	}
	public String getIngredientImageName() {
		return ingredientImageName;
	}
	public void setIngredientImageName(String ingredientImageName) {
		this.ingredientImageName = ingredientImageName;
	}
	public String getIngredientDescription() {
		return ingredientDescription;
	}
	public void setIngredientDescription(String ingredientDescription) {
		this.ingredientDescription = ingredientDescription;
	}
	
}
