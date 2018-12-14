$(document).ready(function() {
	populateAllSchools();
	
	$('body').on('click', '#btn-save-school', function() {
		var addSchoolForm = $("#add-school-form").parsley();
		if(addSchoolForm.isValid()){
			saveSchool();
		}
	});
});

function saveSchool() {
	var schoolName = $("#school-name").val();
	var schoolCode = $("#school-code").val();
	$.ajax({
		method : "POST",
		url : "saveSchool",
		data : JSON.stringify({
			schoolName : schoolName,
			schoolCode : schoolCode
		}),
		dataType : "json",
		contentType: "application/json"
	}).done(function(response) {
		resetForm();
		populateAllSchools();
		$("#save-school-dialog-message").dialog({
			modal : true,
			buttons : {
				Ok : function() {
					$(this).dialog("close");
				}
			}
		});
	});
}

function populateAllSchools() {
	$("#div-all-schools-display").load('populateAllSchools', {
		pageFragment : 'manage-school :: frag-all-schools'
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#tab-all-school').DataTable();
	});
}

function resetForm(){
	$("#school-name").val("");
	$("#school-code").val("");
}