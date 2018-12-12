$(document).ready(function() {
	
	populateStandardDropdown();
	populateSubjectDropdown();
	
	$("body").on("click", ".subject-option", function() {
		var subjectId = $("#select-subject-dropdown").val();
		populateTeacherDropdown(subjectId);
	});
	
	$("body").on("click", ".teacher-option", function() {
		var standardId = $("#select-standard-dropdown").val();
		var subjectId = $("#select-subject-dropdown").val();
		var teacherId = $("#select-teacher-dropdown").val();
		populateClassDropdown(standardId, subjectId, teacherId);
	});
	
	$("body").on("click", ".class-option", function() {
		var standardId = $("#select-standard-dropdown").val();
		var classId = $("#select-class-dropdown").val(); 
		populateAvailableStudentsToAssignClass(standardId, classId);
	});
	
	$("body").on("click", "#btn-assign-student-to-class", function() {
		var standardId = $("#select-standard-dropdown").val();
		var classId = $("#select-class-dropdown").val();
		assignStudentsToClass(standardId, classId);
	});
	
	$("body").on("click", "#btn-remove-student-from-class", function() {
		var standardId = $("#select-standard-dropdown").val();
		var classId = $("#select-class-dropdown").val();
		removeStudentsFromClass(standardId, classId);
	});
});

function populateAvailableStudentsToAssignClass(standardId, classId){
	$("#li-available-students-to-assign").load('getAvailableStudentsToAssignClass', {
		pageFragment : 'assign-student-class :: frag-available-students-to-assign',
		standardId : standardId,
		classId : classId
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
	});
	
	$("#li-assigned-students").load('getAssignedStudentsToClass', {
		pageFragment : 'assign-student-class :: frag-assigned-students',
		classId : classId
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
	});
}

function assignStudentsToClass(standardId, classId){
	var studentsToBeAssigned = [];
	$(".chk-available-students:checkbox:checked").each(function(index){
		studentsToBeAssigned.push({
			classId : classId,
			studentId : $(this).val()
		});
	});
	$.ajax({
		method : "POST",
		url : "assignStudentsToClass",
		data : JSON.stringify(studentsToBeAssigned),
		dataType : "json",
		contentType: "application/json"
	}).done(function(response) {
		populateAvailableStudentsToAssignClass(standardId, classId);
		$("#assign-student-dialog-message").dialog({
			modal : true,
			buttons : {
				Ok : function() {
					$(this).dialog("close");
				}
			}
		});
	});
}

function removeStudentsFromClass(standardId, classId){
	var studentsToBeRemoved = [];
	$(".chk-assigned-students:checkbox:checked").each(function(index){
		studentsToBeRemoved.push(parseInt($(this).val()));
	});
	$.ajax({
		method : "POST",
		url : "removeStudentsFromClass",
		data : {
			classId : classId,
			studentList : studentsToBeRemoved
		},
		dataType : "json"
	}).done(function(response) {
		populateAvailableStudentsToAssignClass(standardId, classId);
		$("#remove-student-dialog-message").dialog({
			modal : true,
			buttons : {
				Ok : function() {
					$(this).dialog("close");
				}
			}
		});
	});
}