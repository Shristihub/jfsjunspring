package com.employeeapp.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapp.exception.EmployeeNotFoundException;
import com.employeeapp.model.Employee;
import com.employeeapp.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository employeRepository;

	@Override
	public void addEmployee(Employee employee) {
		employeRepository.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeRepository.deleteById(employeeId);
	}

	@Override
	public Employee getById(int employeeId) {
		return employeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("invalid id"));
	}

	@Override
	public List<Employee> getAll() {
		return employeRepository.findAll();
	}

	@Override
	public List<Employee> getByDepartment(String department) {
		List<Employee> employees = employeRepository.findByDepartment(department);
		if (employees.isEmpty())
			throw new EmployeeNotFoundException("dept not found");
		return employees.stream().sorted(Comparator.comparing(Employee::getEmployeeName)).toList();
	}

	@Override
	public List<Employee> getHigherSalary(double salary) {
		List<Employee> employees = employeRepository.readBySalaryGreaterThan(salary);
		if (employees.isEmpty())
			throw new EmployeeNotFoundException("employees with higher salary not found");
		return employees.stream().sorted(Comparator.comparing(Employee::getEmployeeName)).toList();
	}

	@Override
	public List<Employee> getByHighSalaryDepartment(double salary, String department) {
		List<Employee> employees = employeRepository.findBySalDept(salary, department);
		if (employees.isEmpty())
			throw new EmployeeNotFoundException("employees with higher salary not found");
		return employees.stream().sorted(Comparator.comparing(Employee::getEmployeeName)).toList();
	}

	@Override
	public long getCountByHighSalaryDept(double salary, String department) {
		long count = employeRepository.findCountBySalDept(salary, department);
		return count;
	}

	@Override
	public List<Employee> getByCity(String city) {
		List<Employee> employees = employeRepository.findByCity(city);
		if (employees.isEmpty())
			throw new EmployeeNotFoundException("address not found");
		return employees.stream().sorted(Comparator.comparing(Employee::getEmployeeName)).toList();
	}

	@Override
	public List<Employee> getByHighSalaryCity(double salary, String city) {
		List<Employee> employees = employeRepository.findByGreaterSalCity(salary, city);
		if (employees.isEmpty())
			throw new EmployeeNotFoundException("empl with sal and city not found");
		return employees.stream()
				.sorted(Comparator.comparing(Employee::getEmployeeName))
				.toList();
	}

	@Override
	public List<Employee> getByDeptCity(String department, String city) {
		List<Employee> employees = employeRepository.findByDeptCity(department, city);
		if (employees.isEmpty())
			throw new EmployeeNotFoundException("city not found");
		return employees.stream()
				.sorted(Comparator.comparing(Employee::getEmployeeName))
				.toList();
	}

}
