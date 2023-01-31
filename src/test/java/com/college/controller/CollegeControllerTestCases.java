/**
 * 
 */
package com.college.controller;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import com.college.entity.College;


/*
*	author:  	Himanshu Upadhyay
*	Date:  		Jan 31, 2023
*	file Name:  CollegeControllerTestCases.java
*	Time :   	13:24:11 PM
*/


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CollegeControllerTestCases {

	@LocalServerPort
	private int port;
	@Autowired
	private TestH2Repository h2Repository;
	
	private String url="http://localhost:";

	private static RestTemplate restTemplate() {
		return new RestTemplate();
	};
	
	
	@BeforeEach
	public void setUp() {
		url=url.concat(port+"").concat("/college");
	}
	
	private College getCollege() {
	      College college = new College();
	      college.setCollegeId(1);
	      college.setCollegeName("itmm");
	      college.setCollegeEmail("itmm@gmail.com");
	      college.setCollegeAddress("aligarh up");
	      return college;
	}
	 	
	 
	@Test
	@Order(1)
	public void testAddCollege() {
		College college=getCollege();
		College college1=restTemplate().postForObject(url+"/addCollege" , college, college.getClass());
		assertEquals("itmm", college1.getCollegeName());
		assertEquals(1, h2Repository.findAll().size());
	}
	
	@Test
	@Order(2)
	public void testGetCollegeById() {
		College college=getCollege();
		
		College coll=restTemplate().getForObject(url+"/{collegeId}", college.getClass(), college.getCollegeId());
		assertAll(
				() -> assertNotNull(coll),
				() -> assertEquals("itmm", college.getCollegeName()),
				() -> assertEquals(1, college.getCollegeId())
				);
	}
	
	@Test
	@Order(3)
	public void testGetAllColleges() {
		College college=getCollege();
	
		List<College> colleges=restTemplate().getForObject(url+"/colleges", List.class);
		assertEquals(1, colleges.size());
		assertEquals(1, h2Repository.findAll().size());
	}
	
		
	@Test
	@Order(4)
	public void testUpdateCollege() {
		College college=new College(1, "vision", "noida", null, null, "vision@gmail.com", null, null, true, null, null);
		restTemplate().put(url+"/col/{collegeId}", college, 1);
		College collegeDb=h2Repository.findById(1).get();
		assertAll(
				() -> assertNotNull(collegeDb),
				() -> assertEquals("noida", collegeDb.getCollegeAddress())
				);
	}

 	@Test
	@Order(5)
	public void testDeleteCollege() {
		int count=h2Repository.findAll().size();
		System.out.println(count);
		assertEquals(1, count);
		restTemplate().delete(url+"/col/{collegeId}", 1);
		assertEquals(0, h2Repository.findAll().size());
	}
}