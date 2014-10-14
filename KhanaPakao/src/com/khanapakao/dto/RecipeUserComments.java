package com.khanapakao.dto;

import java.util.ArrayList;

import javax.persistence.Id;

public class RecipeUserComments {

	@Id
	String recipeName;
	String userMailId;
	ArrayList<String> comments;

}
