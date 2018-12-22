package com.tms.adhyapan.vo;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TutionFeeStudentReportVO extends TutionFeeReportVO {
	List<ClassFeeTxnVO> classFeeTxnList;
}
