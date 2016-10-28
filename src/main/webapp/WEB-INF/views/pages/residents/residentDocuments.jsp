<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="content">
		<table id="hTable" class="table table-hover">
			<caption>Homes Resident Documents</caption>
			<thead>
				<tr>
					<th></th>
					<th>File</th>
					<th>UploadedDate</th>
					<th>Size</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${homeFiles}" var="doc">
					<tr>
						<td><a href="${doc.path}" target="_blank" class="btn btn-logout" role="button">View</a></td>
						<td><c:out value="${doc.name}" /></td>
						<td><c:out value="${doc.uploadedDate}" /></td>
						<td><c:out value="${doc.size}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<br />
<div class="row">
	<div class="content">
		<table id="tTable" class="table table-hover">
			<caption>Townhome Resident Documents</caption>
			<thead>
				<tr>
					<th></th>
					<th>File</th>
					<th>UploadedDate</th>
					<th>Size</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${townhomeFiles}" var="doc">
					<tr>
						<td><a href="${doc.path}" target="_blank" class="btn btn-logout" role="button">View</a></td>
						<td><c:out value="${doc.name}" /></td>
						<td><c:out value="${doc.uploadedDate}" /></td>
						<td><c:out value="${doc.size}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
