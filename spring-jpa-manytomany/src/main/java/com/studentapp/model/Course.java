package com.studentapp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Setter
@Getter
@NoArgsConstructor
public class Course {
	@Column(length=30)
	private String courseName;
	@Id
	@GeneratedValue(generator = "course_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "course_gen",sequenceName = "course_seq",initialValue = 50,allocationSize = 1)
	private Integer courseId;
	@Column(length=30)
	private String courseType;  //frontend,backend,testing,design,
	
	private double cost;
	private String category; // free or paid
	@Enumerated(EnumType.STRING)
	private Level level; // beginner,intermediate,advanced.all
	@ManyToMany
	@JoinTable(name="student_course",
	 joinColumns=
      @JoinColumn(name="course_id"),
  inverseJoinColumns=
      @JoinColumn(name="student_Id")
  )
	@ToString.Exclude
	private List<Student> students;
	public Course(String courseName, String courseType,String category, double cost, Level level) {
		super();
		this.courseName = courseName;
		this.courseType = courseType;
		this.cost = cost;
		this.level = level;
		this.category=category;
	}
	
	
	

}
