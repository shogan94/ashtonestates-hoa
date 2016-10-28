<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/admin/editHomeDocs" var="editHomeDocs" />
<c:url value="/admin/editTownhomeDocs" var="editTownhomeDocs" />

<div class="row">
	<div class="content">
		<table class="table margintop20">
			<tr>
				<td class="col-md-6"><a href="${editHomeDocs}" class="btn btn-block btn-lg btn-admin">Add/Edit Home Documents</a></td>
				<td class="col-md-6"><a href="${editTownhomeDocs}" class="btn btn-block btn-lg btn-admin">Add/Edit Townhome Documents</a></td>
			</tr>
		</table>
	</div>
</div>
