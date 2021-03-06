$(document).ready(function() {
	populateAllSubjects();

	$('body').on('submit', '#add-subject-form', function(e) {
		e.preventDefault();
	    saveSubject();
	});
});

function saveSubject() {
	var subjectName = $("#subject-name").val();
	var subjectCode = $("#subject-code").val();
	$.ajax({
		method : "POST",
		url : "saveSubject",
		data : JSON.stringify({
			subjectName : subjectName,
			subjectCode : subjectCode
		}),
		dataType : "json",
		contentType: "application/json"
	}).done(function(response) {
		resetForm();
		populateAllSubjects();
		$("#save-subject-dialog-message").dialog({
			modal : true,
			buttons : {
				Ok : function() {
					$(this).dialog("close");
				}
			}
		});
	});
}

function populateAllSubjects() {
	$("#div-all-subjects-display").load('populateAllSubjects', {
		pageFragment : 'manage-subject :: frag-all-subjects'
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#tab-all-subject').DataTable();
	});
}

function resetForm(){
	$("#subject-name").val("");
	$("#subject-code").val("");
}