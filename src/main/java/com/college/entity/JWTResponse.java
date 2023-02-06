/**
 * 
 */
package com.college.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Feb 1, 2023
*	file Name:  JWTResponse.java
*	Time :   	2:05:44 PM
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTResponse {

	private String token;
	
}