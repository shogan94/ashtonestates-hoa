<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-md-12">
		<div class="content">
			<h3>Edit Events</h3>
			<button class="btn btn-success" onclick="addEvent()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
			</button>
			<table id="uTable" class="table table-bordered table-hover">
				<thead>
					<tr>
						<th></th>
						<th>Title</th>
						<th>Event Date</th>
						<th>Description</th>
					</tr>
				</thead>
				<c:forEach items="${events}" var="event">
					<tr>
						<td>
							<div class="btn-group">
								<button class="btn btn-success btn-xs" onclick="editEvent(${event.getId()})">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								</button>
								&nbsp;
								<button class="btn btn-danger btn-xs" onclick="removeEvent(${event.getId()})">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								</button>
							</div>
						</td>
						<td>${event.getTitle()}</td>
						<td>${event.getEventDate()}</td>
						<td>${event.getDescription()}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
