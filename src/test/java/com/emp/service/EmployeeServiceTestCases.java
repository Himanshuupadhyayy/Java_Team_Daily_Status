/**
 * 
 */
package com.emp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.emp.EmployeeManagementProjectApplication;
import com.emp.entity.Employee;
import com.emp.service.impl.EmployeeServiceImpl;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Jan 30, 2023
*	file Name:  EmployeeServiceTestCases.java
*	Time :   	4:33:26 PM
*/

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EmployeeManagementProjectApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeServiceTestCases {

	@MockBean
	private EmployeeServiceImpl collegeService;

	 private Employee getEmployee() {
		 Employee employee = new Employee();
		 employee.setId(1);
	     employee.setFirstName("mohit");
	     employee.setLastName("upadhyay");
	     return employee;
	   }
	
	 
	 @Test
	 @Order(1)
	 public void getAllColleges(){
	      Employee employee = getEmployee();
	      List<Employee> employees = new ArrayList<>();
	      employees.add(employee);
	      given(collegeService.getAllEmployees()).willReturn(employees);
	      List<Employee> result = collegeService.getAllEmployees();
	      assertEquals(result.size(), 1);
	   }


	 @Test
	 @Order(2)
	   public void getcollegeDetails(){
		 Employee employee = getEmployee();
	      given(collegeService.getEmployee(1)).willReturn(employee);
	      Employee result = collegeService.getEmployee(1);
	      assertEquals(result.getId(), 1);	
	   }
	   @Test
	   @Order(4)
	   public void deleteCollegeDetails(){
	      doNothing().when(collegeService).deleteEmployee(1);
	      collegeService.deleteEmployee(1);
	      assertTrue(true);
	   }
	   
	   
	   @Test
	   @Order(3)
	   public void updateCollegeDetails()throws Exception {
	      Employee employee = getEmployee();
	      doNothing().when(collegeService).updateEmployee(employee);	
	      collegeService.updateEmployee(employee);
	      assertTrue(true);
	   }
	
}