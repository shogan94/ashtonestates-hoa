<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<table id="eTable" class="table table-hover">
		<caption>Upcoming Events</caption>
		<thead>
			<tr>
				<th>Date</th>
				<th>Title</th>
				<th>Description</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${events}" var="event">
				<tr>
					<td><c:out value="${event.eventDate}" /></td>
					<td><c:out value="${event.title}" /></td>
					<td><c:out value="${event.description}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
