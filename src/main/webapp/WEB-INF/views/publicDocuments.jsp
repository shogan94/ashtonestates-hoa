<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<c:url value="/resources" var="resources" />
<c:url value="/" var="home" />
<c:url value="/faq" var="faq" />
<c:url value="/residents" var="residents" />
<c:url value="/logout" var="logout" />
<c:url value="/login" var="login" />
<c:url value="/directory" var="directory" />
<c:url value="/documents" var="documents" />
<c:url value="/publicDocs" var="publicDocs" />
<c:url value="/upcomingEvents" var="upcomingEvents" />
<c:url value="/admin" var="admin" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Ashton Estates - ${typeofdocs} Documents</title>
<meta name="description" content="Ashton Estates" />
<meta name="author" content="William Hunt" />
<link href="${resources}/css/bootstrap.min.css" rel="stylesheet" />
<link href="${resources}/css/font-awesome.min.css" rel="stylesheet">
<link href="${resources}/css/style.css" rel="stylesheet" />
<link href="${resources}/css/jquery.dataTables.min.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h1>
						<a href="${home}"><i class="fa fa-home" id="tooltip1" data-toggle="tooltip" data-placement="top" title="Return to Homepage"></i></a>Ashton Estates
						<sec:authorize access="isAuthenticated()">
							<div class="btn-group btn-group-sm pull-right">
								<h4>
									Hello ${loggedInUserName}
									<button id="logoutButton" class="btn btn-xs btn-logout">Logout</button>
								</h4>
							</div>
						</sec:authorize>
						<sec:authorize access="isAnonymous()">
							<div class="btn-group btn-group-sm pull-right">
								<button id="loginButton" class="btn btn-xs btn-logout">Login</button>
							</div>
						</sec:authorize>
					</h1>
				</div>

				<div class="row margintop20">
					<div class="col-md-10">
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
										<c:forEach items="${homeFiles}" var="doc">
											<tr>
												<c:url value="${doc.path}" var="doc.path" />
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
						<br/>
						<div class="row">
							<div class="content">
								<table id="tTable" class="table table-hover">
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
										<c:forEach items="${townhomeFiles}" var="doc">
											<tr>
												<c:url value="${doc.path}" var="doc.path" />
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
					</div>
					<div class="col-md-2">
						<div class="sidebar">
							<h4>
								<a href="${residents}">Residents</a>
							</h4>
						</div>
						<div class="sidebar">
							<h4>
								<a href="${faq}">FAQs</a>
							</h4>
						</div>
						<div class="sidebar">
							<h4>
								<a href="${publicDocs}">Public Documents</a>
							</h4>
						</div>
						<div class="sidebar">
							<h4>
								<a href="${upcomingEvents}">Upcoming Events</a>
							</h4>
						</div>
						<sec:authorize access="hasRole('ADMIN')">
							<div class="sidebar admin">
								<h4>
									<a href="${admin}">Administrator</a>
								</h4>
							</div>
						</sec:authorize>
					</div>
				</div>
			</div>
		</div>

		<footer id="main-footer" class="margintop20">
			<div id="footer-bottom">
				<div class="container clearfix">
					<ul class="social-icons">
						<li class="social-icon-facebook"><a href="https://www.facebook.com/groups/ashtonestates/" target="_blank"><i class="fa fa-facebook-square"></i></a></li>
						<li class="social-icon-nextdoor"><a href="https://ashtonestates.nextdoor.com/neighborhood_feed/" target="_blank"><i class="fa fa-home"></i></a></li>
					</ul>
					<p id="footer-info" class="pull-right">� 2016 William Hunt | Morgantown, WV 26508</p>
				</div>
			</div>
		</footer>

	</div>

	<script src="${resources}/js/jquery-3.1.0.min.js"></script>
	<script src="${resources}/js/bootstrap.min.js"></script>
	<script src="${resources}/js/jquery.dataTables.min.js"></script>

	<script>
		$(document).ready(function() {
			$('#tooltip1').tooltip();

			$("#logoutButton").click(function() {
				window.location.href = "${logout}"
			});
			
			$("#loginButton").click(function() {
				window.location.href = "${login}"
			});

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
	</script>
</body>
</html>
