package com.softdyze.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softdyze.entity.Attendance;
import com.softdyze.entity.Employee;
import com.softdyze.service.AttendanceService;
import com.softdyze.service.EmployeeService; // Import EmployeeService

@Controller
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private EmployeeService employeeService; // Inject EmployeeService

    @GetMapping("/mark")
    public String markAttendanceForm(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("attendance", new Attendance());
        return "attendance/mark";
    }

    @PostMapping("/mark")
    public String markAttendance(@ModelAttribute Attendance attendance) {
        attendanceService.markAttendance(attendance);
        return "redirect:/attendance/report";
    }

    @GetMapping("/report")
    public String attendanceReport(Model model) {
        LocalDate currentDate = LocalDate.now(); // You can change this to the desired date
        List<Attendance> attendanceReport = attendanceService.getAttendanceByDate(currentDate);
        model.addAttribute("attendanceReport", attendanceReport);
        return "attendance/report";
    }

    // Add more controller methods as needed
}
