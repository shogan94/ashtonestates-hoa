<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-md-12">
		<div class="content">
			<h3>Edit Users</h3>
			<table id="uTable" class="table table-bordered table-hover">
				<thead>
					<tr>
						<th></th>
						<th>First name</th>
						<th>Last name</th>
						<th>Address</th>
						<th>Email</th>
						<th>ApprovedBy</th>
						<th>Role</th>
					</tr>
				</thead>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>
							<div class="btn-group">
								<button class="btn btn-success btn-xs" onclick="editUser(${user.getId()})" id="editTooltip" data-toggle="tooltip" data-placement="top" title="Edit User">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								</button>
								&nbsp;
								<button class="btn btn-danger btn-xs" onclick="removeUser(${user.getId()})" id="deleteTooltip" data-toggle="tooltip" data-placement="top" title="Delete User">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								</button>
								&nbsp;
								<button class="btn btn-warning btn-xs" onclick="changePwd(${user.getId()})" id="pwdTooltip" data-toggle="tooltip" data-placement="top" title="Change User Pwd">
									<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
								</button>
							</div>
						</td>
						<td>${user.getFirstName()}</td>
						<td>${user.getLastName()}</td>
						<td>${user.getAddress()}</td>
						<td>${user.getEmail()}</td>
						<td>${user.getApprovedBy()}</td>
						<td>${user.getRole()}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>
