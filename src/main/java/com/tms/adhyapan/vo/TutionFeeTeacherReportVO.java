package com.tms.adhyapan.vo;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class TutionFeeTeacherReportVO extends TutionFeeReportVO {
	List<ClassFeeTxnVO> classFeeTxnList;
}
