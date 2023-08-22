package com.softdyze.service;

import java.time.LocalDate;
import java.util.List;

import com.softdyze.entity.Attendance;
import com.softdyze.entity.Employee;

public interface AttendanceService {

    List<Attendance> getAttendanceByEmployee(Employee employee);

    List<Attendance> getAttendanceByDate(LocalDate date);

    void markAttendance(Attendance attendance);

    // Custom method to count the number of times an employee was present
    long countPresentByEmployee(Employee employee);

    // Additional custom methods if needed
}
