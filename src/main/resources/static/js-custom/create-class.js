$(document).ready(function() {
	populateCenterDropdown();
	populateSubjectDropdown();
	populateStandardDropdown();
	populateTeacherDropdown();
	
	$("#classStartEndDate").daterangepicker({
		locale: {
			format: 'YYYY-MM-DD'
		}
	});
});