<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/admin/editUser/" var="editUser" />
<c:url value="/admin/removeUser/" var="removeUser" />
<c:url value="/admin/changePwd/" var="changePwd" />

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

	function editUser(id) {
		window.location.href = "${editUser}" + id;
	};

	function removeUser(id) {
		window.location.href = "${removeUser}" + id;
	};

	function changePwd(id) {
		window.location.href = "${changePwd}" + id;
	};
</script>
