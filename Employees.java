package com.OrganizationManagment.OrgManage.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EmpId")
    private int id;

    private String empName;

    private String empRoll;


    @ManyToOne
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", empRoll='" + empRoll + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpRoll() {
        return empRoll;
    }

    public void setEmpRoll(String empRoll) {
        this.empRoll = empRoll;
    }

    public Employees(int id, String empName, String empRoll) {
        this.id = id;
        this.empName = empName;
        this.empRoll = empRoll;
    }

    public Employees(){

    }
}
