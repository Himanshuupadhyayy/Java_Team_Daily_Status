//package com.college.repo;
//
//import java.util.List;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.college.entity.College;
//import com.college.repository.CollegeRepository;
//
///*
//*	author:  	Himanshu Upadhyay
//*	Date:  		Jan 25, 2023
//*	file Name:  CollegeRepoTests.java
//*
//*/
//@SpringBootTest
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class CollegeRepoTests {
//
//	@Autowired
//	private CollegeRepository collegeRepository;
//	  
//
//	 	@Test
//	    @Order(1)
//	    public void saveEmployeeTest(){
//	        College college=College.builder()
//	        		.collegeAddress("jalesar")
//	        		.collegeEmail("itm@gmail.com")
//	        		.collegeName("itm")
//	        		.collegeState("up").build();
//	        collegeRepository.save(college);
//	        Assertions.assertThat(college.getCollegeId()).isGreaterThan(0);
//	    }
//
//	    @Test
//	    @Order(2)
//	    public void getEmployeeTest(){
//	    	College college=collegeRepository.findById(7).get();
//	    	System.out.println(college);
//	        Assertions.assertThat(college.getCollegeId()).isEqualTo(7);
//	    }
//
//	    @Test
//	    @Order(3)
//	    public void getListOfEmployeeTest(){
//	        List<College> college=collegeRepository.findAll();
//	        Assertions.assertThat(college.size()).isGreaterThan(1);
//	    }
//
//	    @Test
//	    @Order(4)
//	    public void updateEmployeeTest(){
//	    	College college=collegeRepository.findById(7).get();
//	    	college.setCollegeEmail("upadyay@gmail.com");
//	    	College updateEmployee=collegeRepository.save(college);
//	        Assertions.assertThat(college.getCollegeEmail()).isEqualTo("upadyay@gmail.com");
//	    }
//
//	    @Test
//	    @Order(5)
//	    public void deleteEmployeeTest(){
//	    	College college=collegeRepository.findById(5).get();
//	        collegeRepository.delete(college);
//
//	        College college1=null;
//	        college1=collegeRepository.findByCollegeEmail("upadhyay@gmail.com");
//	        if (college1==null){
//	            Assertions.assertThat(college1).isNull();
//	        }
//	    }
//
//	    @AfterEach
//	    void tearDown() {
//	        System.out.println("after test case");
//	    }
//
//	    @BeforeEach
//	    void setUp(){
//	        System.out.println("before the test case");
//	    }
//	
//}