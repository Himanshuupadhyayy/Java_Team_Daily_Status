package com.jpa.controller;

import com.jpa.entity.Employee;
import com.jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/saveEmployees")
    public ResponseEntity<Employee> saveEmployees(@Valid @RequestBody Employee empData) {
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
    public Employee updateEmployee(@Valid @RequestBody Employee employee){
        return employeeService.updateEmployeeById(employee);
    }
}
