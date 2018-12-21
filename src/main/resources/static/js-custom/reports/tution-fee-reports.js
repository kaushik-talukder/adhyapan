$("document").ready(function(){
	$("body").on("click",".report-by-grp", function(){
		var reportByKey = $(this).val(); 
		displayReportInputBlock(reportByKey);
	});
	$("body").on("click",".standard-option", function(){
		var standardId = $("#select-standard-dropdown").val();
		populateClassMonthDropdownByStandardId(standardId);
	});
	$("body").on("click",".teacher-option", function(){
		var teacherId = $("#select-teacher-dropdown").val();
		populateClassMonthDropdownByTeacherId(teacherId);
	});
	$("body").on("click",".class-option", function(){
		var classId = $("#select-class-dropdown").val();
		populateClassMonthDropdownByClassId(classId);
	});
	$("body").on("click",".student-option", function(){
		var studentId = $("#select-student-dropdown").val();
		populateClassMonthDropdownByStudentId(studentId);
	});
	$("body").on("click","#btn-get-report", function(){
		var reportByKey = $('input[name=report-by-grp]:checked').val();
		alert(reportByKey);
	})
});

function displayReportInputBlock(reportByKey){
	$('.report-by-input-block').addClass("no-display");
	$("#get-report-btn-block").addClass("no-display");
	$("#get-class-month-block").addClass("no-display");
	
	if('byStandard' == reportByKey){
		$("#report-by-standard-block").removeClass("no-display");
		$("#get-class-month-block").removeClass("no-display");
		$("#get-report-btn-block").removeClass("no-display");
		populateStandardDropdown();
	} else if('byTeacher' == reportByKey){
		$("#report-by-teacher-block").removeClass("no-display");
		$("#get-class-month-block").removeClass("no-display");
		$("#get-report-btn-block").removeClass("no-display");
		populateTeacherDropdown();
	} else if('byClass' == reportByKey){
		$("#report-by-class-block").removeClass("no-display");
		$("#get-class-month-block").removeClass("no-display");
		$("#get-report-btn-block").removeClass("no-display");
		populateClassDropdown();
	} else if('byStudent' == reportByKey) {
		$("#report-by-student-block").removeClass("no-display");
		$("#get-class-month-block").removeClass("no-display");
		$("#get-report-btn-block").removeClass("no-display");
	}
}