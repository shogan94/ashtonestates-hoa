<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/resources" var="resources" />
<c:url value="/" var="home" />
<c:url value="/faq" var="faq" />
<c:url value="/residents" var="residents" />
<c:url value="/admin/editEvents/" var="editEvents" />
<c:url value="/admin/changePwd/" var="changePwd" />
<c:url value="/upcomingEvents" var="upcomingEvents" />
<c:url value="/admin" var="admin" />
<c:url value="/logout" var="logout" />
<c:url value="/admin/processEvent" var="processEvent" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Ashton Estates - Add/Edit Events</title>
<meta name="description" content="Ashton Estates" />
<meta name="author" content="William Hunt" />
<link href="${resources}/css/bootstrap.min.css" rel="stylesheet" />
<link href="${resources}/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
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
						<a href="${home}"><i class="fa fa-home" id="tooltip1" data-toggle="tooltip" data-placement="top" title="Return to Homepage"></i></a>Ashton Estates <small> -- a
							Morgantown residential community</small>
						<div class="btn-group btn-group-sm pull-right">
							<h4>
								Hello ${loggedInUserName}
								<button id="logoutButton" class="btn btn-xs btn-logout">Logout</button>
							</h4>
						</div>
					</h1>
				</div>

				<div class="row margintop20">
					<div class="col-md-10">
						<div class="row">
							<div class="col-md-12">
								<div class="content">
									<div class="marginbottom20 bg-danger">${errorMessage}</div>
									<form:form method="post" action="${processEvent}" modelAttribute="eventForm">
										<fieldset>
											<legend>Upcoming Event</legend>
											<div class="form-group">
												<input type="text" name="title" id="title" required class="form-control" placeholder="Title" autofocus value="${modifyEvent.title}" />
											</div>
											<div class="form-group">
												<div class='input-group date' id='datetimepicker1'>
													<input type="text" name="eventDate" id="eventDate" class="form-control" placeholder="Event Date/Time" value="${modifyEvent.eventDate}" /> <span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"></span>
													</span>
												</div>
											</div>
											<div class="form-group">
												<textarea name="description" id="description" required class="form-control" rows="3" placeholder="Description">${modifyEvent.description}</textarea>
											</div>
											<input id="id" name="id" type="hidden" value="${modifyEvent.id}">
											<button type="submit" name="go" class="btn btn-success">Submit</button>
											<button id="cancelButton" class="btn btn-alert">Cancel</button>
										</fieldset>
									</form:form>
								</div>
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
								<a href="${faq}">Public Documents</a>
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
					<p id="footer-info" class="pull-right">© 2016 William Hunt | Morgantown, WV 26508</p>
				</div>
			</div>
		</footer>

	</div>

	<script src="${resources}/js/jquery-3.1.0.min.js"></script>
	<script src="${resources}/js/bootstrap.min.js"></script>
	<script src="${resources}/js/moment.js"></script>
	<script src="${resources}/js/bootstrap-datetimepicker.min.js"></script>
	<script src="${resources}/js/jquery.dataTables.min.js"></script>

	<script>
		$(document).ready(function() {
			$('#datetimepicker1').datetimepicker();
			 
			$('#tooltip1').tooltip();

			$("#logoutButton").click(function() {
				window.location.href = "${logout}"
			});

			$("#cancelButton").click(function() {
				window.location.href = "${editEvents}"
			});

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
	</script>
</body>
</html>
