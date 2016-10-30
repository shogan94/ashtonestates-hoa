<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/processRegistration" var="processRegistration" />

<div class="row">
	<div class="col-md-12">
		<div class="content">
			<h2>Residents Registration</h2>

			<div class="marginbottom20 bg-danger">${errorMessage}</div>
			<form:form method="post" action="${processRegistration}" modelAttribute="registerForm">

				<div class="form-group">
					<input type="email" name="email" required class="form-control" placeholder="Email" value="${registerForm.email}" />
				</div>
				<div class="form-group">
					<input type="password" name="password" required class="form-control" placeholder="Password" />
				</div>
				<div class="form-group">
					<input type="password" name="confirmPassword" required class="form-control" placeholder="Confirm Password" />
				</div>
				<div class="form-group">
					<input type="text" name="firstName" required class="form-control" placeholder="First name" value="${registerForm.firstName}" />
				</div>
				<div class="form-group">
					<input type="text" name="lastName" required class="form-control" placeholder="Last name" value="${registerForm.lastName}" />
				</div>
				<div class="form-group">
					<input type="text" name="address" required class="form-control" placeholder="Street Address" value="${registerForm.address}" />
				</div>

				<button type="submit" name="go" class="btn btn-primary loginBtn">Submit Registration</button>
				<button type="button" name="cancel" class="btn btn-primary loginBtn" id="cancelButton">Cancel</button>
			</form:form>
		</div>
	</div>
</div>
