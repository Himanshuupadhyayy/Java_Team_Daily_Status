package com.OrganizationManagment.OrgManage.Controller;

import com.OrganizationManagment.OrgManage.Entities.Department;
import com.OrganizationManagment.OrgManage.Entities.Employees;
import com.OrganizationManagment.OrgManage.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService dptservice;


        @PostMapping("/addDpt")
    public Department addDpt(@RequestBody Department department){

            return this.dptservice.addDepartment(department);
    }

    @DeleteMapping("/deleteDpt/{dptId}")
    public void deleteDpt(@PathVariable int dptId){
        dptservice.deleteDpt(dptId);
    }

    @PutMapping("/updatedpt/{dptId}")
    public Department updateDpt(@PathVariable int dptId, @RequestBody Department department){
        return this.dptservice.updateDepartment(dptId, department);
    }
    @GetMapping("/getAll")
    public List<Department> getAll(){
        List<Department> list = dptservice.getAll();
        return list;
    }

}

