package com.emp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.emp.entity.Employee;
import com.emp.repository.EmployeeRepository;
import com.emp.service.impl.EmployeeServiceImpl;

/*
*	author:  	Himanshu Upadhyay
*	Date:  		Jan 24, 2023
*	file Name:  EmployeeServiceTest.java
*	Time :   	12:43:14 PM
*/

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeServiceTest {

	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;
	private Optional<Employee> employee1;
	private Employee employee;


	@BeforeEach
    public void setup(){
        employee = Employee.builder()
                .firstName("Ramesh")
                .lastName("Fadatare")
                .email("ramesh@gmail.com")
                .build();
    }
	
	@Test
	@Order(1)
	public void saveEmployee() {
		employee=Employee.builder()
				.email("ramesh@gmail.com")
				.firstName("sumant")
				.lastName("kumar").build();
		when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
		employee=employeeServiceImpl.addEmployee(employee);
		verify(employeeRepository, times(1)).save(any(Employee.class));
		}

	@Test
	@Order(2)
	void getAllEmployees() {
		employeeServiceImpl.getAllEmployees();
		verify(employeeRepository).findAll();
	}
	

	@Test
	@Order(3)
	public void getEmployeeById() {
		when(employeeRepository.findById(20L)).thenReturn(employee1);
		Employee saved=employeeServiceImpl.getEmployee(20L);
		assertThat(saved).isNotNull();
//		assertThat(employeeServiceImpl.getEmployee(employee.getId())).isEqualTo(employee);
	}

	@Test
	@Order(4)
	public void deleteEmployee() {
		doNothing().when(employeeRepository).deleteById(18L);
		employeeServiceImpl.deleteEmployee(18L);
		verify(employeeRepository, times(1)).deleteById(18L);
	}

	
	@Test
	@Order(5)
	public void updateEmployee() {
		given(employeeRepository.save(employee)).willReturn(employee);
		employee.setEmail("ram@gmail.com");
		Employee updateEmp=employeeServiceImpl.updateEmployee(18L, employee);
		assertThat(updateEmp.getEmail()).isEqualTo("ram@gmail.com");
	}
	
	
	
	
	

}