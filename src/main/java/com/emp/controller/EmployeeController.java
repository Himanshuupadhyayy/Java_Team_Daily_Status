package com.emp.controller;

import com.emp.entity.Employee;
import com.emp.service.impl.EmployeeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@CrossOrigin("*")
public class EmployeeController {
	@Autowired
	private EmployeeServiceImpl employeeService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return this.employeeService.getAllEmployees();
	}

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee emp) {
		return this.employeeService.addEmployee(emp);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
		Employee employee = this.employeeService.getEmployee(id);
		return ResponseEntity.ok(employee);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		this.employeeService.deleteEmployee(id);
	}

	@PutMapping("/update/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		return this.employeeService.updateEmployee(id, employee);
	}

}