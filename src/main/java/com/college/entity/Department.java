package com.college.entity;

import javax.persistence.*;

@Entity
@Table(name = "Departments")
public class Department {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="Department_Id")
        private int deptId;

        private String deptName;

        @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        private Manager manager;

        @ManyToOne
        private Organization organization;

        public Department(int deptId, String deptName, Manager manager, Organization organization) {
                this.deptId = deptId;
                this.deptName = deptName;
                this.manager = manager;
                this.organization = organization;
        }

        public Department() {
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

        public Manager getManager() {
                return manager;
        }

        public void setManager(Manager manager) {
                this.manager = manager;
        }

        public Organization getOrganization() {
                return organization;
        }

        public void setOrganization(Organization organization) {
                this.organization = organization;
        }
}
