package com.college.controller;

import com.college.entity.Organization;
import com.college.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/org")
public class OrganizationController {


    @Autowired
    private OrganizationService organizationService;

    @PostMapping ("/organization")
    public Organization addOrganization(@RequestBody Organization organization){
       return this.organizationService.addOrg(organization);
    }


}
