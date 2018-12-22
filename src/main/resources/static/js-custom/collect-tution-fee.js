$(document).ready(function() {
	$('body').on('click', '.student-option', function() {
		var studentId = $("#select-student-dropdown").val();
		populateClassDropdownByStudent(studentId);
	});
	
	$('body').on('click', '.class-option', function() {
		var studentId = $("#select-student-dropdown").val();
		var classId = $("#select-class-dropdown").val();
		populateClassMonthDropdownByStudentIdAndClassIdMultiSelect(studentId, classId);
		populateStudentFeeTxnDetails(studentId, classId);
		var classFee = $("#select-class-dropdown :checked").attr("class-fee");
		$("#fee-per-month").val(classFee);
	});
	
	
	$('body').on('change', '#select-class-month-dropdown', function() {
		var monthCode = $("#select-class-month-dropdown").val();
		var feePerMonth = $("#fee-per-month").val();
		if(monthCode.length > 0){
			$("#total-fee-amount").val(feePerMonth * monthCode.length);
		} else {
			$("#total-fee-amount").val(0);
		}
	});
	$('body').on('submit', '#tution-fee-form', function(e) {
		e.preventDefault();
		$("#tution-fee-confirm-message").dialog({
			modal : true,
			buttons : {
				Save : function() {
					$(this).dialog("close");
					saveTutionFee();
				},
				Cancel : function(){
					$(this).dialog("close");
				}
			}
		});
	});
});

function saveTutionFee(){
	var classId = $("#select-class-dropdown").val();
	var studentId = $("#select-student-dropdown").val();
	var monthCode = $("#select-class-month-dropdown").val();
	var feeCategoryId= $("#fee-category-id").val();
	var remarks = $("#remarks").val();
	var feeAmount = $("#total-fee-amount").val();
	var studentTutionFee = [];

	$(monthCode).each(function(index, value){
		if (index > 0){
			feeAmount = 0;
		}
		studentTutionFee.push({
			classId: classId,
			studentId: studentId,
			monthCode: value,
			feeAmount: feeAmount,
			feeCategoryId : feeCategoryId,
			remarks:remarks
		});
	});
	
	$.ajax({
		method : "POST",
		url : "saveTutionFee",
		data : JSON.stringify(studentTutionFee),
		dataType : "json",
		contentType: "application/json"
	}).done(function(response) {
		resetForm();
		populateStudentFeeTxnDetails(studentId, classId);
		$("#tution-fee-dialog-message").dialog({
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
	$("#select-class-month-dropdown").val('').selectpicker('refresh');
	$("#total-fee-amount").val("");
	$("#remarks").val("");
}

function populateStudentFeeTxnDetails(studentId, classId){
	$("#div-student-fee-txn-details").load('populateStudentFeeTxnDetails', {
		pageFragment : 'collect-tution-fee :: frag-student-fee-txn',
		studentId : studentId,
		classId : classId
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#tab-student-fee-txn').DataTable();
	});
}