///**
// * 
// */
//package com.college.service;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.BDDMockito.given;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import com.college.CollegeManagementSystemDetailsCollegeApplication;
//import com.college.entity.User;
//
///*
//*	author:  	Himanshu Upadhyay
//*	Date:  		Jan 30, 2023
//*	file Name:  CollegeServicesTestCases.java
//*	Time :   	4:02:16 PM
//*/
//@ExtendWith(SpringExtension.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest(classes = CollegeManagementSystemDetailsCollegeApplication.class)
//public class CollegeServicesTestCases {
//
//	@MockBean
//	private UserService userService;
//
//	 private User getCollege() {
//	      User user = new User();
//	      user.setCollegeId(1);
//	      user.setCollegeName("itmm");
//	      user.setCollegeAddress("noidda up");
//	      user.setCollegeEmail("itm@gmail.com");
//	      return user;
//	   }
//	
//	 
//	 @Test
//	 @Order(1)
//	 public void getAllColleges(){
//	      User user = getCollege();
//	      List<User> users = new ArrayList<>();
//	      users.add(user);
//	      given(userService.getAllColleges()).willReturn(users);
//	      List<User> result = userService.getAllColleges();
//	      assertEquals(result.size(), 1);
//	   }
//
//
//	 @Test
//	 @Order(2)
//	   public void getcollegeDetails(){
//		 User user = getCollege();
//	      given(userService.getCollege(1)).willReturn(user);
//	      User result = userService.getCollege(1);
//	      assertEquals(result.getCollegeId(), 1);	
//	   }
//	   @Test
//	   @Order(4)
//	   public void deleteCollegeDetails(){
//	      doNothing().when(userService).deleteCollege(1);
//	      userService.deleteCollege(1);
//	      assertTrue(true);
//	   }
//	   
//	   
//	   @Test
//	   @Order(3)
//	   public void updateCollegeDetails() throws Exception {
//	      User user = getCollege();
//	      doNothing().when(userService).updateCollege(user);	
//	      userService.updateCollege(user);
//	      assertTrue(true);
//	   }
//
//
//	 
//}