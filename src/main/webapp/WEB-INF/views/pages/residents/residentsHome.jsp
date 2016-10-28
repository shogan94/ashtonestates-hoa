<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/resources" var="resources" />
<c:url value="/residents/directory" var="directory" />
<c:url value="/residents/documents" var="residentDocuments" />
<c:url value="/residents/changePwd" var="changePwd" />
<c:url value="/residents/updateInfo" var="updateInfo" />


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
	<div class="col-md-12 text-center center-block">
		<div class="publicInfo">
			<h2>Contact Information</h2>
			<div class="row">
				<div class="col-md-6 text-center center-block">
					<div class="contactInfo">
						<h3>Master Association Board</h3>
						<ul class="list-group">
							<li class="list-group-item"><span class="badge"><a href="mailto:pres@ashtonestates.org"><span class="glyphicon glyphicon-envelope"></span></a></span>President - Jeff D.</li>
							<li class="list-group-item"><span class="badge"><a href="mailto:pres@ashtonestates.org"><span class="glyphicon glyphicon-envelope"></span></a></span>VicePresident -
								Michael Kief</li>
							<li class="list-group-item"><span class="badge"><a href="mailto:pres@ashtonestates.org"><span class="glyphicon glyphicon-envelope"></span></a></span>Secretary - Brenda
								Hawkins</li>
						</ul>
					</div>
				</div>
				<div class="col-md-6 text-center center-block">
					<div class="contactInfo">
						<h3>Home Owners Board Members</h3>
						<ul class="list-group">
							<li class="list-group-item"><span class="badge"><a href="mailto:pres@ashtonestates.org"><span class="glyphicon glyphicon-envelope"></span></a></span>Jeff D.</li>
							<li class="list-group-item"><span class="badge"><a href="mailto:pres@ashtonestates.org"><span class="glyphicon glyphicon-envelope"></span></a></span>Betty Jurick</li>
							<li class="list-group-item"><span class="badge"><a href="mailto:pres@ashtonestates.org"><span class="glyphicon glyphicon-envelope"></span></a></span>Michael Kief</li>
							<li class="list-group-item"><span class="badge"><a href="mailto:pres@ashtonestates.org"><span class="glyphicon glyphicon-envelope"></span></a></span>Dave Marino</li>
							<li class="list-group-item"><span class="badge"><a href="mailto:pres@ashtonestates.org"><span class="glyphicon glyphicon-envelope"></span></a></span>John Vidovich</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 text-center center-block">
					<div class="contactInfo">
						<h3>Townhome Owners Board Members</h3>
						<ul class="list-group">
							<li class="list-group-item"><span class="badge"><a href="mailto:pres@ashtonestates.org"><span class="glyphicon glyphicon-envelope"></span></a></span>Alex Guy</li>
							<li class="list-group-item"><span class="badge"><a href="mailto:pres@ashtonestates.org"><span class="glyphicon glyphicon-envelope"></span></a></span>Brenda Hawkins</li>
							<li class="list-group-item"><span class="badge"><a href="mailto:pres@ashtonestates.org"><span class="glyphicon glyphicon-envelope"></span></a></span>Stephanie Mazzei</li>
							<li class="list-group-item"><span class="badge"><a href="mailto:pres@ashtonestates.org"><span class="glyphicon glyphicon-envelope"></span></a></span>DeAnna Snyder</li>
						</ul>
					</div>
				</div>
				<div class="col-md-6 text-center center-block">
					<div class="contactInfo">
						<h3>Building Committee Chair</h3>
						<ul class="list-group">
							<li class="list-group-item"><span class="badge"><a href="mailto:pres@ashtonestates.org"><span class="glyphicon glyphicon-envelope"></span></a></span>Jackie Marino</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
