package com.OrganizationManagment.OrgManage.Service;

import com.OrganizationManagment.OrgManage.Entities.Department;
import com.OrganizationManagment.OrgManage.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    Department dept=null;

   
    public Department addDepartment(Department department) {
       dept= this.departmentRepo.save(department);
        return dept;
    }

    public List<Department> getAll( ){
        List<Department> list = departmentRepo.findAll();
        return list;
    }

    public void deleteDpt(int dptId) {
        Department department = departmentRepo.getById(dptId);
        departmentRepo.delete(department);
    }

    public Department updateDepartment(int dptId, Department department) {
        department.setDeptId(dptId);
        return this.departmentRepo.save(department);
    }


}
