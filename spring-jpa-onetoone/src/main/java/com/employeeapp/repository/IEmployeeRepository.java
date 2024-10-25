package com.employeeapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employeeapp.model.Employee;


@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findByDepartment(String department);
	List<Employee> readBySalaryGreaterThan(double salary);
	List<Employee> findByAddressCity(String city);
	
	//custom queries
	
//	method length is big so use custom query
//	List<Employee> getBySalaryGreaterThanAndDepartment(double salary, String department);
	@Query("from Employee e where e.salary>?1 and e.department=?2")
	List<Employee> findBySalDept(double salary,String dept);
	
	
	//long countBySalaryGreaterThanAndDepartment(double salary, String department);
	@Query("select count(*)from Employee e where e.salary>?1 and e.department=?2")
	long findCountBySalDept(double salary, String department);
	
	 
	 
	 @Query("from Employee e inner join e.address a where a.city=?1")
	 List<Employee> findByCity(String city);
	
//	 List<Employee> findBySalaryGreaterThanAndAddressCity(double salary, String city);
	 
	 //Named query
//	 address is the property in Employee class
//	 @Query("from Employee e inner join e.address a where e.salary>:sal and a.city=:city")
//	 List<Employee> findByGreaterSalCity(@Param("salary")double salary,@Param("city") String city);
	
	 // positional parameters
	 @Query("from Employee e inner join e.address a where e.salary>?1 and a.city=?2")
	 List<Employee> findByGreaterSalCity(double salary,String city);

     @Query("from Employee e inner join e.address a where e.department=?1 and a.city=?2")
	 List<Employee> findByDeptCity(String department, String city);
	 
}
