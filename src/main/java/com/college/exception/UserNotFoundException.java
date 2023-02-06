package com.college.exception;


/*
*	author:  	Himanshu Upadhyay
*	Date:  		Jan 24, 2023
*	file Name:  UserNotFoundException.java
*	Time :   	12:32:56 PM
*/


public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException() {
		super("User not found !! ");
	}

	
	public UserNotFoundException(String message) {
		super(message);
	}


	

}
