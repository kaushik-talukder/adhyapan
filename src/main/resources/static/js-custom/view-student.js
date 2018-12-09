$(document).ready(function() {
	$('body').on('click','.radio-search-category', function(){
		var categoryValue = $(this).val();
		displaySearchCategoryForm(categoryValue);
	});
	$('body').on('click','.search-by-name', function(){
		var searchCategory = $("input[name=search-categoty]:checked").val();
		var searchKey = $(this).attr("search-key");
		getStudentList(searchCategory, searchKey);
	});
	$('body').on('click','#btn-search-by-student-code', function(){
		var searchCategory = $("input[name=search-categoty]:checked").val();
		var searchKey = $("input#student-code").val();
		getStudentList(searchCategory, searchKey);
	});
	$('body').on('click','.school-option', function(){
		var searchCategory = $("input[name=search-categoty]:checked").val();
		var selectedSchoolId = $("#select-school-dropdown").val();
		getStudentList(searchCategory, selectedSchoolId);
	});
});

function displaySearchCategoryForm(categoryValue){
	$(".div-search-category").addClass("no-display");
	$("#div-student-display-table").addClass("no-display");
	if(categoryValue == 'byFirstName' || categoryValue == 'byLastName'){
		$("#div-by-student-name").removeClass("no-display");
	} else if(categoryValue == 'byStudentCode'){
		$("#div-by-student-code").removeClass("no-display");
	} else if(categoryValue == 'byStandard'){
		$("#div-by-standard").removeClass("no-display");
	} else if(categoryValue == 'byClass'){
		$("#div-by-class").removeClass("no-display");
	} else if(categoryValue == 'byTeacher'){
		$("#div-by-teacher").removeClass("no-display");
	} else if(categoryValue == 'bySchool'){
		populateSchoolDropdown();
		$("#div-by-school").removeClass("no-display");
	} else {
		$(".div-search-category").addClass("no-display");
	}
}

function getStudentList(searchCategory, searchKey) {
	$("#div-student-list").load('getStudentList', {
		pageFragment : 'view-student :: frag-student-list',
		searchCategory : searchCategory,
		searchKey : searchKey
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$("#tab-student-list").DataTable();
		$("#div-student-display-table").removeClass("no-display");
	});
}

function populateSchoolDropdown(){
	$("#select-school-dropdown").load('populateAllSchools', {
		pageFragment : 'view-student :: frag-school-dropdown'
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#select-school-dropdown').selectpicker('refresh');
	});
}