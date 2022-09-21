package com.attendancesys.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attendancesys.entities.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

	Student findByUserid(String userid);

	Student findByEmail(String email);

}
