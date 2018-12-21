package com.tms.adhyapan.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tms.adhyapan.dao.entity.Clazz;
import com.tms.adhyapan.vo.DateRangeVO;

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
	
	@Query(value = "select c from Clazz c, StudentClass sc where c.id = sc.classId and sc.studentId = ?1 and sc.endDate >= DATE(sysdate())")
	List<Clazz> getAssignedClassesByStudentId(Long studentId);
	
	@Query(value = "select new com.tms.adhyapan.vo.DateRangeVO(c.startDate, c.endDate) from Clazz c where c.id = ?1")
	DateRangeVO getStartEndDateByClassId(Long classId);
	
	@Query(value = "select new com.tms.adhyapan.vo.DateRangeVO(min(c.startDate), max(c.endDate)) from Clazz c where c.teacherId = ?1 and c.endDate >= DATE(sysdate())")
	DateRangeVO getStartEndDateByTeacherId(Long teacherId);
	
	@Query(value = "select new com.tms.adhyapan.vo.DateRangeVO(min(c.startDate), max(c.endDate)) from Clazz c where c.standardId = ?1 and c.endDate >= DATE(sysdate())")
	DateRangeVO getStartEndDateByStandardId(Long standardId);
}
