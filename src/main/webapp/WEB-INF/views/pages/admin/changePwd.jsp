<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/admin/processChangePwd" var="processChangePwd" />

<div class="row">
	<div class="col-md-12">
		<div class="content">
			<h2>
				Change password for:
				<c:out value="${userFN} ${userLN}" />
			</h2>

			<div class="marginbottom20 bg-danger">${errorMessage}</div>
			<form:form method="post" action="${processChangePwd}" modelAttribute="changePwdForm">
				<div class="form-group">
					<input type="hidden" name="userId" value="${userId}" />
				</div>

				<div class="form-group">
					<input type="password" name="password" required class="form-control" placeholder="Password" />
				</div>
				<div class="form-group">
					<input type="password" name="confirmPassword" required class="form-control" placeholder="Confirm Password" />
				</div>

				<button type="submit" name="go" class="btn btn-primary loginBtn">Change Pwd</button>
				<button type="button" name="cancel" class="btn btn-primary loginBtn" id="cancelButton">Cancel</button>
			</form:form>
		</div>
	</div>
</div>
