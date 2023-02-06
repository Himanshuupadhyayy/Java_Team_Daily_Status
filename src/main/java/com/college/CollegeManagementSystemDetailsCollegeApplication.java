package com.college;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.college.entity.Role;
import com.college.entity.User;
import com.college.entity.UserRole;
import com.college.exception.UserFoundException;
import com.college.service.UserService;

@SpringBootApplication
public class CollegeManagementSystemDetailsCollegeApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CollegeManagementSystemDetailsCollegeApplication.class, args);

		System.out.println("this is  management projects for purpose of college");

	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("starting code");
//		try {

//			User user = new User();
//			user.setUsername("admin");
//			user.setPassword("admin");
//			user.setUserEmail("abc@gmail.com");
//			
//			Role role = new Role();
//			role.setRoleId(11L);
//			role.setRoleName("ADMIN");
//
//			Set<UserRole> userRoleSet = new HashSet<>();
//			UserRole userRole = new UserRole();
//	 		userRole.setRole(role);
//			userRole.setUser(user);
//			userRoleSet.add(userRole);
//			this.userService.addUser(user, userRoleSet);

//			User user = new User();
//			user.setUsername("principal");
//			user.setPassword("principal");
//			user.setUserEmail("principal@gmail.com");
//			
//			Role role = new Role();
//			role.setRoleId(12L);
//			role.setRoleName("PRINCIPAL");
//
//			Set<UserRole> userRoleSet = new HashSet<>();
//			UserRole userRole = new UserRole();
//			userRole.setRole(role);
//			userRole.setUser(user);
//			userRoleSet.add(userRole);
//			this.userService.addUser(user, userRoleSet);

			
//			User user = new User();
//			user.setUsername("teacher");
//			user.setPassword("teacher");
//			user.setUserEmail("teacher@gmail.com");
//		
//			Role role = new Role();  
//			role.setRoleId(13L);
//			role.setRoleName("TEACHER");
//
//			Set<UserRole> userRoleSet = new HashSet<>();
//			UserRole userRole = new UserRole();
//			userRole.setRole(role);
//			userRole.setUser(user);
//
//			userRoleSet.add(userRole);
//			System.out.println("working");
//			this.userService.addUser(user, userRoleSet);
			
			
			
//			
//		} catch (UserFoundException e) {
//			e.printStackTrace();
//		}
	}
}