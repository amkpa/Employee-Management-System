package com.softdyze.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softdyze.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	// Custom query method to find employees by department
	List<Employee> findByDepartment(String department);

	// Custom query method to find employees by name
	List<Employee> findByNameContainingIgnoreCase(String name);

	// Additional custom query methods if needed
}