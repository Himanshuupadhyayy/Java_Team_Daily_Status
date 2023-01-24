package com.dev2prod.springdatajpamappings.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employee_details")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private Long empId;
    private String empName;
    private int empAge;
    private  long mobileNumber;
    private  String email;
    //address_add_id - default fk column name
    @OneToOne(cascade = CascadeType.ALL)
    private  Address address;





}
