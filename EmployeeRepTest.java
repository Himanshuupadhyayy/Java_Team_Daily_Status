package com.OrganizationManagment.OrgManage.Repo;

import com.OrganizationManagment.OrgManage.Entities.Employees;
import com.OrganizationManagment.OrgManage.OrgManageApplication;
import com.OrganizationManagment.OrgManage.Repository.EmployeeRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = OrgManageApplication.class)
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepTest {
        @Autowired
        private EmployeeRepo employeeRepo;


        private Employees getEmployee() {
            Employees employee = new Employees();
            employee.setId(1);
            employee.setEmpName("varsha");
            employee.setEmpRoll("employee");
            return employee;
        }


    @Test
	    @Order(4)
	    public void updateEmployeeTest(){
	        Employees employee=employeeRepo.findById(1).get();
        employee.setEmpRoll("employee");
	        Employees updateEmployee=employeeRepo.save(employee);
	        Assertions.assertThat(employee.getEmpRole()).isEqualTo("employee");
	    }

         @Test
	    public void getListOfEmployeeTest(){
	        List<Employees> employee=employeeRepo.findAll();
	        Assertions.assertThat(employee.size()).isGreaterThan(1);
	    }

        @Test
        public void findByEmployeeId() {
            Employees employee= getEmployee();
            employeeRepo.save(employee);
            Employees result=employeeRepo.findById(employee.getId()).get();
            assertEquals(employee.getId(), result.getId());
        }


        @Test
        public void findAllEmployee() {
            Employees employee = getEmployee();
            employeeRepo.save(employee);
            List<Employees> result = new ArrayList<>();
            employeeRepo.findAll().forEach(e -> result.add(e));
            assertEquals(result.size(), 4);
        }

        @Test
        public void saveEmployeeDetails() {
            Employees employee = getEmployee();
            employeeRepo.save(employee);
            Employees found = employeeRepo.findById(employee.getId()).get();
            assertEquals(employee.getId(), found.getId());
        }

        @Test
        public void deleteEmployeeById() {
            Employees employee = getEmployee();
            employeeRepo.save(employee);
            employeeRepo.deleteById(employee.getId());
            List<Employees> result = new ArrayList<>();
            employeeRepo.findAll().forEach(e -> result.add(e));
            assertEquals(result.size(), 3);
        }
}
