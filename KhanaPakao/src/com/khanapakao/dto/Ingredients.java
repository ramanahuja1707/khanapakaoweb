package com.khanapakao.dto;

import javax.persistence.Id;

public class Ingredients {
	@Id
	String recipeName;
	String ingredientName;
	String ingredientQuantity;
	String ingredientImageName;
	String ingredientDescription;
}
