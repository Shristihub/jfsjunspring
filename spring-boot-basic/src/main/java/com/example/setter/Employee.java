package com.example.setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	String empname;
	double salary;
	Integer empId;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getEmpname() {
		return empname;
	}
	@Value("${emp.name}")
	public void setEmpname(String empname) {
		this.empname = empname;
	}

	
	public double getSalary() {
		return salary;
	}
	@Value("${emp.salary}")
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Integer getEmpId() {
		return empId;
	}
	@Value("${emp.empId}")
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "Employee [empname=" + empname + ", salary=" + salary + ", empId=" + empId + "]";
	}
}
