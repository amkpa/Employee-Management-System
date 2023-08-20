package com.softdyze.service;

import java.time.LocalDate;
import java.util.List;

import com.softdyze.entity.Attendance;
import com.softdyze.entity.Employee;

public interface AttendanceService {
	List<Attendance> getAttendanceByEmployee(Employee employee);

	 List<Attendance> getAttendanceByDate(LocalDate date);

	void markAttendance(Attendance attendance);
	// Add more methods as needed
}
