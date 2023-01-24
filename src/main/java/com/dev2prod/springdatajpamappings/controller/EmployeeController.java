package com.dev2prod.springdatajpamappings.controller;

import com.dev2prod.springdatajpamappings.entity.Employee;
import com.dev2prod.springdatajpamappings.repository.EmployeeRepository;
import com.dev2prod.springdatajpamappings.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/saveEmployees")
    public ResponseEntity<Employee> saveEmployees(@RequestBody Employee empData) {
       Employee employee1= employeeService.saveAll(empData);
        return ResponseEntity.ok(employee1);
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/deleteEmployees/{empId}")
    public void deleteEmployee(@PathVariable("empId") Long empId){
         employeeService.deleteEemployeeById(empId);
    }

    // update data
    @PutMapping("/updateEmployee/{empId}")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployeeById(employee);
    }
}
