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
					<c:choose>
						<c:when test="${SPRING_SECURITY_LAST_EXCEPTION.message eq 'Bad credentials'}">
							<p>Username/Password entered is incorrect.</p>
						</c:when>
						<c:when test="${SPRING_SECURITY_LAST_EXCEPTION.message eq 'User is disabled'}">
							<div class="row">
								<div class="col-md-12">
									<div class="content">
										<h3>Approval Pending</h3>

										<p>Your Ashton Estates website information has been submitted and awaiting approval.</p>

										<p>
											If you have a question or want to check on your pending status, <span style="color: #333333;"><strong><a style="color: #333333;"
													title="Contact an Ashton Estates board member" href="mailto:boardmembers@ashtonestates.org">contact a member of the Ashton Estates board <span
														class="glyphicon glyphicon-envelope"></span>
												</a></strong></span>
										</p>
										<p>Please include your email address and street address when questioning your approval status.</p>
									</div>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
						</c:otherwise>
					</c:choose>
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