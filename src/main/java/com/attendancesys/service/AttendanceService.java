package com.attendancesys.service;

import java.time.LocalDate;
import java.util.List;

import com.attendancesys.entities.Attendance;
import com.attendancesys.entities.Student;

public interface AttendanceService {
	
	public List<Attendance> getAllAttendance() throws Exception;
	
	public String signIn(String email ) throws Exception;
	
	public String signOut(String email ) throws Exception;
	public List<Attendance> viewAttendanceByEmail(Student userid) throws Exception;
	public List<Attendance> getAttByDate( LocalDate date ) throws Exception ;
	

}
