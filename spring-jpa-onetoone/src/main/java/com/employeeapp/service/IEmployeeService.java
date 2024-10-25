package com.employeeapp.service;

import java.util.List;

import com.employeeapp.exception.EmployeeNotFoundException;
import com.employeeapp.model.Employee;

public interface IEmployeeService {

	void addEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(int employeeId);
	Employee getById(int employeeId) throws EmployeeNotFoundException;
	List<Employee> getAll();
	
	// derived
	List<Employee> getByDepartment(String department) throws EmployeeNotFoundException;
	List<Employee> getHigherSalary(double salary)throws EmployeeNotFoundException;
	//custom
	List<Employee> getByHighSalaryDepartment(double salary, String department)throws EmployeeNotFoundException;
	long getCountByHighSalaryDept(double salary, String department);
	//custom
	List<Employee> getByCity(String city)throws EmployeeNotFoundException;
	List<Employee> getByHighSalaryCity(double salary,String city)throws EmployeeNotFoundException;
	 List<Employee> getByDeptCity(String department, String city);
	
}
