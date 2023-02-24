package com.OrganizationManagment.OrgManage.Repo;

import com.OrganizationManagment.OrgManage.Entities.Organization;
import com.OrganizationManagment.OrgManage.OrgManageApplication;
import com.OrganizationManagment.OrgManage.Repository.OraganizationRepo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = OrgManageApplication.class)
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrganizationRepoTest {


    @InjectMocks
    private OraganizationRepo oraganizationRepo;


    private Organization getOrg() {
        Organization organization = new Organization();
        organization.setId(1);
        organization.setOrgName("bluethink");
        return organization;
    }


    @Test
    public void getOrganization() {
        Organization organization= getOrg();
        oraganizationRepo.save(organization);
        Organization result=oraganizationRepo.findById(organization.getId()).get();
        assertEquals(organization.getId(), result.getId());
    }


    @Test
    public void findAllOrg() {
        Organization organization = getOrg();
        oraganizationRepo.save(organization);
        List<Organization> result = new ArrayList<>();
        oraganizationRepo.findAll().forEach(e -> result.add(e));
        assertEquals(result.size(), 2);
    }

    @Test
    public void saveOrgDetails() {
        Organization organization = getOrg();
        oraganizationRepo.save(organization);
        Organization found = oraganizationRepo.findById(organization.getId()).get();
        assertEquals(organization.getId(), found.getId());
    }

    @Test
    public void deleteOrgById() {
        Organization employee = getOrg();
        oraganizationRepo.save(employee);
        oraganizationRepo.deleteById(employee.getId());
        List<Organization> result = new ArrayList<>();
        oraganizationRepo.findAll().forEach(e -> result.add(e));
        assertEquals(result.size(), 1);
    }


}
