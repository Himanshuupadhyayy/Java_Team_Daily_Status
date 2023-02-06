/**
 * 
 */
package com.college.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.college.entity.User;
import com.college.repository.UserRepository;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Feb 1, 2023
*	file Name:  UserDetailsService.java
*	Time :   	2:08:09 PM
*/

@Service
public class UserDetailsServiceSecurity implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=this.userRepository.findByUsername(username);
		if(user==null) {
			System.out.println("user name is not avaliable");
			throw new UsernameNotFoundException("no user found");
		}
		return user;
	}

	
	
}