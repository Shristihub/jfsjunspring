package com.employeeapp.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Employee {
	@Column(length=30)
	private String employeeName;
	@Id
	@GeneratedValue(generator = "emp_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "emp_gen",sequenceName = "emp_seq",initialValue = 1,allocationSize = 1)
	private Integer employeeId;
	@Column(length=30)
	private String department;
	private double salary;
	// save the child references before saving the parent
	// save address object into address table before saving employee
	@OneToOne(cascade = CascadeType.ALL)
	// to change the column name use
	@JoinColumn(name = "address_id")
	private Address address;
	public Employee(String employeeName, String department,double salary, Address address) {
		super();
		this.employeeName = employeeName;
		this.department = department;
		this.salary =salary;
		this.address = address;
	}
	
	
}
