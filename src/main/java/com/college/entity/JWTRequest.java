/**
 * 
 */
package com.college.entity;

import javax.persistence.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Feb 1, 2023
*	file Name:  JWTRequest.java
*	Time :   	2:05:34 PM
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTRequest {

	private String username;
	private String password;
	
	
}
