package com.jpa.service;

import com.jpa.entity.Employee;
import com.jpa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // insert data
    public Employee saveAll(Employee employee){

        return this.employeeRepository.save(employee);
    }


    // get all data
    public List<Employee> getAllEmployees(){
        return (List<Employee>)  employeeRepository.findAll();
    }

    // delete by id
    public void deleteEemployeeById(Long empId){
         this.employeeRepository.deleteById(empId);
    }

    //update by id
    public Employee updateEmployeeById(Employee employee)
    {
      return    this.employeeRepository.save(employee);
    }


}
