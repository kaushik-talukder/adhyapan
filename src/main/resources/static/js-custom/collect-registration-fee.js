$(document).ready(function() {
	$("body").on("keyup", "#student-first-name", function(){
		if(($(this).val()).length >= 4){
			$("#select-student-dropdown").closest("div.bootstrap-select").addClass("open");
			populateStudentDropdown(null, null, $(this).val());
		}
	});
	$("body").on("submit", "#registration-fee-form", function(e){
		e.preventDefault();
		$("#registration-fee-confirm-message").dialog({
			modal : true,
			buttons : {
				Save : function() {
					$(this).dialog("close");
					saveRegistrationFee();
				},
				Cancel : function(){
					$(this).dialog("close");
				}
			}
		});
	});
});

function saveRegistrationFee(){
	var studentId = $("#select-student-dropdown").val();
	var feeCategoryId= $("#fee-category-id").val();
	var remarks = $("#remarks").val();
	var feeAmount = $("#fee-amount").val();
	
	$.ajax({
		method : "POST",
		url : "saveRegistrationFee",
		data : JSON.stringify({
			studentId: studentId,
			feeCategoryId: feeCategoryId,
			feeAmount: feeAmount,
			remarks: remarks
		}),
		dataType : "json",
		contentType: "application/json"
	}).done(function(response) {
		resetForm();
		$("#registration-fee-dialog-message").dialog({
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
	$("#student-first-name").val("");
	$("#select-student-dropdown").val('').selectpicker('refresh');
	$("#fee-amount").val("");
	$("#remarks").val("");
}