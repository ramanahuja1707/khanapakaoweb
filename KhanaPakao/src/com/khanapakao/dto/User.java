package com.khanapakao.dto;

import java.util.ArrayList;

import javax.persistence.Id;

public class User {

	@Id
	String userMailId;
	String userPassword;
	ArrayList<String> userWish;
}
