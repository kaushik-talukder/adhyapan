$(document).ready(function() {
	populateAllCenters();
});

function populateAllCenters() {
	$("#div-all-centers-display").load('populateAllCenters', {
		pageFragment : 'manage-center :: frag-all-centers'
	}, function(response, status, xhr) {
		thymeleafFragmentResponseCheck(response);
		$('#tab-all-centers').DataTable();
	});
}
