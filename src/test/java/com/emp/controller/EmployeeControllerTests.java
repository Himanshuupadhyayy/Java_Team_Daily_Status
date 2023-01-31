//package com.emp.controller;
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
//import com.emp.entity.Employee;
//import com.emp.service.impl.EmployeeServiceImpl;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
///*
//*	author:  	Himanshu Upadhyay
//*	Date:  		Jan 24, 2023
//*	file Name:  EmployeeControllerTests.java
//*	Time :   	5:10:40 PM
//*/
//@ExtendWith(MockitoExtension.class)
//public class EmployeeControllerTests {
//
//	@Mock
//	private EmployeeServiceImpl employeeServiceImpl;
//	private Employee employee;
//	private List<Employee> listEmployee;
//	
//	@InjectMocks
//	private EmployeeController employeeController;
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	
//	@BeforeEach
//	public void setup() {
//		employee=new Employee().builder()
//				.firstName("himanshu")
//				.lastName("upadhyay")
//				.email("himanshu@gmail.com").build();
//	}
//	
//	@AfterEach
//	void finish() {
//		employee=null;
//	}
//	
//	@Test
//	public void postEmployeeData() throws Exception{
//	   when(employeeServiceImpl.addEmployee(any())).thenReturn(employee);
//	   mockMvc.perform(post("/emp/employee").
//	           contentType(MediaType.APPLICATION_JSON).
//	           content(asJsonString(employee))).
//	           andExpect(status().isCreated());
//	   verify(employeeServiceImpl,times(1)).addEmployee(any());
//	}
//
//	@Test
//	public void getAllEmployeeData() throws Exception {
//	    when(employeeServiceImpl.getAllEmployees()).thenReturn(listEmployee);
//	    mockMvc.perform(MockMvcRequestBuilders.get("/emp/employees").
//	                   contentType(MediaType.APPLICATION_JSON).
//	                   content(asJsonString(listEmployee))).
//	                   andDo(MockMvcResultHandlers.print());
//	    verify(employeeServiceImpl).getAllEmployees();
//	    verify(employeeServiceImpl,times(1)).getAllEmployees();
//	}
//	
//	
//	@Test
//	public void getEmployeeById() throws Exception {
//	    when(employeeServiceImpl.getEmployee(employee.getId())).thenReturn(employee);
//	    mockMvc.perform(get("/emp/1").
//	           contentType(MediaType.APPLICATION_JSON).
//	           content(asJsonString(employee))).
//	           andExpect(MockMvcResultMatchers.status().isOk()).
//	           andDo(MockMvcResultHandlers.print());
//	}
//
//	/*
//	@Test
//	public void deleteEmployee(){
//	     when(employeeServiceImpl.deleteEmployee(21L)).thenReturn(employee);
//	      mockMvc.perform(delete("/emp/1")
//	      .contentType(MediaType.APPLICATION_JSON)
//	      .content(asJsonString(employee)))
//	      .andExpect(MockMvcResultMatchers.status().isOk()).
//	      andDo(MockMvcResultHandlers.print());
//	}
//	*/
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
//}
