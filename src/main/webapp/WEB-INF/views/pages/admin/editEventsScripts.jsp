<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/admin/editEvent/" var="editEvent" />
<c:url value="/admin/removeEvent/" var="removeEvent" />
<c:url value="/admin/addEvent/" var="addEvent" />

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

	function editEvent(id) {
		window.location.href = "${editEvent}" + id;
	};

	function removeEvent(id) {
		window.location.href = "${removeEvent}" + id;
	};

	function addEvent(id) {
		window.location.href = "${addEvent}";
	};
</script>
