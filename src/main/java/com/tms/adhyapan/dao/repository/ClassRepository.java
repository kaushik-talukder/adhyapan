package com.tms.adhyapan.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tms.adhyapan.dao.entity.Clazz;

public interface ClassRepository extends JpaRepository<Clazz, Long> {
	List<Clazz> findByStandardId(Long standardId);
	List<Clazz> findBySubjectId(Long subjectId);
	List<Clazz> findByTeacherId(Long teacherid);
	List<Clazz> findBySubjectIdAndTeacherId(Long subjectId, Long teacherid);
	List<Clazz> findByStandardIdAndTeacherId(Long standardId, Long teacherid);
	List<Clazz> findByStandardIdAndSubjectId(Long standardId, Long subjectid);
	List<Clazz> findByStandardIdAndSubjectIdAndTeacherId(Long standardId, Long subjectId, Long teacherid);
	@Query(value = "select c.fee from Clazz c where c.id = ?1")
	Long getClassFee(Long classId);
}
