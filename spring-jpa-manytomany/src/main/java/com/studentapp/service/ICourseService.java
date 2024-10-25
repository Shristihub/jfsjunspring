package com.studentapp.service;

import java.util.List;

import com.studentapp.exception.CourseNotFoundException;
import com.studentapp.model.Course;


public interface ICourseService {

	void addCourse(Course Course);
	void updateCourse(Course Course);
	void deleteCourse(int CourseId);
	
	
	List<Course> getAll();
	Course getById(int CourseId)throws CourseNotFoundException;
	
	
	
}
