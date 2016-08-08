<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/resources" var="resources" />
<c:url value="/" var="home" />
<c:url value="/faq" var="faq" />
<c:url value="/residents" var="residents" />
<c:url value="/register" var="register" />
<c:url value="/forgotPwd" var="forgotPwd" />
<c:url value="/login" var="processLogin" />
<c:url value="/publicDocs" var="publicDocs" />
<c:url value="/upcomingEvents" var="upcomingEvents" />
<c:url value="/admin" var="admin" />


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Ashton Estates - Login</title>
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
					</h1>
				</div>

				<div class="row margintop20">
					<div class="col-md-10">
						<div class="row">
							<div class="col-md-12">
								<div class="content">
									<h2>Residents Login</h2>

									<div class="marginbottom20 bg-danger">
										<c:if test="${param.error != null}">
											<c:if test="${SPRING_SECURITY_LAST_EXCEPTION.message eq 'Bad credentials'}">
												<p>Username/Password entered is incorrect.</p>
											</c:if>
											<c:if test="${SPRING_SECURITY_LAST_EXCEPTION.message eq 'User is disabled'}">
												<% response.sendRedirect("/faq"); %>
											</c:if>
											<p>
												<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
											</p>
										</c:if>
										<c:if test="${param.logout != null}">
											<p>You have been logged out.</p>
										</c:if>
									</div>

									<form:form method="post" action="${processLogin}" modelAttribute="loginForm">

										<div class="form-group">
											<input type="email" name="email" required class="form-control" placeholder="Email address" autofocus />
										</div>

										<div class="input-group">
											<input type="password" name="password" required class="form-control" placeholder="Password" /> <span class="input-group-btn">
												<button class="btn btn-default" type="button" id="forgotBtn" data-toggle="tooltip" data-placement="top" title="Forgot password ?">?</button>
											</span>
										</div>

										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

										<button type="submit" name="go" class="btn btn-primary loginBtn">Login Now</button>
									</form:form>
									<div class="margintop20">
										Not yet a member ? <a href="${register}">Register Now</a>
									</div>
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
					<p id="footer-info" class="pull-right">© 2016 William Hunt | Morgantown, WV 26508</p>
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
			$('#forgotBtn').tooltip();

			$("#forgotBtn").click(function() {
				window.location.href = "${forgotPwd}"
			});
		});
	</script>
</body>
</html>
