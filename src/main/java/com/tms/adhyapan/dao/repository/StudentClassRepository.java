package com.tms.adhyapan.dao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tms.adhyapan.dao.entity.StudentClass;

public interface StudentClassRepository extends JpaRepository<StudentClass, Long> {
	
	@Modifying
	@Query(value = "update StudentClass sc set sc.endDate = ?1, sc.isActive = 'N' where sc.classId = ?2 and sc.studentId in (?3)")
	Integer removeStudentsFromClass(Date endDate, Long classId, List<Long> studentList);
}
