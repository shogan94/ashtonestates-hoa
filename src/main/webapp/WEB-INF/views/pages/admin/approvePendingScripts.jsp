<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/admin/approve/" var="approve" />
<c:url value="/admin/reject/" var="reject" />

<script>
	$(document).ready(function() {
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

	function approveUser(id) {
		window.location.href = "${approve}" + id;
	};

	function rejectUser(id) {
		window.location.href = "${reject}" + id;
	};
</script>
