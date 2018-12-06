function thymeleafFragmentResponseCheck(response) {
	if ((response.indexOf("Error") > -1)) {
		$("body").html(response);
	}
}