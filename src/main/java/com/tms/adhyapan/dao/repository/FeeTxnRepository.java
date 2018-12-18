package com.tms.adhyapan.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tms.adhyapan.dao.entity.FeeTxn;

public interface FeeTxnRepository extends JpaRepository<FeeTxn, Long> {
	List<FeeTxn> findByStudentIdAndClassIdAndFeeCategoryIdOrderByTxnDateDesc(Long studentId, Long classId, Long categoryId);
}
