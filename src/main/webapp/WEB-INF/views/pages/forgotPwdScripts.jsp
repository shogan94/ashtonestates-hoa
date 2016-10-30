<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/" var="home" />

<script>
	$(document).ready(function() {
		$("#cancelButton").click(function() {
			window.location.href = "${home}"
		});
	});
</script>
