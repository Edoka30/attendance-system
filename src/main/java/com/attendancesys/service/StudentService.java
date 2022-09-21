package com.attendancesys.service;

import java.util.List;

import com.attendancesys.entities.Student;



public interface StudentService {

	public Student addStudent(Student student);
	public List <Student> viewAllStudent();
	public Student ViewByUserid(String userid);
	public void deleteStudentById(String userid);
	
	public Student updateRecord(Student staffinfo, String staffid);
}