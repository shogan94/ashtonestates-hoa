<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/admin/processTownhomeMember" var="processMember" />

<div class="row">
	<div class="col-md-12">
		<div class="content">
			<div class="marginbottom20 bg-danger">${errorMessage}</div>
			<form:form method="post" action="${processMember}" modelAttribute="memberForm" data-toggle="validator">
				<fieldset>
					<legend>Townhome Owner Board Member</legend>
					
					<div class="form-group has-feedback">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="text-primary glyphicon glyphicon-envelope"></span>
							</div>
							<input type="email" name="email" placeholder="Email address" required class="form-control" value="${member.email}" data-error="Enter a correctly formatted email" />
						</div>
						<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						<div class="help-block with-errors"></div>
					</div>

					<div class="form-group has-feedback">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="text-primary glyphicon glyphicon-home"></span>
							</div>
							<input type="text" name="firstName" placeholder="First name" required class="form-control" value="${member.firstName}" />
						</div>
						<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						<div class="help-block with-errors"></div>
					</div>

					<div class="form-group has-feedback">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="text-primary glyphicon glyphicon-home"></span>
							</div>
							<input type="text" name="lastName" placeholder="Last name" required class="form-control" value="${member.lastName}" />
						</div>
						<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						<div class="help-block with-errors"></div>
					</div>
					
					<input id="id" name="id" type="hidden" value="${member.id}">
					<button type="submit" name="go" class="btn btn-success">Submit</button>
					<button id="cancelButton" class="btn">Cancel</button>
				</fieldset>
			</form:form>
		</div>
	</div>
</div>
