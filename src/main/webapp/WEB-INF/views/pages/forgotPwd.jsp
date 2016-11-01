<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/processForgotPwd" var="requestReset" />

<div class="row">
	<div class="col-md-12">
		<div class="formcontent">
			<div class="marginbottom20 bg-danger">${errorMessage}</div>

			<div class="forminput">
				<form:form method="post" action="${requestReset}" data-toggle="validator">
					<h2>Forgot password?</h2>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="text-primary glyphicon glyphicon-envelope"></span>
							</div>
							<input type="email" name="email" placeholder="Email address" required class="form-control" data-error="Enter a correctly formatted email" />
						</div>
						<div class="help-block with-errors"></div>
					</div>

					<button type="submit" name="go" class="btn btn-primary loginBtn">Request Password</button>
					<button type="button" name="cancel" class="btn loginBtn" id="cancelButton">Cancel</button>
				</form:form>
			</div>
		</div>
	</div>
</div>
