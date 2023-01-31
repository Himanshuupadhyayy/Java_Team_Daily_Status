package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.entity.College;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Jan 24, 2023
*	file Name:  CollegeRepository.java
*	Time :   	12:33:01 PM
*/
public interface CollegeRepository extends JpaRepository<College, Integer>{

	College findByCollegeNameOrCollegeEmail(String collegeName, String collegeEmail);
	
	College findByCollegeEmail(String collegeEmail);
	
	
}