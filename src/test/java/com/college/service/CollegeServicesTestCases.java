/**
 * 
 */
package com.college.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.BDDMockito.given;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.college.CollegeManagementSystemDetailsCollegeApplication;
import com.college.entity.College;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Jan 30, 2023
*	file Name:  CollegeServicesTestCases.java
*	Time :   	4:02:16 PM
*/
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(classes = CollegeManagementSystemDetailsCollegeApplication.class)
public class CollegeServicesTestCases {

	@MockBean
	private CollegeService collegeService;

	 private College getCollege() {
	      College college = new College();
	      college.setCollegeId(1);
	      college.setCollegeName("itmm");
	      college.setCollegeAddress("noidda up");
	      college.setCollegeEmail("itm@gmail.com");
	      return college;
	   }
	
	 
	 @Test
	 @Order(1)
	 public void getAllColleges(){
	      College college = getCollege();
	      List<College> colleges = new ArrayList<>();
	      colleges.add(college);
	      given(collegeService.getAllColleges()).willReturn(colleges);
	      List<College> result = collegeService.getAllColleges();
	      assertEquals(result.size(), 1);
	   }


	 @Test
	 @Order(2)
	   public void getcollegeDetails(){
		 College college = getCollege();
	      given(collegeService.getCollege(1)).willReturn(college);
	      College result = collegeService.getCollege(1);
	      assertEquals(result.getCollegeId(), 1);	
	   }
	   @Test
	   @Order(4)
	   public void deleteCollegeDetails(){
	      doNothing().when(collegeService).deleteCollege(1);
	      collegeService.deleteCollege(1);
	      assertTrue(true);
	   }
	   
	   
	   @Test
	   @Order(3)
	   public void updateCollegeDetails() throws Exception {
	      College college = getCollege();
	      doNothing().when(collegeService).updateCollege(college);	
	      collegeService.updateCollege(college);
	      assertTrue(true);
	   }


	 
}