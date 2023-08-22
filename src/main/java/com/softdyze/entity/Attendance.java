package com.softdyze.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Employee employee;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	private boolean present; // Boolean property for attendance status (true or false)

	public Attendance() {
		// Default constructor
	}

	public Attendance(Employee employee, LocalDate date, boolean present) {
		this.employee = employee;
		this.date = date;
		this.present = present;
	}
}
