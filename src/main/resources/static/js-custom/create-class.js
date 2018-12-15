$(document).ready(function() {
	populateCenterDropdown();
	populateSubjectDropdown();
	populateStandardDropdown();
	
	$("body").on("click", ".subject-option", function() {
		var subjectId = $("#select-subject-dropdown").val();
		populateTeacherDropdown(subjectId);
	});
	
	$("#classStartDate").daterangepicker({
		locale: {
			format: 'YYYY/MM/DD'
		},
		singleDatePicker : true
	});
	
	$("#classEndDate").daterangepicker({
		locale: {
			format: 'YYYY/MM/DD'
		},
		startDate : moment().add(1,'year').format('YYYY/MM/DD'),
		singleDatePicker : true
	});
	
	
	$('body').on('submit', '#create-class-form', function(e){
		e.preventDefault();
		createClass();
	});
});

function createClass(){
	var classCode = $("#class-code").val();
	var centerId = $("#select-center-dropdown").val();
	var subjectId = $("#select-subject-dropdown").val();
	var standardId = $("#select-standard-dropdown").val();
	var teacherId = $("#select-teacher-dropdown").val();
	var startDate = new Date($('#classStartDate').val());
	var endDate = new Date($('#classEndDate').val());
	var feeAmount = $("#fee-amount").val();
	
	$.ajax({
		method : "POST",
		url : "createClass",
		data : JSON.stringify({
			classCode : classCode,
			centerId : centerId,
			subjectId : subjectId,
			standardId: standardId,
			teacherId: teacherId,
			startDate: startDate,
			endDate: endDate,
			fee: feeAmount
		}),
		dataType : "json",
		contentType: "application/json"
	}).done(function(response) {
		resetForm();
		$("#create-class-dialog-message").dialog({
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
	$("#class-code").val('');
	$("#select-center-dropdown").val('').selectpicker('refresh');;
	$("#select-subject-dropdown").val('').selectpicker('refresh');;
	$("#select-standard-dropdown").val('').selectpicker('refresh');;
	$("#select-teacher-dropdown").val('').selectpicker('refresh');;
	$('#classStartDate').data('daterangepicker').setStartDate(moment().format('YYYY/MM/DD'));
	$('#classEndDate').data('daterangepicker').setStartDate(moment().add(1,'year').format('YYYY/MM/DD'));
	$("#fee-amount").val('');
}