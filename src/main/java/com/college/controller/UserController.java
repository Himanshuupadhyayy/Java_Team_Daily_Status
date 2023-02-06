package com.college.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.college.entity.RecruitTeam;
import com.college.entity.Role;
import com.college.entity.User;
import com.college.entity.UserRole;
import com.college.exception.UserFoundException;
import com.college.exception.UserNotFoundException;
import com.college.service.UserService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/*
*	author:  	Himanshu Upadhyay
*	Date:  		Jan 24, 2023
*	file Name:  userController.java
*	Time :   	11:57:25 AM
*/

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
@Slf4j 
@AllArgsConstructor
public class UserController {

	private UserService userService;
	private RestTemplate restTemplate;

	// add the user details
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody User user)throws UserFoundException{
		log.info("add user method is working at controller");
		User col=null;
		try {
			Set<UserRole> roles= new HashSet<>();
			Role role=new Role();
			role.setRoleId(14L);
			role.setRoleName("NORMAL");
			UserRole userRole=new UserRole();
			userRole.setUser(user);
			userRole.setRole(role);
			roles.add(userRole);			
		 col=this.userService.addUser(user, roles);
		}catch (UserFoundException e) {
			return ResponseEntity.badRequest().body("user is already registered ");
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return ResponseEntity.ok(col);
	}

	@GetMapping("/get/users")
	public List<User> getAllUser(){
		log.info("get all user method is working at controller layer");		
		 List<User> users=this.userService.getAllUsers();
		 return users;
	}

	// get the user by id
	@GetMapping("/get/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable int userId)throws UserNotFoundException{
		log.info("get user by id method is working at controller");
		User user=null;
		try {
		user=this.userService.getUser(userId);
		RecruitTeam help=this.restTemplate.getForObject("http://localhost:8081/recruitment/getRecruit/"+user.getUserId(), RecruitTeam.class);
	///	List<RecruitTeam> recruitTeam=Arrays.stream(help).toList();	
		user.setRecruitTeam(help);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body("user is not registered with this user id "+userId);
		}
		return ResponseEntity.ok(user);
	}

	// delete user by id
	@DeleteMapping("/delete/{userId}")
	public void deleteUserById(@PathVariable int userId) {
		log.info("delete user by id method is working at controller");
		this.userService.deleteUser(userId);
	}

	// update user by id
	@PutMapping("/update/{userId}")
	public User updateUserById(@RequestBody User user) {
		log.info("update user method is working at controller");
		return this.userService.updateUser(user);
	}
}