$(document).ready(function() {
	populateSchoolDropdown();
	populateSubjectDropdown();
	
	$('body').on('click', '#btn-register-teacher', function() {
		registerTeacher();
	});
});

function populateSchoolDropdown(){
	$("#select-school-dropdown").load('populateAllSchools', {
		pageFragment : 'register-teacher :: frag-school-dropdown'
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#select-school-dropdown').selectpicker('refresh');
	});
}

function populateSubjectDropdown(){
	$("#select-subject-dropdown").load('populateAllSubjects', {
		pageFragment : 'register-teacher :: frag-subject-dropdown'
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#select-subject-dropdown').selectpicker('refresh');
	});
}

function registerTeacher(){
	var firstName = $('#first-name').val();
	var lastName = $('#last-name').val();
	var schoolId = $('#select-school-dropdown').val();
	var subjectId = $('#select-subject-dropdown').val();
	var teacherCode = $('#teacher-code').val();
	var teacherContact = $('#teacher-contact').val();
	var teacherAddress = $('#teacher-address').val();
	
	$.ajax({
		method : "POST",
		url : "registerTeacher",
		data : JSON.stringify({
			firstName : firstName,
			lastName : lastName,
			teacherCode : teacherCode,
			contact: teacherContact,
			address: teacherAddress,
			schoolId: schoolId,
			subjectId: subjectId
		}),
		dataType : "json",
		contentType: "application/json"
	}).done(function(response) {
		resetForm();
		$("#register-teacher-dialog-message").dialog({
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
	$('#first-name').val('');
	$('#last-name').val('');
	$('#select-school-dropdown').val('').selectpicker('refresh');;
	$('#select-subject-dropdown').val('').selectpicker('refresh');;
	$('#teacher-code').val('');
	$('#teacher-contact').val('');
	$('#teacher-address').val('');
}