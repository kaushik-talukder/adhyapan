$("document").ready(function(){
	$("#startEndDate").daterangepicker({
		locale: {
			format: 'YYYY/MM/DD'
		},
		startDate : moment().add(-1,'month').format('YYYY/MM/DD')
	});
	
	/*var startEndDate = getStartEndDate();
	getRegFeeReportByDateRange(startEndDate.startDate, startEndDate.endDate);*/
	
	$('body').on('submit', '#registration-fee-report-form', function(e) {
		e.preventDefault();
		var startEndDate = getStartEndDate();
		getRegFeeReportByDateRange(startEndDate.startDate, startEndDate.endDate);
	});
});

function getRegFeeReportByDateRange(startDate, endDate){
	$("#div-reg-fee-report").load('getRegFeeReportByDateRange', {
		pageFragment : 'reports/registration-fee-reports :: frag-reg-fee-report',
		startDate : new Date(startDate),
		endDate : new Date(endDate)
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#tab-reg-fee-report').DataTable();
	});
}

function getStartEndDate(){
	var startEndDate = {};
	var startEndDateStr = $("#startEndDate").val();
	var startEndDateArr = startEndDateStr.split(' - ');
	startEndDate.startDate = $.trim(startEndDateArr[0]);
	startEndDate.endDate = $.trim(startEndDateArr[1]);
	return startEndDate;
}