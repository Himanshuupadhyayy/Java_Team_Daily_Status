package com.college.exception;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Jan 24, 2023
*	file Name:  UserFoundException.java
*	Time :   	12:32:26 PM
*/
public class UserFoundException extends Exception {

	public UserFoundException(String message) {	
		super(message);
	}
	
	public UserFoundException() {
		super("User with this User id is not registered!! ");
	}

	
	
}