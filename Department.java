package com.OrganizationManagment.OrgManage.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Departments")
public class Department {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="Department_Id")
        private int deptId;

        private String deptName;

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

        private List<Employees> employees;

        @ManyToOne
        private Organization organization;


        public Department(int deptId, String deptName, List<Employees> employees, Organization organization) {
                this.deptId = deptId;
                this.deptName = deptName;
                this.employees = employees;
                this.organization = organization;
        }

        public int getDeptId() {
                return deptId;
        }

        public void setDeptId(int deptId) {
                this.deptId = deptId;
        }

        public String getDeptName() {
                return deptName;
        }

        public void setDeptName(String deptName) {
                this.deptName = deptName;
        }

        public List<Employees> getEmployees() {
                return employees;
        }

        public void setEmployees(List<Employees> employees) {
                this.employees = employees;
        }

        public Organization getOrganization() {
                return organization;
        }

        public void setOrganization(Organization organization) {
                this.organization = organization;
        }

        public Department() {
        }

}
