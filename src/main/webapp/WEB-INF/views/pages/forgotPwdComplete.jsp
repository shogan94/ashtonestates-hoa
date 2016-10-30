<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/" var="home" />

<div class="row">
	<div class="col-md-12">
		<div class="content">
			<h3>Forgot Password</h3>
			<div class="alert alert-info">
				<p>If there is an account associated with the email provided, you should receive an email with instructions to reset your password.</p>
				<p>If you know you have an account with that email address and you do not receive the reset email, please contact an HOA board member.</p>
			</div>
			<div>
				<a href="${home}" class="btn btn-primary loginBtn" id="homeButton">Home</a>
			</div>
		</div>
	</div>
</div>
