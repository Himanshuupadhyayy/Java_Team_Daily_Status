
package com.emp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Jan 27, 2023
*	file Name:  Employee.java
*	Time :   	11:58:43 AM
*/

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String number;
	private String role;
}
