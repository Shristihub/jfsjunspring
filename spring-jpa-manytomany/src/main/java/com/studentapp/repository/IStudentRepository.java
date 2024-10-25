package com.studentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentapp.model.CourseType;
import com.studentapp.model.*;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByDepartment(String department);
	List<Student> findByCity(String city);
	List<Student> findByDepartmentAndCity(String department, String city);
	long countByDepartment(String department);
	long countByCity(String city);

	@Query("from Student s inner join courses c where c.courseName=?1")
	List<Student> findByCourseName(String courseName);

	@Query("from Student s inner join courses c where c.category=?1")
	List<Student> findByCategory(String category);
	
	@Query(
			"""
			from Student s inner join courses c 
			where c.courseType=?1
			and c.level=?2
			"""	)
	List<Student> findByTypeAndLevel(String type, Level level);

	@Query(
			"""
			from Student s inner join courses c 
			where c.category=?1
			and c.courseType=?2
			"""	)
	List<Student> findByCategoryAndType(String category, String type);

	@Query(
			"""
			from Student s inner join courses c 
			where c.category like %?1%
			or c.courseType like %?1%
			or c.courseName like %?1%
			"""	)
	List<Student> findByNameOrLevelOrType(String choice);
	
	@Query("from Student s inner join courses c where c.courseType=?1")
	List<Student> findByType(CourseType type);
	
	@Query(
			"""
			from Student s inner join courses c 
			where s.department =?1
			and c.courseType =?2
			"""	)
	List<Student> findByDepartmentType(String department, String type);

}
