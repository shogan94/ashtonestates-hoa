<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<c:url value="/resources" var="resources" />
<c:url value="/" var="home" />
<c:url value="/faq" var="faq" />
<c:url value="/residents" var="residents" />
<c:url value="/residents/processChangePwd" var="processChangePwd" />
<c:url value="/publicDocs" var="publicDocs" />
<c:url value="/upcomingEvents" var="upcomingEvents" />
<c:url value="/admin" var="admin" />
<c:url value="/logout" var="logout" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Ashton Estates - Change Pwd</title>
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
									<h2>Change password for: ${loggedInUserName}</h2>

									<div class="marginbottom20 bg-danger">${errorMessage}</div>
									<form:form method="post" action="${processChangePwd}" modelAttribute="changePwdForm">
										<div class="form-group">
											<input type="hidden" name="userId" value="${userId}" />
										</div>

										<div class="form-group">
											<input type="password" name="password" required class="form-control" placeholder="Password" />
										</div>
										<div class="form-group">
											<input type="password" name="confirmPassword" required class="form-control" placeholder="Confirm Password" />
										</div>

										<button type="submit" name="go" class="btn btn-primary loginBtn">Change Pwd</button>
										<button type="button" name="cancel" class="btn btn-primary loginBtn" id="cancelButton">Cancel</button>
									</form:form>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="alert alert-info">Please note that you will need to re-login after you change your password.</div>
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
					<p id="footer-info" class="pull-right">© 2016 William Hunt | Morgantown, WV 26508</p>
				</div>
			</div>
		</footer>

	</div>

	<script src="${resources}/js/jquery-3.1.0.min.js"></script>
	<script src="${resources}/js/bootstrap.min.js"></script>

	<script>
		$(document).ready(function() {
			$('#tooltip1').tooltip();

			$("#logoutButton").click(function() {
				window.location.href = "${logout}"
			});
			
			$("#cancelButton").click(function() {
				window.location.href = "${residents}"
			});
		});
	</script>
</body>
</html>
