package com.softdyze.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softdyze.entity.Attendance;
import com.softdyze.entity.Employee;
import com.softdyze.repo.AttendanceRepository;
import com.softdyze.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public List<Attendance> getAttendanceByEmployee(Employee employee) {
        return attendanceRepository.findByEmployee(employee);
    }

    @Override
    public List<Attendance> getAttendanceByDate(LocalDate date) {
        return attendanceRepository.findByDate(date);
    }

    @Override
    public void markAttendance(Attendance attendance) {
        attendanceRepository.save(attendance);
    }

    // Add more implementations as needed
}
