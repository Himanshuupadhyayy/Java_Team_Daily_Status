/**
 * 
 */
package com.college.entity;

import javax.persistence.Id;

import lombok.Data;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Feb 6, 2023
*	file Name:  RecruitTeam.java
*	Time :   	12:31:05 PM
*/

@Data
public class RecruitTeam {

	@Id
	private int id;
	private String recruiterName;
	private String recruiterEmail;


}
