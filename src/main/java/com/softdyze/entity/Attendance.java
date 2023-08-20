package com.softdyze.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
	private LocalDate date;
	private boolean present;

	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attendance(Long id, Employee employee, LocalDate date, boolean present) {
		super();
		this.id = id;
		this.employee = employee;
		this.date = date;
		this.present = present;
	}

}
