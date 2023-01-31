package com.college.exception;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Jan 24, 2023
*	file Name:  CollegeFoundException.java
*	Time :   	12:32:26 PM
*/
public class CollegeFoundException extends Exception {

	public CollegeFoundException(String message) {
		super(message);
	}
	
	public CollegeFoundException() {
		super("college with this college id is not registered!! ");
	}

	
	
}