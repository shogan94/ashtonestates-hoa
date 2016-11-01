<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/" var="home" />

<script>
	$(document).ready(function() {
		$("#showSpinner").hide();

		$("#cancelButton").click(function() {
			window.location.href = "${home}"
		});

		$('#regForm').on('submit', function(e) {
			if (e.isDefaultPrevented()) {
				// handle the invalid form...
			} else {
				$("#submitButton").prop('disabled', true);
				$("#showSpinner").show();
			}
		});
	});
</script>
