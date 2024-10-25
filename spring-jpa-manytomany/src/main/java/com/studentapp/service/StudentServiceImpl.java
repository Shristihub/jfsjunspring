package com.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.CourseType;
import com.studentapp.model.Student;
import com.studentapp.repository.IStudentRepository;

@Service
public class StudentServiceImpl implements IStudentService{
	
	private IStudentRepository studentRepository;
	
	@Autowired
	public void setStudentRepository(IStudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void updateStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);		
	}

	@Override
	public List<Student> getAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student getById(int StudentId) throws StudentNotFoundException {
		return studentRepository.findById(StudentId)
				.orElseThrow(()-> new StudentNotFoundException("invalid id"));
	}

	@Override
	public List<Student> getByDepartment(String department) throws StudentNotFoundException {
		return studentRepository.findByDepartment(department);
	}

	@Override
	public List<Student> getByCity(String city) throws StudentNotFoundException {
		return studentRepository.findByCity(city);
	}

	@Override
	public List<Student> getByDepartmentandCity(String department, String city) throws StudentNotFoundException {
		return studentRepository.findByDepartmentAndCity(department, city);
	}

	@Override
	public long getCountByDepartment(String department) {
		return studentRepository.countByDepartment(department);
	}

	@Override
	public long getCountByCity(String city) {
		return studentRepository.countByCity(city);
	}

	@Override
	public List<Student> getByCourseName(String courseName) {
		return studentRepository.findByCourseName(courseName);
	}

	@Override
	public List<Student> getByTypeAndLevel(String type, String level) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getByCategoryAndType(String category, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getByNameOrLevelOrType(String choice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getByType(CourseType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getByDepartmentType(String department, CourseType type) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
