<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/forgotPwd" var="forgotPwd" />

<script>
	$(document).ready(function() {
		$("#forgotBtn").click(function() {
			window.location.href = "${forgotPwd}"
		});
	});
</script>