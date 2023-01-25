package com.college.entity;

import javax.persistence.*;

@Entity
public class Representative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "Emp_Id")
    private  int id;
    private String empName;

    @ManyToOne
    private Manager manager;


    public Representative(int id, String empName, Manager manager) {
        this.id = id;
        this.empName = empName;
        this.manager = manager;
    }

    public Representative() {
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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
