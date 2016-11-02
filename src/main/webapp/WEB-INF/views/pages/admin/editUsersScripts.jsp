<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/admin/editUser/" var="editUser" />
<c:url value="/admin/removeUser/" var="removeUser" />
<c:url value="/admin/changePwd/" var="changePwd" />
<c:url value="/residents/getUser/" var="getUser" />

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

	$('#myModal').on(
			'show.bs.modal',
			function(e) {
				var $modal = $(this);
				var userid = e.relatedTarget.dataset.userid;
				var url = "${getUser}" + userid;

				$.ajax({
					type : "GET",
					url : url,
					error : function(xhr, statusText) {
						$modal.find('.replace-body').html("Error: " + statusText);
					},
					success : function(msg) {
						var body = "<table class=\"table table-bordered table-hover\">" + "<tr><td>First Name</td><td>" + msg.firstName + "</td></tr>"
								+ "<tr><td>Last Name</td><td>" + msg.lastName + "</td></tr>" + "<tr><td>Email</td><td>" + msg.email + "</td></tr>" + "<tr><td>Address</td><td>"
								+ msg.address + "</td></tr>" + "<tr><td>Phone</td><td>" + msg.phone + "</td></tr>" + "<tr><td>Approved By</td><td>" + msg.approvedBy + "</td></tr>"
								+ "<tr><td>Role</td><td>" + msg.role + "</td></tr>" + "<tr><td>Created</td><td>" + msg.created + "</td></tr>" + "<tr><td>Approved On</td><td>"
								+ msg.approvedOn + "</td></tr>" + "</table>";

						$modal.find('.replace-body').html(body);
					}
				});

			});
</script>
