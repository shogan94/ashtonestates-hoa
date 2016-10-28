<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/register" var="register" />
<c:url value="/forgotPwd" var="forgotPwd" />
<c:url value="/login" var="login" />

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
						<c:redirect url="/pendingApproval" />
					</c:if>
					<p>
						<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
					</p>
				</c:if>
			</div>
			<div class="marginbottom20 bg-success">
				<c:if test="${param.logout != null}">
					<p>You have been logged out.</p>
				</c:if>
			</div>

			<div class="marginbottom20 bg-danger">${errorMessage}</div>

			<form:form method="post" action="${login}" modelAttribute="loginForm">

				<div class="form-group">
					<input type="email" name="email" required class="form-control" placeholder="Email address" />
				</div>

				<div class="input-group">
					<input type="password" name="password" required class="form-control" placeholder="Password" /> <span class="input-group-btn">
						<button class="btn btn-default" type="button" id="forgotBtn" data-toggle="tooltip" data-placement="top" title="Forgot password ?">
							<span class="glyphicon glyphicon-question-sign text-danger" aria-hidden="true"></span>
						</button>
					</span>
				</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

				<button type="submit" name="go" class="btn btn-primary loginBtn">Login Now</button>
			</form:form>
			<div class="margintop20">
				Not yet an Ashton member ? <a href="${register}">Register Now</a>
			</div>
		</div>
	</div>
</div>