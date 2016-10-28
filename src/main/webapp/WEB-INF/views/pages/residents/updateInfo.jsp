<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/residents/processUpdateInfo" var="processUpdateInfo" />

<div class="row">
	<div class="col-md-12">
		<div class="content">
			<h2>Update Information for: ${loggedInUserName}</h2>

			<div class="marginbottom20 bg-danger">${errorMessage}</div>
			<form:form method="post" action="${processUpdateInfo}" modelAttribute="residentInfoForm">
				<div class="form-group">
					<input type="email" name="email" required class="form-control" placeholder="Email" value="${residentInfoForm.email}" />
				</div>
				<div class="form-group">
					<input type="text" name="firstName" required class="form-control" placeholder="First name" value="${residentInfoForm.firstName}" />
				</div>
				<div class="form-group">
					<input type="text" name="lastName" required class="form-control" placeholder="Last name" value="${residentInfoForm.lastName}" />
				</div>
				<div class="form-group">
					<input type="text" name="address" required class="form-control" placeholder="Street Address" value="${residentInfoForm.address}" />
				</div>

				<button type="submit" name="go" class="btn btn-primary loginBtn">Update Information</button>
				<button type="button" name="cancel" class="btn btn-primary loginBtn" id="cancelButton">Cancel</button>
			</form:form>
		</div>
	</div>
</div>
