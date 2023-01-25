package com.college.entity;

import javax.persistence.*;
import java.util.List;

    @Entity
    @Table(name= "Organization")
    public class Organization {

        @Id
        private int id;
        private String orgName;
        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,
                mappedBy="organization")
        private List<Department> department;

        public Organization(int id, String orgName, List<Department> department) {
            this.id = id;
            this.orgName = orgName;
            this.department = department;
        }

        public Organization() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        public List<Department> getDepartment() {
            return department;
        }

        public void setDepartment(List<Department> department) {
            this.department = department;
        }
    }