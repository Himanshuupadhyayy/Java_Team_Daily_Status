package com.emp.repository;

import com.emp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByEmail(String email);

	Employee findByEmailOrNumber(String email, String number);
}