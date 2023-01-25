package com.college.entity;

import javax.persistence.*;
import java.util.List;
    @Entity
    @Table(name = "Managers")
    public class Manager {

        @Id
        @Column(name = "Managers_Id")
        private int managerId;
        @Column(name = "Managers_Name")
        private String managerName;

        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,
                mappedBy = "manager")
        private List<Representative> list;

        @ManyToOne
        private Department department;

        public int getManagerId() {
            return managerId;
        }

        public void setManagerId(int managerId) {
            this.managerId = managerId;
        }

        public Manager(int managerId, String managerName, List<Representative> list, Department department) {
            this.managerId = managerId;
            this.managerName = managerName;
            this.list = list;
            this.department = department;
        }

        public Manager() {
        }

        public String getManagerName() {
            return managerName;
        }

        public void setManagerName(String managerName) {
            this.managerName = managerName;
        }

        public List<Representative> getList() {
            return list;
        }

        public void setList(List<Representative> list) {
            this.list = list;
        }

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }
    }