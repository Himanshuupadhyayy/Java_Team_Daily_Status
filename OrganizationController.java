package com.OrganizationManagment.OrgManage.Controller;

import com.OrganizationManagment.OrgManage.Entities.Organization;
import com.OrganizationManagment.OrgManage.Service.OrganizationService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orgApi")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/getAll")
    public List<Organization> getAll(){
        return this.organizationService.getAll();
    }

    @GetMapping("/get/{id}")
    public Organization getOrganization(@PathVariable int id){
        return  this.organizationService.getOrg(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrganization(@PathVariable int id){
       organizationService.deleteOrg(id);
    }

    @PutMapping("/update/{id}")
    public Organization updateOrganization(@PathVariable int id, @RequestBody Organization organization){
        return this.organizationService.updateOrg(id,organization);
    }

    @PostMapping("/add")
    public Organization addOrganization(@RequestBody Organization organization){
        return  this.organizationService.addOrg(organization);
    }
}
