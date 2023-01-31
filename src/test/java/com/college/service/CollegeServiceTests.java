//package com.college.service;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.college.entity.College;
//import com.college.repository.CollegeRepository;
//
///*
//*	author:  	Himanshu Upadhyay
//*	Date:  		Jan 25, 2023
//*	file Name:  CollegeServiceTests.java
//*	
//*/
//
//
//@ExtendWith(MockitoExtension.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class CollegeServiceTests {
//
//	@Mock
//	private CollegeRepository collegeRepository;
//	
//	@InjectMocks
//	private CollegeService collegeService;
//	private Optional<College> college1;
//	private College college;
//	
//	@BeforeEach
//	public void setUp() {
//		college=College.builder()
//				.collegeName("vision")
//				.collegeAddress("aligarh")
//				.collegeEmail("visions@gmail.com")
//				.collegeState("up").build();
//	}
//	
//	@Test
//	@Order(1)
//	public void saveCollegeDetails() throws Exception {
//		college=College.builder()
//				.collegeEmail("ramesh@gmail.com")
//				.collegeName("acet")
//				.collegeAddress("agra")
//				.collegeState("up").build();
//		when(collegeRepository.save(any(College.class))).thenReturn(college);
//		college=collegeService.addCollege(college);
//		verify(collegeRepository, times(1)).save(any(College.class));
//	}
//	
//	@Test
//	@Order(2)
//	void getAllColleges() {
//		collegeService.getAllColleges();
//		verify(collegeRepository).findAll();
//	}
//	
//	@Test
//	@Order(3)
//	public void getCollegeById() {
//		when(collegeRepository.findById(6)).thenReturn(college1);
//		System.out.println(college1.get().getCollegeId());
//		System.out.println("working");
//		College getColl=collegeService.getCollege(4);
//		System.out.println("working  2");
//		System.out.println(getColl.getCollegeEmail());
//		assertThat(getColl).isNotNull();
//	}
//	
//	@Test
//	@Order(4)
//	public void deleteEmployee() {
//		doNothing().when(collegeRepository).deleteById(6);
//		collegeService.deleteCollege(6);
//		verify(collegeRepository, times(1)).deleteById(6);
//	}
//
//	
//	@Test
//	@Order(5)
//	public void updateEmployee() {
//		given(collegeRepository.save(college)).willReturn(college);
//		college.setCollegeEmail("iitm@gmail.com");
//		College updateCol=collegeService.updateCollege(college);
//		assertThat(updateCol.getCollegeEmail()).isEqualTo("iitm@gmail.com");
//	}
//	
//	
//}