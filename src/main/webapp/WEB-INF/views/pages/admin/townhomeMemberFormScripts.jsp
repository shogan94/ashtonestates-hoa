<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/admin/editBoardMembers" var="editBoardMembers" />

<script>
	$(document).ready(function() {
		$("#cancelButton").click(function() {
			window.location.href = "${editBoardMembers}"
		});
	});
</script>
