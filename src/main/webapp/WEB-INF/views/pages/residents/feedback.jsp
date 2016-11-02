<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/processFeedback" var="processFeedback" />

<div class="row">
	<div class="col-md-12">
		<div class="content">

			<form:form id="regForm" method="post" action="${processFeedback}" modelAttribute="feedbackForm" data-toggle="validator">

				<h2>Feedback / Comments / Thoughts / Issues</h2>
				<div class="form-group has-feedback">
					<div class="input-group">
						<textarea required id="feedback" name="feedback" class="form-control textarea" rows="4" style="width: 100%;"></textarea>
					</div>
				</div>

				<hr />
				<div>
					<h4>Send this feedback to one or more of the following:</h4>
				</div>

				<div class="form-group">
					<div class="input-group">
						<div class="checkbox">
							<form:checkbox path="masterboard" checked="true"/>Master Association Board Members
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<div class="checkbox">
							<form:checkbox path="homeboard" />Home Owner Board Members
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<div class="checkbox">
							<form:checkbox path="townboard" />Townhome Owner Board Members
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<div class="checkbox">
							<form:checkbox path="president" />President
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<div class="checkbox">
							<form:checkbox path="secretary" />Secretary
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<div class="checkbox">
							<form:checkbox path="treasurer" />Treasurer
						</div>
					</div>
				</div>

				<button type="submit" id="submitButton" name="submit" class="btn btn-primary loginBtn">Submit Feedback</button>
				<button type="button" class="btn loginBtn" id="cancelButton">Cancel</button>
			</form:form>
		</div>
	</div>
</div>
