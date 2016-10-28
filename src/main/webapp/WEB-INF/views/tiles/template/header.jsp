<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/logout" var="logout" />
<c:url value="/login" var="login" />
<c:url value="/" var="home" />

<div class="page-header">
	<h1>
		<a href="${home}"><i class="fa fa-home" id="tooltip1" data-toggle="tooltip" data-placement="top" title="Return to Homepage"></i></a>Ashton Estates <small> -- a Morgantown
			residential community</small>
		<sec:authorize access="isAuthenticated()">
			<div class="btn-group btn-group-sm pull-right">
				<h4>
					Hello ${loggedInUserName} <a href="${logout}" id="logoutButton" class="btn btn-xs btn-logout">Logout</a>
				</h4>
			</div>
		</sec:authorize>
		<sec:authorize access="isAnonymous()">
			<div class="btn-group btn-group-sm pull-right">
				<a href="${login}" id="loginButton" class="btn btn-xs btn-logout">Login</a>
			</div>
		</sec:authorize>
	</h1>
</div>