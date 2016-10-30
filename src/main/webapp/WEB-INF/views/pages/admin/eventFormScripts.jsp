<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/admin/editEvents/" var="editEvents" />

<script>
	$(document).ready(function() {
		$('#datetimepicker1').datetimepicker();

		$("#cancelButton").click(function() {
			window.location.href = "${editEvents}"
		});

		$('#uTable').DataTable({
			"paging" : false,
			"ordering" : true,
			"info" : false,
			"searching" : false,
			"order" : [ [ 2, "asc" ] ],
			"columnDefs" : [ {
				"targets" : 0,
				"orderable" : false,
			} ]
		});
	});
</script>
