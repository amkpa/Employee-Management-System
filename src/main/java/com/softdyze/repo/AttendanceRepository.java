package com.softdyze.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softdyze.entity.Attendance;
import com.softdyze.entity.Employee;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    // Custom query method to find attendance records for a specific employee
    List<Attendance> findByEmployee(Employee employee);

    // Custom query method to find attendance records for a specific date
    List<Attendance> findByDate(LocalDate date);

    // Custom query method to find attendance records for a specific employee and date
    List<Attendance> findByEmployeeAndDate(Employee employee, LocalDate date);

    // Custom query method to count the number of times an employee was present
    long countByEmployeeAndPresent(Employee employee, boolean present);

    // Additional custom query methods if needed
}
