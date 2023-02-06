///**
// * 
// */
//package com.college.controller;
//
//import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.util.List;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.web.client.RestTemplate;
//
//import com.college.entity.User;
//
//
///*
//*	author:  	Himanshu Upadhyay
//*	Date:  		Jan 31, 2023
//*	file Name:  CollegeControllerTestCases.java
//*	Time :   	13:24:11 PM
//*/
//
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class CollegeControllerTestCases {
//
//	@LocalServerPort
//	private int port;
//	@Autowired
//	private TestH2Repository h2Repository;
//	
//	private String url="http://localhost:";
//
//	private static RestTemplate restTemplate() {
//		return new RestTemplate();
//	};
//	
//	
//	@BeforeEach
//	public void setUp() {
//		url=url.concat(port+"").concat("/college");
//	}
//	
//	private User getCollege() {
//	      User user = new User();
//	      user.setUserId(1);
//	      user.setCollegeName("itmm");
//	      user.setCollegeEmail("itmm@gmail.com");
//	      user.setCollegeAddress("aligarh up");
//	      return user;
//	}
//	 	
//	 
//	@Test
//	@Order(1)
//	public void testAddCollege() {
//		User user=getCollege();
//		User college1=restTemplate().postForObject(url+"/addCollege" , user, user.getClass());
//		assertEquals("itmm", college1.getCollegeName());
//		assertEquals(1, h2Repository.findAll().size());
//	}
//	
//	@Test
//	@Order(2)
//	public void testGetCollegeById() {
//		User user=getCollege();
//		
//		User coll=restTemplate().getForObject(url+"/{collegeId}", user.getClass(), user.getCollegeId());
//		assertAll(
//				() -> assertNotNull(coll),
//				() -> assertEquals("itmm", user.getCollegeName()),
//				() -> assertEquals(1, user.getCollegeId())
//				);
//	}
//	
//	@Test
//	@Order(3)
//	public void testGetAllColleges() {
//		User user=getCollege();
//	
//		List<User> users=restTemplate().getForObject(url+"/colleges", List.class);
//		assertEquals(1, users.size());
//		assertEquals(1, h2Repository.findAll().size());
//	}
//	
//		
//	@Test
//	@Order(4)
//	public void testUpdateCollege() {
//		User user=new User(1, "vision", "noida", null, null, "vision@gmail.com", null, null, true, null, null);
//		restTemplate().put(url+"/col/{collegeId}", user, 1);
//		User collegeDb=h2Repository.findById(1).get();
//		assertAll(
//				() -> assertNotNull(collegeDb),
//				() -> assertEquals("noida", collegeDb.getCollegeAddress())
//				);
//	}
//
// 	@Test
//	@Order(5)
//	public void testDeleteCollege() {
//		int count=h2Repository.findAll().size();
//		System.out.println(count);
//		assertEquals(1, count);
//		restTemplate().delete(url+"/col/{collegeId}", 1);
//		assertEquals(0, h2Repository.findAll().size());
//	}
//}