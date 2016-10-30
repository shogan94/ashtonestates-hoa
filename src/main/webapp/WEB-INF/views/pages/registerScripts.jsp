<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/" var="home" />

<script>
	$(document).ready(function() {
		$("#cancelButton").click(function() {
			window.location.href = "${home}"
		});
	});
</script>
