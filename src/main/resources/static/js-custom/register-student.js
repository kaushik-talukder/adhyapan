$(document).ready(function() {
	populateSchoolDropdown();
	$('body').on('click', '#btn-register-student', function() {
		registerStudent();
	});
});

function registerStudent(){
	var firstName = $('#first-name').val();
	var lastName = $('#last-name').val();
	var studentCode = $('#student-code').val();
	var schoolId = $('#select-school-dropdown').val();
	var guardianName = $('#guardian-name').val();
	var address = $('#address').val();
	var guardianContact = $('#guardian-contact').val();
	var studentContact = $('#student-contact').val();
	var gender = $('input[name=gender]:checked').val();
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
			gender: gender,
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
	$('input[name="gender"]').prop('checked', false);
}