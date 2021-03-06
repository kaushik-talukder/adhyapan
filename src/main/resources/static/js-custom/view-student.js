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
	
	$('body').on('click','.standard-option', function(){
		var searchCategory = $("input[name=search-categoty]:checked").val();
		var selectedStandardId = $("#select-standard-dropdown").val();
		getStudentList(searchCategory, selectedStandardId);
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
		populateStandardDropdown();
		$("#div-by-standard").removeClass("no-display");
	} else if(categoryValue == 'byClass'){
		populateClassDropdown();
		$("#div-by-class").removeClass("no-display");
	} else if(categoryValue == 'byTeacher'){
		populateTeacherDropdown();
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
