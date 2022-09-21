package com.attendancesys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attendancesys.entities.Student;
import com.attendancesys.service.StudentService;

@RestController
@RequestMapping(value = "/api/ats/")
public class StudentController {
	@Autowired
	StudentService studentservice;

	@PostMapping("/addStudents")
	public ResponseEntity<Student> addStudent(@Validated @RequestBody Student student) throws Exception {

		return new ResponseEntity<Student>(studentservice.addStudent(student), HttpStatus.CREATED);
	}

	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents() throws Exception {
		return studentservice.viewAllStudent();
	}
	
	
}
