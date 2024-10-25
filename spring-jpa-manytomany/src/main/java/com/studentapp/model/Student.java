package com.studentapp.model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Student {
	@Column(length=30)
	private String studentName;
	@Id
	@GeneratedValue(generator = "student_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "student_gen",sequenceName = "student_seq",initialValue = 1,allocationSize = 1)
	private Integer studentId;
	@Column(length=30)
	private String department;
	@Column(length=30)
	private String city;
	
	@ManyToMany
	@JoinTable(name="student_course",
	joinColumns = @JoinColumn(name="student_id"),
	inverseJoinColumns = @JoinColumn(name="course_id")
	)
	private List<Course> courses;
	public Student(String studentName, String department, String city) {
		super();
		this.studentName = studentName;
		this.department = department;
		this.city = city;
	}
	
	
	
}
