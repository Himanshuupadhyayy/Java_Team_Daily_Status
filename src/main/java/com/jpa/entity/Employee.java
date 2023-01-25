package com.jpa.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employee_details")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long empId;

    //@NotBlank
    @Size(min = 2, message = " employee Name should have atleast 2 characters")
    private String empName;


    @NotNull
    private int empAge;

   // @NotNull
    @Min(10)
    private  long mobileNumber=(long)(Math.random()*Math.pow(10,10));

    @Email
    private  String email;


    @Embedded
    private  Address address;





}
