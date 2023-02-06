package com.college.service;


import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.college.entity.User;
import com.college.entity.UserRole;
import com.college.exception.UserFoundException;
import com.college.repository.*;
import lombok.extern.slf4j.Slf4j;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Jan 24, 2023
*	file Name:  userService.java
*	Time :   	11:56:26 AM
*/
@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User addUser(User user, Set<UserRole> userRoles)throws Exception{
		log.info("add user method is working at service layer");
		User local=null;
//		UUID uuid= UUID.randomUUID();
//		String password= String.valueOf(uuid);
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		local = this.userRepository.findByUsernameOrUserEmail(user.getUsername(), user.getUserEmail());
		if (local != null) {
			System.out.println("user is already have");
			throw new UserFoundException("user is already registered with us !!");
		}
		for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
		}
		user.getUserRoles().addAll(userRoles);
		return this.userRepository.save(user);
	
	}
	//get all users
	public List<User> getAllUsers() {
		log.info("get all user method is working at service layer");
		List<User> users=this.userRepository.findAll();
		return users;
	}

	// get user
	public User getUser(int id) {
		log.info("get user by id method is working at service");
		return this.userRepository.findById(id).get();
	}

	// delete user
	public void deleteUser(int id) {
		log.info("delete user by id method is working at service");
		this.userRepository.deleteById(id);
	}

	// update user
	public User updateUser(User user) {
		log.info("update user details method is working at service");
		user.setUserId(user.getUserId());
		return this.userRepository.save(user);
	}
	


}