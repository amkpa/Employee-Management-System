package com.softdyze.service;

import java.util.List;

import com.softdyze.entity.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();

	Employee getEmployeeById(Long id);

	void saveEmployee(Employee employee);

	void deleteEmployee(Long id);
	// Add more methods as needed
}