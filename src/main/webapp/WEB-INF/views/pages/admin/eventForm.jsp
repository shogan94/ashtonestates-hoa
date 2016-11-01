<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:url value="/admin/processEvent" var="processEvent" />

<div class="row">
	<div class="col-md-12">
		<div class="content">
			<div class="marginbottom20 bg-danger">${errorMessage}</div>
			<form:form method="post" action="${processEvent}" modelAttribute="eventForm">
				<fieldset>
					<legend>Upcoming Event</legend>
					
					<div class="form-group">
						<input type="text" name="title" id="title" required class="form-control" placeholder="Title" autofocus value="${modifyEvent.title}" />
						<div class="help-block with-errors"></div>
					</div>
					
					<div class="form-group">
						<div class='input-group date' id='datetimepicker1'>
							<input type="text" name="eventDate" id="eventDate" class="form-control" placeholder="Event Date/Time" value="${modifyEvent.eventDate}" /> <span class="input-group-addon">
								<span class="glyphicon glyphicon-calendar"></span>
							</span>
						</div>
						<div class="help-block with-errors"></div>
					</div>
					
					<div class="form-group">
						<textarea name="description" id="description" required class="form-control" rows="3" placeholder="Description">${modifyEvent.description}</textarea>
						<div class="help-block with-errors"></div>
					</div>
					
					<input id="id" name="id" type="hidden" value="${modifyEvent.id}">
					<button type="submit" name="go" class="btn btn-success">Submit</button>
					<button id="cancelButton" class="btn">Cancel</button>
				</fieldset>
			</form:form>
		</div>
	</div>
</div>
