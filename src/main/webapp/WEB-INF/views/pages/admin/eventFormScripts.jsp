<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/admin/editEvents/" var="editEvents" />

<script>
	$(document).ready(function() {
		$('#datetimepicker1').datetimepicker();

		$("#cancelButton").click(function() {
			window.location.href = "${editEvents}"
		});
	});
</script>
