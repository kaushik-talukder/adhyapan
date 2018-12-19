$("document").ready(function(){
	$("#startEndDate").daterangepicker({
		locale: {
			format: 'YYYY/MM/DD'
		},
		startDate : moment().add(-1,'month').format('YYYY/MM/DD')
	});
	
	$('body').on('submit', '#registration-fee-report-form', function(e) {
		e.preventDefault();
		var startEndDateStr = $("#startEndDate").val();
		var startEndDateArr = startEndDateStr.split(' - ');
		var startDate = $.trim(startEndDateArr[0]);
		var endDate = $.trim(startEndDateArr[1]);
		getRegFeeReportByDateRange(startDate, endDate);
	});
});

function getRegFeeReportByDateRange(startDate, endDate){
	$("#div-reg-fee-report").load('getRegFeeReportByDateRange', {
		pageFragment : 'reports/registration-fee-reports :: frag-reg-fee-report',
		startDate : new Date(startDate),
		enddate : new Date(endDate)
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#tab-all-school').DataTable();
	});
}