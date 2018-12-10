function thymeleafFragmentResponseCheck(response) {
	if ((response.indexOf("Error") > -1)) {
		$("body").html(response);
	}
}

function populateSchoolDropdown(){
	$("#select-school-dropdown").load('populateAllSchools', {
		pageFragment : 'components/data-component.html :: frag-school-dropdown'
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#select-school-dropdown').selectpicker('refresh');
	});
}

function populateSubjectDropdown(){
	$("#select-subject-dropdown").load('populateAllSubjects', {
		pageFragment : 'components/data-component.html :: frag-subject-dropdown'
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#select-subject-dropdown').selectpicker('refresh');
	});
}

function populateStandardDropdown(){
	$("#select-standard-dropdown").load('populateAllStandards', {
		pageFragment : 'components/data-component.html :: frag-standard-dropdown'
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#select-standard-dropdown').selectpicker('refresh');
	});
}

function populateCenterDropdown(){
	$("#select-center-dropdown").load('populateAllCenters', {
		pageFragment : 'components/data-component.html :: frag-center-dropdown'
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#select-center-dropdown').selectpicker('refresh');
	});
}

function populateTeacherDropdown(){
	$("#select-teacher-dropdown").load('populateAllTeachers', {
		pageFragment : 'components/data-component.html :: frag-teacher-dropdown'
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#select-teacher-dropdown').selectpicker('refresh');
	});
}