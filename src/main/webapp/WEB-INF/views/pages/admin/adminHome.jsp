<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/admin/approvePending" var="approvePending" />
<c:url value="/admin/editUsers" var="editUsers" />
<c:url value="/admin/editEvents" var="editEvents" />
<c:url value="/admin/editDocs" var="editDocs" />
<c:url value="/admin/editBoardMembers" var="editBoard" />

<div class="row">
	<div class="content">
		<table class="table margintop20">
			<tr>
				<td class="col-md-6"><a href="${editUsers}" class="btn btn-block btn-lg btn-admin">Edit Users</a></td>
				<td class="col-md-6"><a href="${editDocs}" class="btn btn-block btn-lg btn-admin">Add/Edit Documents</a></td>
			</tr>
			<tr>
				<td class="col-md-6"><a href="${approvePending}" class="btn btn-block btn-lg btn-admin">Accept/Reject Registrations <span class="badge">${numberPending} pending</span></a></td>
				<td class="col-md-6"><a href="${editEvents}" class="btn btn-block btn-lg btn-admin">Edit Upcoming Events</a></td>
			</tr>
			<tr>
				<td class="col-md-6"><a href="${editBoard}" class="btn btn-block btn-lg btn-admin">Edit Board Members</a></td>
			</tr>
		</table>
	</div>
</div>
