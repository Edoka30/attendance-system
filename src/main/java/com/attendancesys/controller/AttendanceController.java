package com.attendancesys.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.attendancesys.entities.Attendance;
import com.attendancesys.entities.Student;
import com.attendancesys.service.AttendanceService;

@RestController
@RequestMapping(value = "/api/ats/")
public class AttendanceController {
	@Autowired
	AttendanceService attservice;

	@GetMapping("/getAllAttendance")
	public List<Attendance> getAllAttendance() throws Exception {
		return attservice.getAllAttendance();
	}

	@PostMapping("/signIn")
	public String signIn(@RequestParam String email) throws Exception {

		return attservice.signIn(email);
	}

	@PatchMapping("/signOut")
	public String signOut(@RequestParam String userid) throws Exception {

		return attservice.signOut(userid);
	}

	@GetMapping("/getAttendaceByEmail")
	public List<Attendance> viewAttendanceByEmail(@RequestParam(value = "userid", required = false) Student userid)
			throws Exception {
		System.out.println("controller");
		return attservice.viewAttendanceByEmail(userid);
	}

	@GetMapping("getAttendanceByDate")
	public List<Attendance> getAttByDate(@RequestParam(value = "date", required = false) String date)
			throws Exception {
		
		LocalDate date1=LocalDate.parse(date);

		return attservice.getAttByDate(date1);
	}
}
