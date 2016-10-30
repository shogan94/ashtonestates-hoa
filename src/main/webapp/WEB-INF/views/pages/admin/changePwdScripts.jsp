<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/admin/editUsers" var="cancel" />

<script>
	$(document).ready(function() {
		$("#cancelButton").click(function() {
			window.location.href = "${cancel}"
		});
	});
</script>
