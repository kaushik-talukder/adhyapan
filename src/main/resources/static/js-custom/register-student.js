$(document).ready(function() {
	populateSchoolDropdown();
	$('body').on('click', '#btn-register-student', function() {
		registerStudent();
	});
});

function populateSchoolDropdown(){
	$("#select-school-dropdown").load('populateAllSchools', {
		pageFragment : 'register-student :: frag-school-dropdown'
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#select-school-dropdown').selectpicker('refresh');
	});
}

function registerStudent(){
	var firstName = $('#first-name').val();
	var lastName = $('#last-name').val();
	var studentCode = $('#student-code').val();
	var schoolId = $('#select-school-dropdown').val();
	var guardianName = $('#guardian-name').val();
	var address = $('#address').val();
	var guardianContact = $('#guardian-contact').val();
	var studentContact = $('#student-contact').val();
	
	$.ajax({
		method : "POST",
		url : "registerStudent",
		data : JSON.stringify({
			studentCode: studentCode,
			firstName : firstName,
			lastName : lastName,
			guardianName : guardianName,
			guardianContact: guardianContact,
			studentContact: studentContact,
			address: address,
			schoolId: schoolId
		}),
		dataType : "json",
		contentType: "application/json"
	}).done(function(response) {
		resetForm();
		$("#register-student-dialog-message").dialog({
			modal : true,
			buttons : {
				Ok : function() {
					$(this).dialog("close");
				}
			}
		});
	});
}

function resetForm() {
	$('#first-name').val('');
	$('#last-name').val('');
	$('#student-code').val('');
	$('#select-school-dropdown').val('').selectpicker('refresh');;
	$('#guardian-name').val('');
	$('#address').val('');
	$('#guardian-contact').val('');
	$('#student-contact').val('');
}