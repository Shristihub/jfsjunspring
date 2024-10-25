package com.employeeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employeeapp.model.Address;
import com.employeeapp.model.Employee;
import com.employeeapp.service.IEmployeeService;

@SpringBootApplication
public class SpringJpaOnetooneApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaOnetooneApplication.class, args);
	}

	@Autowired
	private IEmployeeService employeeService;
	@Override
	public void run(String... args) throws Exception {
		Address address = new Address("Mysore", "KAR");
		Employee employee = new Employee("Priya", "Research", 78000, address);
//		employeeService.addEmployee(employee);
		
//		// updating
//		Employee employee1 = employeeService.getById(4);
//		employee1.setSalary(12000);
//		employeeService.updateEmployee(employee1);
//		
//		// querying
//		System.out.println("Get all");
//		employeeService.getAll().forEach(System.out::println);
//		System.out.println();
		
//		System.out.println("Get By City");
//		employeeService.getByCity("Mysore").forEach(System.out::println);
////	
		System.out.println();
		System.out.println("Get by salary city");
		employeeService.getByHighSalaryCity(7000.0, "Mysore").forEach(System.out::println);
		
//		System.out.println();
//		System.out.println("Get by salary dept");
//		employeeService.getByHighSalaryDepartment(15000.0, "Research").forEach(System.out::println);
//		
//		System.out.println();
//		System.out.println("Count");
//		System.out.println(employeeService.getCountByHighSalaryDept(20000,"Research"));
		
		System.out.println();
		System.out.println("Get by dept city");
		employeeService.getByDeptCity("Research", "Mysore").forEach(System.out::println);
		
	}

}
