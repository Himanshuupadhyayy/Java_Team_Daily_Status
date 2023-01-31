package com.emp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByEmail(String email);

	Employee findByEmailOrNumber(String email, String number);
	
	
}