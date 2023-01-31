/**
 * 
 */
package com.college.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.college.CollegeManagementSystemDetailsCollegeApplication;
import com.college.entity.College;
import com.college.repository.CollegeRepository;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Jan 30, 2023
*	file Name:  ColllegeRepositoryTestCases.java
*	Time :   	2:16:54 PM
*/

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CollegeManagementSystemDetailsCollegeApplication.class)
public class ColllegeRepositoryTestCases {
	
	@Autowired
	private CollegeRepository collegeRepository;

	   private College getCollege() {
		      College college = new College();
		      college.setCollegeId(1);
		      college.setCollegeName("itmm");
		      college.setCollegeEmail("itmm@gmail.com");
		      college.setCollegeAddress("aligarh up");
		      return college;
		   }

	
	@Test
	public void findByCollegeId() {
		College college= getCollege();
		collegeRepository.save(college);
		System.out.println("working 1");
		College result=collegeRepository.findById(college.getCollegeId()).get();
		assertEquals(college.getCollegeId(), result.getCollegeId());
	}

	
	 @Test
	 public void findAllCollege() {
	      College college = getCollege();
	      collegeRepository.save(college);
			System.out.println("working 2");
	      List<College> result = new ArrayList<>();
	      collegeRepository.findAll().forEach(e -> result.add(e));
	      assertEquals(result.size(), 1);	     
	 }
	
	 @Test
	 public void saveCollegeDetails() {
	      College college = getCollege();
	      collegeRepository.save(college);
			System.out.println("working 3");
	      College found = collegeRepository.findById(college.getCollegeId()).get();
	      assertEquals(college.getCollegeId(), found.getCollegeId());	     
	 }
	 
	 @Test
	 public void deleteCollegeById() {
	      College college = getCollege();
	      collegeRepository.save(college);
			System.out.println("working 4");
	      collegeRepository.deleteById(college.getCollegeId());
	      List<College> result = new ArrayList<>();
	      collegeRepository.findAll().forEach(e -> result.add(e));
	      assertEquals(result.size(), 0);
	 }
	 

	 
}