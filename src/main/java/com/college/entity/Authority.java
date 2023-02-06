/**
 * 
 */
package com.college.entity;

import org.springframework.security.core.GrantedAuthority;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Feb 1, 2023
*	file Name:  Authority.java
*	Time :   	1:27:33 PM
*/
public class Authority implements GrantedAuthority{

	private String authority;
	
	public Authority(String authority) {
		super();
		this.authority = authority;
	}



	@Override
	public String getAuthority() {
		return this.authority;
	}

}
