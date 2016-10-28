<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/residents" var="residents" />

<script>
	$(document).ready(function() {
		$("#cancelButton").click(function() {
			window.location.href = "${residents}"
		});
	});
</script>
