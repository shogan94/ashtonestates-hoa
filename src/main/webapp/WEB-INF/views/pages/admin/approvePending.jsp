<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-md-12">
		<div class="content">
			<h3>Approve Pending Users (${pendingUsers.size()})</h3>
			<table id="uTable" class="table table-bordered table-hover">
				<thead>
					<tr>
						<th></th>
						<th>First name</th>
						<th>Last name</th>
						<th>Address</th>
					</tr>
				</thead>
				<c:forEach items="${pendingUsers}" var="user">
					<tr>
						<td>
							<div class="btn-group">
								<button class="btn btn-success btn-xs" onclick="approveUser(${user.getId()});" id="approveTooltip" data-toggle="tooltip" data-placement="top" title="Approve">
									<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
								</button>
								&nbsp;
								<button class="btn btn-danger btn-xs" onclick="rejectUser(${user.getId()});" id="rejectTooltip" data-toggle="tooltip" data-placement="top" title="Reject">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								</button>
							</div>
						</td>
						<td>${user.getFirstName()}</td>
						<td>${user.getLastName()}</td>
						<td>${user.getAddress()}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>