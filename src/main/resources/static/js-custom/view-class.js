$(document).ready(function() {
	populateAllClasses();
});

function populateAllClasses() {
	$("#div-all-classes-display").load('populateAllClasses', {
		pageFragment : 'view-class :: frag-all-classes'
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#tab-all-classes').DataTable();
	});
}