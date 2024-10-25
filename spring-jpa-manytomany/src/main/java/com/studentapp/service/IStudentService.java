package com.studentapp.service;

import java.util.List;

import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.CourseType;
import com.studentapp.model.Student;


public interface IStudentService {

	void addStudent(Student student);
	void updateStudent(Student student);
	void deleteStudent(int studentId);
	
	
	List<Student> getAll();
	Student getById(int StudentId)throws StudentNotFoundException;
	List<Student> getByDepartment(String department)throws StudentNotFoundException;
	List<Student> getByCity(String city)throws StudentNotFoundException;
	List<Student> getByDepartmentandCity(String department,String city)throws StudentNotFoundException;
	long getCountByDepartment(String department);
	long getCountByCity(String city);
	
	List<Student> getByCourseName(String courseName);
	// students who have taken  frontend type in beginner level
	List<Student> getByTypeAndLevel(String type,String level);
	//students who have taken free courses 
	List<Student> getByCategory(String category);
	//students who have taken free frontend courses 
	List<Student> getByCategoryAndType(String category, String type);
	List<Student> getByNameOrLevelOrType(String choice);
	List<Student> getByType(CourseType type);
	List<Student> getByDepartmentType(String department, CourseType type);
	
	
	
}
