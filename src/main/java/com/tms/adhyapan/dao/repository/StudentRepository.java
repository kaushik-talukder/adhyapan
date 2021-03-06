package com.tms.adhyapan.dao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tms.adhyapan.dao.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByFirstNameStartingWithOrderByFirstName(String key);
	List<Student> findByLastNameStartingWithOrderByLastName(String key);
	List<Student> findByStudentCodeContainingOrderByStudentCode(String key);
	List<Student> findBySchoolIdOrderByFirstName(Long key);
	List<Student> findByStandardIdOrderByFirstName(Long key);
	
	@Query(value = "select s from Student s, StudentClass sc"
			+ " where s.id = sc.studentId"
			+ " and sc.classId = ?1"
			+ " and s.endDate > DATE(sysdate())"
			+ " and sc.endDate > DATE(sysdate())")
	List<Student> getAssignedStudentsByClassId(Long classId);
	
	@Query(value = "select s from Student s"
			+ " where s.standardId = ?1"
			+ " and s.endDate > DATE(sysdate())"
			+ " and s.id not in (select sc.studentId from StudentClass sc where sc.classId = ?2 and sc.endDate > DATE(sysdate()))")
	List<Student> getAvailableStudentsToAssignByClassId(Long standardId, Long classId);
	
	List<Student> findByFirstNameContainingIgnoreCaseAndEndDateGreaterThanEqual(String firstName, Date endDate);
	
}

