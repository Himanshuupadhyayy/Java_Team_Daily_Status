package com.emp.service.impl;

import com.emp.entity.Employee;
import com.emp.repository.EmployeeRepository;
import com.emp.exception.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Jan 24, 2023
*	file Name:  EmployeeServiceImpl.java
*	Time :   	12:49:24 PM
*/
@Service
public class EmployeeServiceImpl {
	@Autowired
	private EmployeeRepository employeeRepository;
//	@Autowired
//	private OrganizationRepository organizationRepository;

	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Employee addEmployee(Employee emp) {
//		Employee employee = this.employeeRepository.findByEmailOrNumber(emp.getEmail(), emp.getNumber());
		if (emp != null) {
			System.out.println("user is already exist in the db");
		} else {
			emp = this.employeeRepository.save(emp);
		}
		return emp;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = this.employeeRepository.findAll();
		return employeeList;
	}

	public Employee getEmployee(int id) {
		Employee employee = this.employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("user with this user id is not exsit"));
		return employee;
	}

	public void deleteEmployee(int id) {
		this.employeeRepository.deleteById(id);
	}

	public Employee updateEmployee(Employee employee) {
		employee.setId(employee.getId());
		return this.employeeRepository.save(employee);
	}

//	public Organization addOrg(Organization organization) {
//		return this.organizationRepository.save(organization);
//	}

}
