<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/resources" var="resources" />
<c:url value="/residents/directory" var="directory" />
<c:url value="/residents/documents" var="residentDocuments" />
<c:url value="/residents/changePwd" var="changePwd" />
<c:url value="/residents/updateInfo" var="updateInfo" />
<c:url value="/residents/boardMembers" var="boardMembers" />
<c:url value="/residents/feedback" var="feedback" />


<div class="row">
	<div class="col-md-6 text-center center-block">
		<div class="publicInfo">
			<h2>Resident Documents</h2>
			<a href="${residentDocuments}"> <img class="img-responsive image-center resident-image" src="${resources}/images/resident-documents.png" alt="resident documents" /></a>
		</div>
	</div>
	<div class="col-md-6 text-center center-block">
		<div class="publicInfo">
			<h2>Resident Directory</h2>
			<a href="${directory}"> <img class="img-responsive image-center resident-image" src="${resources}/images/resident-directory.png" alt="resident directory" /></a>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-6 text-center center-block">
		<div class="publicInfo">
			<h2>Change Password</h2>
			<a href="${changePwd}"> <img class="img-responsive image-center resident-image" src="${resources}/images/forgot.png" alt="change password" /></a>
		</div>
	</div>
	<div class="col-md-6 text-center center-block">
		<div class="publicInfo">
			<h2>Update Information</h2>
			<a href="${updateInfo}"> <img class="img-responsive image-center resident-image" src="${resources}/images/updateInfo.png" alt="update information" /></a>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-6 text-center center-block">
		<div class="publicInfo">
			<h2>Board Member Information</h2>
			<a href="${boardMembers}"> <img class="img-responsive image-center resident-image" src="${resources}/images/boardmembers.png" alt="board members" /></a>
		</div>
	</div>
	<div class="col-md-6 text-center center-block">
		<div class="publicInfo">
			<h2>Feedback / Comments</h2>
			<a href="${feedback}"> <img class="img-responsive image-center resident-image" src="${resources}/images/feedback.png" alt="feedback" /></a>
		</div>
	</div>
</div>