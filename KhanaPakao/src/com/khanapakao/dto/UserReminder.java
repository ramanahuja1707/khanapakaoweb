package com.khanapakao.dto;

import java.util.Date;

import javax.persistence.Id;

public class UserReminder {
	@Id
	String userMailId;
	String recipeName;
	Date remiderDate;

}
