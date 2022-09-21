package com.attendancesys.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.attendancesys.entities.Student;
import com.attendancesys.repos.StudentRepository;
import com.attendancesys.service.StudentService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentrepo;

	@Override
	public Student updateRecord(Student staffinfo, String staffid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student addStudent(Student student) {
		
		// String userid = NOBIS
		UUID uuid = UUID.randomUUID();
		String userid = uuid.toString();
		student.setDate(LocalDate.now());
		student.setStatus("1");
		student.setUser_id(userid);
		return studentrepo.save(student);
	}

	@Override
	public List<Student> viewAllStudent() {
		// TODO Auto-generated method stub
		return studentrepo.findAll();
	}

	@Override
	public Student ViewByUserid(String userid) {
		// TODO Auto-generated method stub
		return studentrepo.findByUserid(userid);
	}

	@Override
	public void deleteStudentById(String userid) {
		// TODO Auto-generated method stub

	}

}
