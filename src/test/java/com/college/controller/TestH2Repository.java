/**
 * 
 */
package com.college.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.entity.College;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Jan 31, 2023
*	file Name:  TestH2Repository.java
*	Time :   	1:55:32 PM
*/
public interface TestH2Repository extends JpaRepository<College, Integer>{

}
