<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/admin/editMasterMember/" var="editMasterMember" />
<c:url value="/admin/removeMasterMember/" var="removeMasterMember" />
<c:url value="/admin/addMasterMember/" var="addMasterMember" />

<c:url value="/admin/editHomeMember/" var="editHomeMember" />
<c:url value="/admin/removeHomeMember/" var="removeHomeMember" />
<c:url value="/admin/addHomeMember/" var="addHomeMember" />

<c:url value="/admin/editTownhomeMember/" var="editTownhomeMember" />
<c:url value="/admin/removeTownhomeMember/" var="removeTownhomeMember" />
<c:url value="/admin/addTownhomeMember/" var="addTownhomeMember" />

<script>
	$(document).ready(function() {
		$('#mTable').DataTable({
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
		$('#hTable').DataTable({
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
		$('#tTable').DataTable({
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

	function editMasterMember(id) {
		window.location.href = "${editMasterMember}" + id;
	};

	function removeMasterMember(id) {
		window.location.href = "${removeMasterMember}" + id;
	};

	function addMasterMember(id) {
		window.location.href = "${addMasterMember}";
	};
	
	function editHomeMember(id) {
		window.location.href = "${editHomeMember}" + id;
	};

	function removeHomeMember(id) {
		window.location.href = "${removeHomeMember}" + id;
	};

	function addHomeMember(id) {
		window.location.href = "${addHomeMember}";
	};
	
	function editTownhomeMember(id) {
		window.location.href = "${editTownhomeMember}" + id;
	};

	function removeTownhomeMember(id) {
		window.location.href = "${removeTownhomeMember}" + id;
	};

	function addTownhomeMember(id) {
		window.location.href = "${addTownhomeMember}";
	};
</script>
