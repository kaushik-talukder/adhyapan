$("document").ready(function(){
	$("body").on("click",".report-by-grp", function(){
		var reportByKey = $(this).val(); 
		displayReportInputBlock(reportByKey);
	});
	
	$("body").on("click","#btn-get-report", function(){
		var reportByKey = $('input[name=report-by-grp]:checked').val();
		alert(reportByKey);
	})
});

function displayReportInputBlock(reportByKey){
	$('.report-by-input-block').addClass("no-display");
	$("#get-report-btn-block").addClass("no-display");
	
	if('byStandard' == reportByKey){
		$("#report-by-standard-block").removeClass("no-display");
		$("#get-report-btn-block").removeClass("no-display");
		populateStandardDropdown();
	} else if('byTeacher' == reportByKey){
		$("#report-by-teacher-block").removeClass("no-display");
		$("#get-report-btn-block").removeClass("no-display");
		populateTeacherDropdown();
	} else if('byClass' == reportByKey){
		$("#report-by-class-block").removeClass("no-display");
		$("#get-report-btn-block").removeClass("no-display");
		populateClassDropdown();
	} else if('byStudent' == reportByKey) {
		$("#report-by-student-block").removeClass("no-display");
		$("#get-report-btn-block").removeClass("no-display");
	}
}