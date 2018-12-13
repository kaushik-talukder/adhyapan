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
		populateClassFee(classId);
		populateStudentDropdown(null,classId);
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
		$("#fee-amount").val(response);
	});
}
