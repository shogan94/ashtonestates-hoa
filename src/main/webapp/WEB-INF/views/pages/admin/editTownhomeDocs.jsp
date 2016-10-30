<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/admin/uploadPublicTownhome" var="uploadPublicTownhome" />
<c:url value="/admin/uploadResidentTownhome" var="uploadResidentTownhome" />

<div class="row">
	<div class="content">
		<table id="hTable" class="table table-hover">
			<caption>Townhome Public Documents</caption>
			<thead>
				<tr>
					<th></th>
					<th>File</th>
					<th>UploadedDate</th>
					<th>Size</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${townhomePublicFiles}" var="doc">
					<tr>
						<td>
							<div class="btn-group">
								<button class="btn btn-danger btn-xs" onclick="deleteDoc(${doc.id})">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								</button>
							</div>
						</td>
						<td><c:out value="${doc.name}" /></td>
						<td><c:out value="${doc.uploadedDate}" /></td>
						<td><c:out value="${doc.size}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form action="${uploadPublicTownhome}" class="dropzone" id="publicTownhomeDrop"></form>
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
				<c:forEach items="${townhomeResidentFiles}" var="doc">
					<tr>
						<td>
							<div class="btn-group">
								<button class="btn btn-danger btn-xs" onclick="deleteDoc(${doc.id})">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								</button>
							</div>
						</td>
						<td><c:out value="${doc.name}" /></td>
						<td><c:out value="${doc.uploadedDate}" /></td>
						<td><c:out value="${doc.size}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form action="${uploadResidentTownhome}" class="dropzone" id="residentTownhomeDrop"></form>
	</div>
</div>
