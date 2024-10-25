package com.studentapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentapp.model.Course;
import com.studentapp.model.CourseType;
import com.studentapp.model.Level;
import com.studentapp.model.Student;
import com.studentapp.service.ICourseService;
import com.studentapp.service.IStudentService;

@SpringBootApplication
public class SpringJpaManytomanyApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaManytomanyApplication.class, args);
	}
	
	@Autowired
	private IStudentService studentService;
	@Autowired
	private ICourseService courseService;

	@Override
	public void run(String... args) throws Exception {
		// create 2 courses
		Course course1 = new Course("Java", CourseType.BACKEND.getCourseType(), "free", 0, Level.BEGINNER);
		Course course2 = new Course("Spring", CourseType.BACKEND.getCourseType(), "free", 0, Level.BEGINNER);
		Course course3 = new Course("HTML", CourseType.FRONTEND.getCourseType(), "paid", 1000, Level.BEGINNER);
		courseService.addCourse(course1);
		courseService.addCourse(course2);
		courseService.addCourse(course3);
		
		// create a student object and attach the courses
		Student student1 = new Student("Raju", "CSE", "Bengaluru");
		Course ncourse1 = courseService.getById(50);
		Course ncourse2 = courseService.getById(51);
		List<Course> courses = Arrays.asList(ncourse1,ncourse2);
		student1.setCourses(courses);
		studentService.addStudent(student1);
		
		
		
	}

}
