package com.emp.controller;

import com.emp.entity.Organization;
import com.emp.service.impl.EmployeeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/org")
public class OrganizatioController {

    @Autowired
    private EmployeeServiceImpl employeeService;
    @PostMapping("/add")
    public Organization addOrganization(@RequestBody Organization organization){
    return this.employeeService.addOrg(organization);
    }
}