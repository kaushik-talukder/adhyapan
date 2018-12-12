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
		var classId = $("#select-class-dropdown").val(); 
		populateAvailableStudentsToAssignClass(classId);
	});
	
	function populateAvailableStudentsToAssignClass(classId){
		$("#li-available-students-to-assign").load('getAvailableStudentsToAssignClass', {
			pageFragment : 'assign-student-class :: frag-available-students-to-assign',
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
});
