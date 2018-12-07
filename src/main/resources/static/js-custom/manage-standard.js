$(document).ready(function() {
	populateAllStandards();
});

function populateAllStandards() {
	$("#div-all-standards-display").load('populateAllStandards', {
		pageFragment : 'manage-standard :: frag-all-standards'
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#tab-all-standards').DataTable();
	});
}
