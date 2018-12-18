$("document").ready(function(){
	$("body").on("keyup", "#student-first-name", function(){
		if(($(this).val()).length >= 4){
			$("#select-student-dropdown").closest("div.bootstrap-select").addClass("open");
			populateStudentDropdown(null, null, $(this).val());
		}
	});
});

function thymeleafFragmentResponseCheck(response) {
	if ((response.indexOf("Error") > -1)) {
		$("body").html(response);
	}
}

function populateSchoolDropdown(){
	$("#select-school-dropdown").load('populateAllSchools', {
		pageFragment : 'components/data-component.html :: frag-school-dropdown'
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#select-school-dropdown').selectpicker('refresh');
	});
}

function populateSubjectDropdown(){
	$("#select-subject-dropdown").load('populateAllSubjects', {
		pageFragment : 'components/data-component.html :: frag-subject-dropdown'
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#select-subject-dropdown').selectpicker('refresh');
	});
}

function populateStandardDropdown(){
	$("#select-standard-dropdown").load('populateAllStandards', {
		pageFragment : 'components/data-component.html :: frag-standard-dropdown'
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#select-standard-dropdown').selectpicker('refresh');
	});
}

function populateCenterDropdown(){
	$("#select-center-dropdown").load('populateAllCenters', {
		pageFragment : 'components/data-component.html :: frag-center-dropdown'
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#select-center-dropdown').selectpicker('refresh');
	});
}

function populateTeacherDropdown(subjectId){
	$("#select-teacher-dropdown").load('populateActiveTeachers', {
		pageFragment : 'components/data-component.html :: frag-teacher-dropdown',
		subjectId : subjectId
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#select-teacher-dropdown').selectpicker('refresh');
	});
}

function populateClassDropdown(standardId, subjectId, teacherId){
	$("#select-class-dropdown").load('populateActiveClasses', {
		pageFragment : 'components/data-component.html :: frag-class-dropdown',
		standardId : standardId,
		subjectId : subjectId,
		teacherId : teacherId
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#select-class-dropdown').selectpicker('refresh');
	});
}

function populateStudentDropdown(standardId, classId, studentFirstName){
	$("#select-student-dropdown").load('populateActiveStudents', {
		pageFragment : 'components/data-component.html :: frag-student-dropdown',
		standardId : standardId,
		classId : classId,
		studentFirstName : studentFirstName
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#select-student-dropdown').selectpicker('refresh');
	});
}

function populateClassMonthDropdown(classId){
	$("#select-class-month-dropdown").load('populateClassMonth', {
		pageFragment : 'components/data-component.html :: frag-class-month-dropdown',
		classId : classId
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#select-class-month-dropdown').selectpicker('refresh');
	});
}

function populateStudentClassMonthDropdown(studentId, classId){
	$("#select-student-class-month-dropdown").load('populateStudentClassMonth', {
		pageFragment : 'components/data-component.html :: frag-student-class-month-dropdown',
		studentId: studentId,
		classId : classId
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#select-student-class-month-dropdown').selectpicker('refresh');
	});
}