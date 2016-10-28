<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/admin/uploadPublicHome" var="uploadPublicHome" />
<c:url value="/admin/uploadResidentHome" var="uploadResidentHome" />

<div class="row">
	<div class="content">
		<table id="hTable" class="table table-hover">
			<caption>Homes Public Documents</caption>
			<thead>
				<tr>
					<th></th>
					<th>File</th>
					<th>UploadedDate</th>
					<th>Size</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${homePublicFiles}" var="doc">
					<tr>
						<td>
							<div class="btn-group">
								<button class="btn btn-danger btn-xs" onclick="deleteDoc(${doc.id})">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
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
		<form action="${uploadPublicHome}" class="dropzone" id="publicHomeDrop"></form>
	</div>
</div>
<br />
<div class="row">
	<div class="content">
		<table id="tTable" class="table table-hover">
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
				<c:forEach items="${homeResidentFiles}" var="doc">
					<tr>
						<td>
							<div class="btn-group">
								<button class="btn btn-danger btn-xs" onclick="deleteDoc(${doc.id})">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
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
		<form action="${uploadResidentHome}" class="dropzone" id="residentHomeDrop"></form>
	</div>
</div>