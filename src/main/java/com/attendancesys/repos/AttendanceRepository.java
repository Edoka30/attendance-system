package com.attendancesys.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.attendancesys.entities.Attendance;
import com.attendancesys.entities.Student;
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
	
//List <Attendance> findByUserid(String userid);
	
	List<Attendance> findByStudent(Student userid);

	//Attendance findByStudentAndDate(String userid, LocalDate now);

	Attendance findByStudentAndDate(Student checkuser, LocalDate now);

	List<Attendance> findByDate(LocalDate date);

}
