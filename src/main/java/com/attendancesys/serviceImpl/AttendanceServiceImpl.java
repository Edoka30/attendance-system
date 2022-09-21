package com.attendancesys.serviceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendancesys.entities.Attendance;
import com.attendancesys.entities.Student;
import com.attendancesys.repos.AttendanceRepository;
import com.attendancesys.repos.StudentRepository;
import com.attendancesys.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
	AttendanceRepository attrepo;
	@Autowired
	StudentRepository studentrepo;

	@Override
	public List<Attendance> getAllAttendance() throws Exception {
		// TODO Auto-generated method stub
		return attrepo.findAll();
	}

	@Override
	public String signIn(String email) throws Exception {
		Student checkuser = studentrepo.findByEmail(email);
		if (checkuser == null) {
			return "User " + email + " Not found";
		}
		Attendance checkSignin = attrepo.findByStudentAndDate(checkuser, LocalDate.now());
		if (checkSignin != null) {
			return "User Already login";
		}
		Attendance att = new Attendance();
		String status = "1";
		LocalDate myDate = LocalDate.now();
		LocalTime Timein = LocalTime.now();
		att.setDate(myDate);
		att.setTimeIn(Timein);
		att.setStatus(status);
		att.setStudent(checkuser);
		Student reg = studentrepo.findByEmail(email);
		att.setStudent(reg);
		attrepo.save(att);
		return "User " + email + " sign in succesfully!";

	}

	@Override
	public String signOut(String email) throws Exception {
		Student checkuser = studentrepo.findByEmail(email);
		if (checkuser == null) {
			return "User " + email + " Not found";
		}
		Attendance checkSignin = attrepo.findByStudentAndDate(checkuser, LocalDate.now());
		if (checkSignin != null) {

			checkSignin.setTimeOut(LocalTime.now());
			attrepo.save(checkSignin);

			return "User " + email + " sign Out in succesfully!";
		}
		return "You have not login today " + LocalDate.now();

	}

	@Override
	public List<Attendance> viewAttendanceByEmail(Student userid) throws Exception {
		// TODO Auto-generated method stub

		return attrepo.findByStudent(userid);
	}

	@Override
	public List<Attendance> getAttByDate(LocalDate date) throws Exception {
		// TODO Auto-generated method stub
		return attrepo.findByDate(date);
	}

}
