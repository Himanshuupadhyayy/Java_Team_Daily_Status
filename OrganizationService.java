package com.OrganizationManagment.OrgManage.Service;

import com.OrganizationManagment.OrgManage.Entities.Organization;
import com.OrganizationManagment.OrgManage.Repository.OraganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OraganizationRepo repoOr;


    public Organization getOrg(int id) {

        return this.repoOr.findById(id).get();
    }

    public Organization addOrg(Organization organization) {
        return this.repoOr.save(organization);
    }

    public void deleteOrg(int id) {
        Organization organization= repoOr.getById(id);
        repoOr.delete(organization);
    }

    public Organization updateOrg(int id ,Organization organization) {

        return this.repoOr.save(organization);
    }

    public List<Organization> getAll() {

        List<Organization> list = repoOr.findAll();
        return list;
    }


}