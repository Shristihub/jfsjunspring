package com.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.exception.CourseNotFoundException;
import com.studentapp.model.Course;
import com.studentapp.repository.ICourseRepository;
@Service
public class CourseServiceImpl implements ICourseService{

	private ICourseRepository courseRepository;
	
	@Autowired
	public void setCourseRepository(ICourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	@Override
	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	@Override
	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	@Override
	public void deleteCourse(int courseId) {
		courseRepository.deleteById(courseId);
	}

	@Override
	public List<Course> getAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course getById(int courseId) throws CourseNotFoundException {
		return courseRepository.findById(courseId).get();
	}

}
