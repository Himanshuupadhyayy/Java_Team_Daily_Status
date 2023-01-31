//package com.college.controller;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.List;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import com.college.entity.College;
//import com.college.service.CollegeService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
///*
//*	author:  	Himanshu Upadhyay
//*	Date:  		Jan 25, 2023
//*	file Name:  CollegeControllerTests.java
//*	Time :   	4:35:36 PM
//*/
//@ExtendWith(MockitoExtension.class)
//public class CollegeControllerTests {
//
//
//	@Mock
//	private CollegeService collegeService;
//	private College college;
//	private List<College> listCollege;
//	
//	@InjectMocks
//	private CollegeController colleggeController;
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	
//	@BeforeEach
//	public void setup() {
//		college=new College().builder()
//				.collegeAddress("jalesar")
//        		.collegeEmail("itm@gmail.com")
//        		.collegeName("itm")
//        		.collegeState("up").build();
//	}
//	
//	@AfterEach
//	void finish() {
//		college=null;
//	}
//	
//	@Test
//	public void postEmployeeData() throws Exception{
//	   when(collegeService.addCollege(any())).thenReturn(college);
//	   mockMvc.perform(post("/college/addCollege").
//	           contentType(MediaType.APPLICATION_JSON).
//	           content(asJsonString(college))).
//	           andExpect(status().isCreated());
//	   verify(collegeService,times(1)).addCollege(any());
//	}
//
//	@Test
//	public void getAllEmployeeData() throws Exception {
//	    when(collegeService.getAllColleges()).thenReturn(listCollege);
//	    mockMvc.perform(MockMvcRequestBuilders.get("/college/colleges").
//	                   contentType(MediaType.APPLICATION_JSON).
//	                   content(asJsonString(listCollege))).
//	                   andDo(MockMvcResultHandlers.print());
//	    verify(collegeService).getAllColleges();
//	    verify(collegeService,times(1)).getAllColleges();
//	}
//	
//	
//	@Test
//	public void getEmployeeById() throws Exception {
//	    when(collegeService.getCollege(1)).thenReturn(college);
//	    mockMvc.perform(get("/college/1").
//	           contentType(MediaType.APPLICATION_JSON).
//	           content(asJsonString(college))).
//	           andExpect(MockMvcResultMatchers.status().isOk()).
//	           andDo(MockMvcResultHandlers.print());
//	}
//
//	
////	@Test
////	public void deleteEmployee(){
////	     doNothing().when(collegeService.deleteCollege(1)).thenReturn(college);
////	      mockMvc.perform(delete("/emp/1")
////	      .contentType(MediaType.APPLICATION_JSON)
////	      .content(asJsonString(college)))
////	      .andExpect(MockMvcResultMatchers.status().isOk()).
////	      andDo(MockMvcResultHandlers.print());
////	}
//	
//
//	
//	public static String asJsonString(final Object obj){
//	    try{
//	        return new ObjectMapper().writeValueAsString(obj);
//	    }catch (Exception e){
//	           throw new RuntimeException(e);
//	      }
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//}