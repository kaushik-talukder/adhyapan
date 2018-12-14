package com.tms.adhyapan.dao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.adhyapan.dao.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	List<Teacher> findBySubjectIdAndEndDateGreaterThan(Long subjectId, Date currDate);
}
