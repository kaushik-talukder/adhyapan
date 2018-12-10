$(document).ready(function() {
	populateAllTeachers();
});

function populateAllTeachers(){
	$("#div-all-teachers-display").load('populateAllTeachers', {
		pageFragment : 'view-teacher :: frag-all-teachers'
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#tab-all-teachers').DataTable();
	});
}