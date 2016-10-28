<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<table id="uTable" class="table table-hover">
		<thead>
			<tr>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Street</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="u">
				<tr>
					<td><c:out value="${u.firstName}" /></td>
					<td><c:out value="${u.lastName}" /></td>
					<td><c:out value="${u.address}" /></td>
					<td><a href="mailto:${u.email}" class="btn btn-email" role="button"><c:out value="${u.email}" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
