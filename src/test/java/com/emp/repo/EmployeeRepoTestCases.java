/**
 * 
 */
package com.emp.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.emp.EmployeeManagementProjectApplication;
import com.emp.entity.Employee;
import com.emp.repository.EmployeeRepository;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Jan 30, 2023
*	file Name:  EmployeeRepoTestCases.java
*	Time :   	4:33:12 PM
*/

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = EmployeeManagementProjectApplication.class)
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepoTestCases {

	   @Autowired
	   private EmployeeRepository employeeRepository;
	   
	   
	   private Employee getEmployee() {
		      Employee employee = new Employee();
		      employee.setId(1);
		      employee.setFirstName("sumit");
		      employee.setLastName("tiwari");
		      employee.setNumber("7078844302");
		      return employee;
		   }

	
	@Test
	@Order(2)
	public void findByEmployeeId() {
		Employee employee= getEmployee();
		employeeRepository.save(employee);
		System.out.println("working 1");
		Employee result=employeeRepository.findById(employee.getId()).get();
		assertEquals(employee.getId(), result.getId());
	}

	
	 @Test
	 @Order(3)
	 public void findAllEmployee() {
	      Employee employee = getEmployee();
	      employeeRepository.save(employee);
			System.out.println("working 2");
	      List<Employee> result = new ArrayList<>();
	      employeeRepository.findAll().forEach(e -> result.add(e));
	      assertEquals(result.size(), 1);	     
	 }
	
	 @Test
	 @Order(1)
	 public void saveEmployeeDetails() {
	      Employee employee = getEmployee();
	      employeeRepository.save(employee);
			System.out.println("working 3");
	      Employee found = employeeRepository.findById(employee.getId()).get();
	      assertEquals(employee.getId(), found.getId());	     
	 }
	 
	 @Test
	 @Order(4)
	 public void deleteEmployeeById() {
	      Employee employee = getEmployee();
	      employeeRepository.save(employee);
			System.out.println("working 4");
	      employeeRepository.deleteById(employee.getId());
	      List<Employee> result = new ArrayList<>();
	      employeeRepository.findAll().forEach(e -> result.add(e));
	      assertEquals(result.size(), 0);
	 }
	 
	   
}