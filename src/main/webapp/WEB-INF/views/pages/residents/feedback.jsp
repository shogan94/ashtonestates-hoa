<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/processFeedback" var="processFeedback" />
<c:url value="/residents" var="cancel" />

<div class="row">
	<div class="col-md-12">
		<div class="content">

			<form:form id="regForm" method="post" action="${processFeedback}" modelAttribute="feedbackForm" data-toggle="validator">
			
				<h2>Feedback / Comments / Thoughts / Issues</h2>

				<div class="form-group has-feedback">
						<div class="input-group">
							<textarea required class="form-control textarea" rows="4" style="width:100%;"></textarea>
						</div>
					</div>


				<div class="form-group">
					<div class="input-group">
						<div class="checkbox">
							<label> <input type="checkbox" id="checkboxAllMaster" value="all_master" checked="checked">Master Association Members
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<div class="checkbox">
							<label> <input type="checkbox" id="checkboxAllHome" value="all_home">All Home Owner Board Members
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<div class="checkbox">
							<label> <input type="checkbox" id="checkboxAllTownhome" value="all_tomehome">All Townhome Ownder Board Members
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<div class="checkbox">
							<label> <input type="checkbox" id="checkboxPresident" value="president">President</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<div class="checkbox">
							<label> <input type="checkbox" id="checkboxSecretary" value="secretary">Secretary</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<div class="checkbox">
							<label> <input type="checkbox" id="checkboxTreasurer" value="treasurer">Treasurer</label>
						</div>
					</div>
				</div>

				<button type="submit" id="submitButton" name="submit" class="btn btn-primary loginBtn">Submit Feedback</button>
				<button type="button" class="btn loginBtn" id="cancelButton">Cancel</button>
			</form:form>
		</div>
	</div>
</div>
