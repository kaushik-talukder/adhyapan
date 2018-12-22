package com.tms.adhyapan.dao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tms.adhyapan.dao.entity.StudentClass;
import com.tms.adhyapan.vo.DateRangeVO;

public interface StudentClassRepository extends JpaRepository<StudentClass, Long> {
	
	@Modifying
	@Query(value = "update StudentClass sc set sc.endDate = ?1 where sc.classId = ?2 and sc.studentId in (?3)")
	Integer removeStudentsFromClass(Date endDate, Long classId, List<Long> studentList);
	
	@Query(value = "select new com.tms.adhyapan.vo.DateRangeVO(min(sc.startDate), max(sc.endDate)) from StudentClass sc"
			+ " where sc.studentId = ?1"
			+ " and sc.endDate >= DATE(sysdate())")
	DateRangeVO getStartEndDateByStudentId(Long studentId);
	
	@Query(value = "select new com.tms.adhyapan.vo.DateRangeVO(min(sc.startDate), max(sc.endDate)) from StudentClass sc"
			+ " where sc.studentId = ?1"
			+ " and sc.classId = ?2"
			+ " and sc.endDate >= DATE(sysdate())")
	DateRangeVO getStartEndDateByStudentIdAndClassId(Long studentId, Long classId);
	
	@Query(value = "select count(1) from StudentClass sc where sc.classId = ?1 and sc.endDate >= DATE(sysdate())")
	Long getActiveStudentCountByClassId(Long classId);
}
