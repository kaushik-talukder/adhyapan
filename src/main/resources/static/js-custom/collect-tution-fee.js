$(document).ready(function() {
	populateSubjectDropdown();
	$('body').on('click', '.subject-option', function() {
		var subjectId = $("#select-subject-dropdown").val();
		populateTeacherDropdown(subjectId);
	});
	
	$('body').on('click', '.teacher-option', function() {
		var subjectId = $("#select-subject-dropdown").val();
		var teacherId = $("#select-teacher-dropdown").val();
		populateClassDropdown(null,subjectId,teacherId);
	});	
	
	$('body').on('click', '.class-option', function() {
		var classId = $("#select-class-dropdown").val();
		populateStudentDropdown(null,classId);
	});
	
	$('body').on('click', '.student-option', function() {
		var classId = $("#select-class-dropdown").val();
		populateClassMonthDropdown(classId);
		populateClassFee(classId);
	});
	$('body').on('click', '.class-month-option', function() {
		var classId = $("#select-class-dropdown").val();
		populateClassFee(classId);
	});
	$('body').on('click', '#btn-save-tution-fee', function() {
		$("#tution-fee-confirm-message").dialog({
			modal : true,
			buttons : {
				Save : function() {
					$(this).dialog("close");
					saveTutionFee();
				},
				Cancel : function(){
					$(this).dialog("close");
				}
			}
		});
	});
});

function populateClassFee(classId){
	$.ajax({
		method : "POST",
		url : "populateClassFee",
		data : {
			classId : classId
		},
		dataType : "json"
	}).done(function(response) {
		$("#total-fee-amount").val(response);
	});
}

function saveTutionFee(){
	var classId = $("#select-class-dropdown").val();
	var studentId = $("#select-student-dropdown").val();
	var monthCode = $("#select-class-month-dropdown").val();
	var feeCategoryId= $("#fee-category-id").val();
	var remarks = $("#remarks").val();
	var feeAmount = 0;
	if(monthCode.length > 0){
		feeAmount = $("#total-fee-amount").val() / monthCode.length;
	} else {
		feeAmount = $("#total-fee-amount").val();
	}
	
	var studentTutionFee = [];
	$(monthCode).each(function(index, value){
		studentTutionFee.push({
			classId: classId,
			studentId: studentId,
			monthCode: value,
			feeAmount: feeAmount,
			feeCategoryId : feeCategoryId,
			remarks:remarks
		});
	});
	
	$.ajax({
		method : "POST",
		url : "saveTutionFee",
		data : JSON.stringify(studentTutionFee),
		dataType : "json",
		contentType: "application/json"
	}).done(function(response) {
		resetForm();
		$("#tution-fee-dialog-message").dialog({
			modal : true,
			buttons : {
				Ok : function() {
					$(this).dialog("close");
				}
			}
		});
	});
	
}

function resetForm(){
	$("#select-subject-dropdown").val('').selectpicker('refresh');
	$("#select-teacher-dropdown").val('').selectpicker('refresh');
	$("#select-class-dropdown").val('').selectpicker('refresh');
	$("#select-student-dropdown").val('').selectpicker('refresh');
	$("#select-class-month-dropdown").val('').selectpicker('refresh');
	$("#total-fee-amount").val("");
	$("#remarks").val("");
}
