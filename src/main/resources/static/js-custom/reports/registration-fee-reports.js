$("document").ready(function(){
	$("#startEndDate").daterangepicker({
		locale: {
			format: 'YYYY/MM/DD'
		},
		startDate : moment().add(1,'year').format('YYYY/MM/DD')
	});
});