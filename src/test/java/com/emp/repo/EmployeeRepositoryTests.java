package com.emp.repo;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.emp.entity.Employee;
import com.emp.helper.Calculator;
import com.emp.repository.EmployeeRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTests {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	private Calculator calculator=new Calculator();

	  

	 	@Test
	    @Order(1)
	    public void saveEmployeeTest(){
	        Employee employee=Employee.builder()
	                .firstName("shubham")
	                .email("shubham@gmail.com")
	                .lastName("pachauri")
	                .build();
	        employeeRepository.save(employee);
	        Assertions.assertThat(employee.getId()).isGreaterThan(0L);
	    }

	    @Test
	    @Order(2)
	    public void getEmployeeTest(){
	        Employee employee=employeeRepository.findById(16L).get();
	        Assertions.assertThat(employee.getId()).isEqualTo(16L);
	    }

	    @Test
	    @Order(3)
	    public void getListOfEmployeeTest(){
	        List<Employee> employee=employeeRepository.findAll();
	        Assertions.assertThat(employee.size()).isGreaterThan(1);
	    }

	    @Test
	    @Order(4)
	    public void updateEmployeeTest(){
	        Employee employee=employeeRepository.findById(16L).get();
	        employee.setEmail("upadyay@gmail.com");
	        Employee updateEmployee=employeeRepository.save(employee);
	        Assertions.assertThat(employee.getEmail()).isEqualTo("upadyay@gmail.com");
	    }

	    @Test
	    @Order(5)
	    public void deleteEmployeeTest(){
	        Employee employee=employeeRepository.findById(15L).get();
	        employeeRepository.delete(employee);

	        Employee employee1=null;
	        employee1=employeeRepository.findByEmail("upadhyay@gmail.com");
	        if (employee1==null){
	            Assertions.assertThat(employee1).isNull();
	        }
	    }


	    @Test
	    public void testSum(){
	        int actualResult=calculator.doSum(1, 2, 3);
	        Assertions.assertThat(actualResult).isGreaterThan(2);
	    }

	    @Test
	    public void testProduct(){
	        int actualResult=calculator.doMultiply(12, 10);
	        Assertions.assertThat(actualResult).isGreaterThan(100);
	    }

	    @Test
	    void testCompare(){
	        boolean actualResult =calculator.compareNumbers(10, 10);
	        Assertions.assertThat(actualResult).isTrue();
	    }

	    @AfterEach
	    void tearDown() {
	        System.out.println("after test case");
	    }

	    @BeforeEach
	    void setUp(){
	        System.out.println("before the test case");
	    }


	
	
	
}