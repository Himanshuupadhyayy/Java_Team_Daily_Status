/**
 * 
 */
package com.emp.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.emp.EmployeeManagementProjectApplication;
import com.emp.entity.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Jan 30, 2023
*	file Name:  EmployeeControllerTestCases.java
*	Time :   	6:27:01 PM
*/

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EmployeeManagementProjectApplication.class)
@AutoConfigureMockMvc
public class EmployeeControllerTestCases {

		@Autowired
	    private MockMvc mvc;
	    @MockBean
	    private EmployeeController employeeController;
	
	
	    private Employee getEmployee() {
	        Employee employee = new Employee();
	        employee.setId(1);
	        employee.setFirstName("mahesh");
	        employee.setLastName("upadhyay");
	        employee.setEmail("mahesh@test.com");
	        return employee;
	     }
	    
	    
	     private static String asJson(final Object obj) {
	        try {
	           return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	           throw new RuntimeException(e);
	        }
	     }
	
	
}
