package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.entity.User;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Jan 24, 2023
*	file Name:  CollegeRepository.java
*	Time :   	12:33:01 PM
*/
public interface UserRepository extends JpaRepository<User, Integer>{

	
	User findByUsernameOrUserEmail(String username, String userEmail);
	User findByUserEmail(String userEmail);
	User findByUsername(String username);
}