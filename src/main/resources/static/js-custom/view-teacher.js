$(document).ready(function() {
	populateTeachersList();
});

function populateTeachersList(){
	$("#div-all-teachers-display").load('populateTeachersList', {
		pageFragment : 'view-teacher :: frag-all-teachers'
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#tab-all-teachers').DataTable();
	});
}