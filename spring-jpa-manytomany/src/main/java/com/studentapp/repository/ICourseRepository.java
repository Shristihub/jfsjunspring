package com.studentapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentapp.model.Course;
@Repository
public interface ICourseRepository extends JpaRepository<Course, Integer>{

}
