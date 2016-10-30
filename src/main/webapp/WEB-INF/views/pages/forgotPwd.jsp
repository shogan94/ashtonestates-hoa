<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/processForgotPwd" var="requestReset" />

<div class="row">
	<div class="col-md-12">
		<div class="content">
			<h3>Forgot Password</h3>

			<div class="marginbottom20 bg-danger">${errorMessage}</div>

			<form:form method="post" action="${requestReset}">

				<div class="form-group">
					<input type="email" name="email" required class="form-control" placeholder="Email address" />
				</div>

				<button type="submit" name="go" class="btn btn-primary loginBtn">Request Password</button>
				<button type="button" name="cancel" class="btn btn-primary loginBtn" id="cancelButton">Cancel</button>
			</form:form>
		</div>
	</div>
</div>
