package com.tms.adhyapan.dao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tms.adhyapan.dao.entity.FeeTxn;
import com.tms.adhyapan.vo.SummaryReportVO;

public interface FeeTxnRepository extends JpaRepository<FeeTxn, Long> {
	List<FeeTxn> findByStudentIdAndClassIdAndFeeCategoryIdOrderByTxnDateDesc(Long studentId, Long classId, Long categoryId);
	
	@Query(value = "select f from FeeTxn f where f.feeCategoryId = ?1 and DATE(f.txnDate) between ?2 and ?3")
	List<FeeTxn> getFeeTxnByCategoryIdAndTxnDateBetween(Long categoryId, Date startDate, Date endDate);
	
	@Query(value = "select new com.tms.adhyapan.vo.SummaryReportVO(count(1), sum(feeAmount)) from FeeTxn f where f.feeCategoryId = ?1 and DATE(f.txnDate) between ?2 and ?3")
	SummaryReportVO getRegFeeSummaryReport(Long categoryId, Date startDate, Date endDate);
	
	@Query(value = "select new com.tms.adhyapan.vo.SummaryReportVO(count(distinct f.studentId), sum(feeAmount)) from FeeTxn f"
			+ " where f.feeCategoryId = ?1"
			+ " and f.classId = ?2"
			+ " and f.monthCode = ?3")
	SummaryReportVO getTutionFeeClassSummaryReport(Long categoryId, Long classId, String monthCode);
	
	@Query(value = "select f from FeeTxn f where f.feeCategoryId = ?1 and f.classId = ?2 and f.monthCode = ?3")
	List<FeeTxn> getFeeTxnClassByCategoryIdAndMonthCode(Long categoryId, Long classId, String monthCode);
}
