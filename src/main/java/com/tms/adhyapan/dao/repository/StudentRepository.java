package com.tms.adhyapan.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.adhyapan.dao.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByFirstNameStartingWithOrderByFirstName(String key);
	List<Student> findByLastNameStartingWithOrderByLastName(String key);
	List<Student> findByStudentCodeContainingOrderByStudentCode(String key);
	List<Student> findBySchoolIdOrderByFirstName(Long key);
	List<Student> findByStandardIdOrderByFirstName(Long key);
}

