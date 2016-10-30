<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/admin/deleteTownhomeDoc/" var="deleteDoc" />
<c:url value="/admin/editTownhomeDocs/" var="editTownhomeDocs" />

<script>
	var publicErrorUpload = false;
	var residentErrorUpload = false;

	Dropzone.options.publicTownhomeDrop = {
		init : function() {
			this.on('queuecomplete', function() {
				if (!publicErrorUpload) {
					window.location.href = "${editTownhomeDocs}"
				} else {
					publicErrorUpload = true;
				}
			});
			this.on('error', function(msg) {
				publicErrorUpload = true;
			});
		}
	};

	Dropzone.options.residentTownhomeDrop = {
		init : function() {
			this.on('queuecomplete', function() {
				if (!residentErrorUpload) {
					window.location.href = "${editTownhomeDocs}"
				} else {
					residentErrorUpload = true;
				}
			});
			this.on('error', function(msg) {
				residentErrorUpload = true;
			});
		}
	};

	$(document).ready(function() {
		$('#hTable').DataTable({
			"paging" : false,
			"ordering" : true,
			"info" : false,
			"searching" : false,
			"order" : [ [ 1, "asc" ] ],
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
			"order" : [ [ 1, "asc" ] ],
			"columnDefs" : [ {
				"targets" : 0,
				"orderable" : false,
			} ]
		});
	});

	function deleteDoc(id) {
		window.location.href = "${deleteDoc}" + id;
	};
</script>
