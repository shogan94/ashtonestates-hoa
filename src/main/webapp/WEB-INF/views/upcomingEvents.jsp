<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/resources" var="resources" />
<c:url value="/" var="home" />
<c:url value="/faq" var="faq" />
<c:url value="/residents" var="residents" />
<c:url value="/logout" var="logout" />
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
<title>Ashton Estates - Upcoming Events</title>
<meta name="description" content="Ashton Estates" />
<meta name="author" content="William Hunt" />
<link href="${resources}/css/bootstrap.min.css" rel="stylesheet" />
<link href="${resources}/css/font-awesome.min.css" rel="stylesheet">
<link href="${resources}/css/style.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h1>
						<a href="${home}"><i class="fa fa-home" id="tooltip1" data-toggle="tooltip" data-placement="top" title="Return to Homepage"></i></a>Ashton Estates
						<c:if test="${residentUser != null}">
							<div class="btn-group btn-group-sm pull-right">
								<h4>
									Hello ${residentUser.getFirstName()} ${residentUser.getLastName()}
									<button id="logoutButton" class="btn btn-xs btn-logout">Logout</button>
								</h4>
							</div>
						</c:if>
					</h1>
				</div>

				<div class="row margintop20">
					<div class="col-md-10">
						<div class="row">
							<table id="eTable" class="table table-hover">
								<caption>Upcoming Events</caption>
								<thead>
									<tr>
										<th>Date</th>
										<th>Title</th>
										<th>Description</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${events}" var="event">
										<tr>
											<td><c:out value="${event.formattedDate()}" /></td>
											<td><c:out value="${event.title}" /></td>
											<td><c:out value="${event.description}" /></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
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
						<c:if test="${residentUser.isAdmin()}">
							<div class="sidebar admin">
								<h4>
									<a href="${admin}">Administrator</a>
								</h4>
							</div>
						</c:if>
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

	<script src="${resources}/js/jquery.min.js"></script>
	<script src="${resources}/js/bootstrap.min.js"></script>
	<script src="${resources}/js/scripts.js"></script>

	<script>
		$(document).ready(function() {
			$('#tooltip1').tooltip();

			$("#logoutButton").click(function() {
				window.location.href = "${logout}"
			});
			
			$('#eTable').DataTable({
				"paging" : false,
				"ordering" : true,
				"info" : false,
				"searching" : false,
				"order" : [ [ 1, "asc" ] ]
			});
		});
	</script>
</body>
</html>
