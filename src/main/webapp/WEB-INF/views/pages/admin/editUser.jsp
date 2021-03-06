<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/admin/processUpdateInfo" var="processUpdateInfo" />

<div class="row">
	<div class="col-md-12">
		<div class="formcontent">
			<h2>
				Update Information for:
				<c:out value="${userFN} ${userLN}" />
			</h2>

			<div class="marginbottom20 bg-danger">${errorMessage}</div>
			<div class="forminput">
				<form:form method="post" action="${processUpdateInfo}" modelAttribute="residentInfoForm" data-toggle="validator">
					<h2>
						Update Information for:
						<c:out value="${userFN} ${userLN}" />
					</h2>
					<div class="form-group">
						<input type="hidden" name="userId" value="${residentInfoForm.userId}" />
					</div>

					<div class="form-group has-feedback">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="text-primary glyphicon glyphicon-envelope"></span>
							</div>
							<input type="email" name="email" placeholder="Email address" required class="form-control" value="${residentInfoForm.email}" data-error="Enter a correctly formatted email" />
						</div>
						<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						<div class="help-block with-errors"></div>
					</div>

					<div class="form-group has-feedback">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="text-primary glyphicon glyphicon-home"></span>
							</div>
							<input type="text" name="firstName" placeholder="First name" required class="form-control" value="${residentInfoForm.firstName}" />
						</div>
						<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						<div class="help-block with-errors"></div>
					</div>

					<div class="form-group has-feedback">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="text-primary glyphicon glyphicon-home"></span>
							</div>
							<input type="text" name="lastName" placeholder="Last name" required class="form-control" value="${residentInfoForm.lastName}" />
						</div>
						<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						<div class="help-block with-errors"></div>
					</div>

					<div class="form-group has-feedback">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="text-primary glyphicon glyphicon-home"></span>
							</div>
							<input type="text" name="address" placeholder="Street Address" required class="form-control" value="${residentInfoForm.address}" />
						</div>
						<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						<div class="help-block with-errors"></div>
					</div>

					<div class="form-group has-feedback">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="text-primary glyphicon glyphicon-phone-alt"></span>
							</div>
							<input type="text" name="phone" placeholder="Phone" class="form-control" value="${residentInfoForm.phone}" pattern="^(\d{10})|(\d{3}-\d{3}-\d{4})|(\d{3}.\d{3}.\d{4})$" data-error="Format: 304-555-1212 or 304.555.1212 or 3045551212" />
						</div>
						<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						<div class="help-block with-errors"></div>
					</div>

					<div class="form-group has-feedback">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="text-primary glyphicon glyphicon-registration-mark"></span>
							</div>
							<label class="btn btn-default"> <input type="radio" required name="role" value="ADMIN" <c:if test="${residentInfoForm.role=='ADMIN'}">checked="checked"</c:if>>ADMIN
							</label> <label class="btn btn-default"> <input type="radio" required name="role" value="USER" <c:if test="${residentInfoForm.role=='USER'}">checked="checked"</c:if>>USER
							</label>
						</div>
						<span class="glyphicon form-control-feedback" aria-hidden="true"></span>
						<div class="help-block with-errors"></div>
					</div>

					<button type="submit" name="go" class="btn btn-primary loginBtn">Update Information</button>
					<button type="button" name="cancel" class="btn loginBtn" id="cancelButton">Cancel</button>
				</form:form>
			</div>
		</div>
	</div>
</div>

