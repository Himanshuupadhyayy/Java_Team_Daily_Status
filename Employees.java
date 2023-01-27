package com.OrganizationManagment.OrgManage.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.nio.MappedByteBuffer;

@Entity
public class Employees {

    @Id
    @Column(name = "EmpId")
    private int id;

    private String empName;

    private String empRole;


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
                ", empRole='" + empRole + '\'' +
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

    public String getEmpRole() {
        return empRole;
    }

    public void setEmpRoll(String empRoll) {
        this.empRole = empRole;
    }

    public Employees(int id, String empName, String empRole) {
        this.id = id;
        this.empName = empName;
        this.empRole = empRole;
    }

    public Employees(){

    }
}
