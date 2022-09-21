package com.attendancesys.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "attendance")
@Setter
@Getter
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate date;
	private LocalTime timeIn;
	private LocalTime timeOut;
	private String status;
	@ManyToOne
	@JoinColumn(name="userid")
	Student student;
	
	
	public Attendance() {
		
	}
	public Attendance(int id, LocalDate date, LocalTime timeIn, LocalTime timeOut, String status,
			Student student) {
	
		this.id = id;
		this.date = date;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
		this.status = status;
		this.student=student;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTimeIn() {
		return timeIn;
	}
	public void setTimeIn(LocalTime timeIn) {
		this.timeIn = timeIn;
	}
	public LocalTime getTimeOut() {
		return timeOut;
	}
	public void setTimeOut(LocalTime timeOut) {
		this.timeOut = timeOut;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	

	
	
}