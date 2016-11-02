<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/processRegistration" var="processRegistration" />

<div class="row">
	<div class="col-md-12">
		<div class="formcontent">
			<div class="marginbottom20 bg-danger">${errorMessage}</div>

			<div class="forminput">

				<form:form id="regForm" method="post" action="${processRegistration}" modelAttribute="registerForm" data-toggle="validator">
					<h2>Resident registration</h2>

					<div class="form-group has-feedback">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="text-primary glyphicon glyphicon-envelope"></span>
							</div>
							<input type="email" name="email" placeholder="Email address" required class="form-control" value="${registerForm.email}" data-error="Enter a correctly formatted email" />
						</div>
						<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						<div class="help-block with-errors"></div>
					</div>
					
					<div class="form-group has-feedback">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="text-primary glyphicon glyphicon-lock"></span>
							</div>
							<input type="password" name="password" id="password" placeholder="Password" required class="form-control" />
						</div>
						<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						<div class="help-block with-errors"></div>
					</div>
					
					<div class="form-group has-feedback">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="text-primary glyphicon glyphicon-lock"></span>
							</div>
							<input type="password" name="confirmPassword" placeholder="Confirm Password" required class="form-control" data-match="#password" data-match-error="Passwords do not match" />
						</div>
						<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						<div class="help-block with-errors"></div>
					</div>
					
					<div class="form-group has-feedback">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="text-primary glyphicon glyphicon-user"></span>
							</div>
							<input type="text" name="firstName" placeholder="First name" required class="form-control" value="${registerForm.firstName}" />
						</div>
						<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
					</div>
					
					<div class="form-group has-feedback">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="text-primary glyphicon glyphicon-user"></span>
							</div>
							<input type="text" name="lastName" placeholder="Last name" required class="form-control" value="${registerForm.lastName}" />
						</div>
						<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
					</div>
					
					<div class="form-group has-feedback">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="text-primary glyphicon glyphicon-home"></span>
							</div>
							<input type="text" name="address" placeholder="Street Address" required class="form-control" value="${registerForm.address}" />
						</div>
						<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
					</div>
					
					<div class="form-group has-feedback">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="text-primary glyphicon glyphicon-phone-alt"></span>
							</div>
							<input type="text" name="phone" placeholder="Phone" class="form-control" value="${registerForm.phone}" pattern="^(\d{10})|(\d{3}-\d{3}-\d{4})|(\d{3}.\d{3}.\d{4})$" data-error="Format: 304-555-1212 or 304.555.1212 or 3045551212" />
						</div>
						<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						<div class="help-block with-errors"></div>
					</div>
					
					<div id="showSpinner" class="spinner"></div>
					<button type="submit" id="submitButton" name="submit" class="btn btn-primary loginBtn">Submit Registration</button>
					<button type="button" name="cancel" class="btn loginBtn" id="cancelButton">Cancel</button>
				</form:form>
			</div>
		</div>
	</div>
</div>
