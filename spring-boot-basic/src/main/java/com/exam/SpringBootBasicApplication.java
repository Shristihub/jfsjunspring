package com.exam;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.setter.Employee;

@SpringBootApplication(scanBasePackages = {"com.exam","com.example"})
public class SpringBootBasicApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicApplication.class, args);
	}

	private Employee employee;
	
	@Autowired
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
    @Autowired
    ApplicationContext context;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(employee);
		
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

	}

}
