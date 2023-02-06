///**
// * 
// */
//package com.college.repo;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.college.CollegeManagementSystemDetailsCollegeApplication;
//import com.college.entity.User;
//import com.college.repository.UserRepository;
//
///*
//*	author:  	Himanshu Upadhyay
//*	Date:  		Jan 30, 2023
//*	file Name:  ColllegeRepositoryTestCases.java
//*	Time :   	2:16:54 PM
//*/
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(classes = CollegeManagementSystemDetailsCollegeApplication.class)
//public class ColllegeRepositoryTestCases {
//	
//	@Autowired
//	private UserRepository userRepository;
//
//	   private User getCollege() {
//		      User user = new User();
//		      user.setCollegeId(1);
//		      user.setCollegeName("itmm");
//		      user.setCollegeEmail("itmm@gmail.com");
//		      user.setCollegeAddress("aligarh up");
//		      return user;
//		   }
//
//	
//	@Test
//	public void findByCollegeId() {
//		User user= getCollege();
//		userRepository.save(user);
//		System.out.println("working 1");
//		User result=userRepository.findById(user.getCollegeId()).get();
//		assertEquals(user.getCollegeId(), result.getCollegeId());
//	}
//
//	
//	 @Test
//	 public void findAllCollege() {
//	      User user = getCollege();
//	      userRepository.save(user);
//			System.out.println("working 2");
//	      List<User> result = new ArrayList<>();
//	      userRepository.findAll().forEach(e -> result.add(e));
//	      assertEquals(result.size(), 1);	     
//	 }
//	
//	 @Test
//	 public void saveCollegeDetails() {
//	      User user = getCollege();
//	      userRepository.save(user);
//			System.out.println("working 3");
//	      User found = userRepository.findById(user.getCollegeId()).get();
//	      assertEquals(user.getCollegeId(), found.getCollegeId());	     
//	 }
//	 
//	 @Test
//	 public void deleteCollegeById() {
//	      User user = getCollege();
//	      userRepository.save(user);
//			System.out.println("working 4");
//	      userRepository.deleteById(user.getCollegeId());
//	      List<User> result = new ArrayList<>();
//	      userRepository.findAll().forEach(e -> result.add(e));
//	      assertEquals(result.size(), 0);
//	 }
//	 
//
//	 
//}