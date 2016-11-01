<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/register" var="register" />
<c:url value="/forgotPwd" var="forgotPwd" />
<c:url value="/login" var="login" />

<div class="row">
	<div class="col-md-12">
		<div class="formcontent">

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

			<div class="forminput">
				<form:form method="post" action="${login}" modelAttribute="loginForm" data-toggle="validator">
					<h2>Please sign in</h2>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="text-primary glyphicon glyphicon-envelope"></span>
							</div>
							<input type="email" name="email" placeholder="Email address" required class="form-control" data-error="Enter a correctly formatted email" />
						</div>
						<div class="help-block with-errors"></div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="text-primary glyphicon glyphicon-lock"></span>
							</div>
							<input type="password" name="password" placeholder="Password" required class="form-control" />
						</div>
					</div>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<button type="submit" name="go" class="btn btn-block btn-success">Sign in</button>
					<a href="${forgotPwd}" class="btn btn-block btn-default">Forgot password?</a> <a href="${register}" class="btn btn-block btn-default">Need an account?</a>
				</form:form>
			</div>
		</div>
	</div>
</div>