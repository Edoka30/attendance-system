package com.attendancesys.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

	@Id
	@Column(nullable = false)
	private String email;

	private String userid;

	@Column(nullable = false)
	private String surname;

	@Column(nullable = false)
	private String first_name;

	private String middle_name;

	private String department;

	private String phone;

	private String address;

	private LocalDate date;

	private String Status;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	@Transient
	private List<Attendance> attendance;

	public Student() {
	}

	public Student(String userid, String surname, String first_name, String middle_name, String department, String role,
			String phone, String email, String contact_phone, String address, LocalDate date, String status) {

		this.userid = userid;
		this.surname = surname;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.department = department;

		this.phone = phone;
		this.email = email;
		this.address = address;
		this.date = date;
		Status = status;
	}

	public Student(String userid, String surname, String first_name, String middle_name, String department, String role,
			String phone, String email, String contact_phone, String address, LocalDate date, String status,
			List<Attendance> attendance) {
		this.userid = userid;
		this.surname = surname;
		this.first_name = first_name;
		this.middle_name = middle_name;
		this.department = department;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.date = date;
		Status = status;
		this.attendance = attendance;
	}

	public String getUser_id() {
		return userid;
	}

	public void setUser_id(String user_id) {
		this.userid = user_id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getMiddle_name() {
		return middle_name;
	}

	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public List<Attendance> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<Attendance> attendance) {
		this.attendance = attendance;
	}

}
