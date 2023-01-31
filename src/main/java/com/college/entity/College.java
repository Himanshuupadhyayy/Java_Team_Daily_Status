
 package com.college.entity;
 
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.utility.RandomString;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Jan 24, 2023
*	file Name:  College.java
*	Time :   	12:32:39 PM
*/


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class College {
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int collegeId;
	private String collegeName;
	private String collegeAddress;
	private String collegeState;
	private String collegePassword;
	private String collegeEmail;
	
	private String collegeType;
	private String universityName;
	private boolean status = true;
	
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private Type type;
	
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private UniversityName universityName;
	
	@CreationTimestamp
	private Timestamp registerOn;
	@UpdateTimestamp
	private Timestamp updateOn;
	
	
	
}