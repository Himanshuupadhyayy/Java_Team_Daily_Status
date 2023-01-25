package com.college.service;

import com.college.entity.Organization;
import com.college.repo.OrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepo organizationRepo;


    public Organization addOrg(Organization organization){

        return this.organizationRepo.save(organization);


    }
}
