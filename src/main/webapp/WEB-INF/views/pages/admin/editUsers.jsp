<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-md-12">
		<div class="content">
			<h3>Edit Users</h3>
			<table id="uTable" class="table table-bordered table-hover">
				<thead>
					<tr>
						<th></th>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Address</th>
						<th>Email</th>
						<th>Phone</th>
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
								&nbsp;
								<button class="btn btn-info btn-xs" data-toggle="modal" data-target="#myModal" data-userid="${user.getId()}" id="infoTooltip" data-toggle="tooltip" data-placement="top" title="View More Info">
									<span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
								</button>
							</div>
						</td>
						<td>${user.getFirstName()}</td>
						<td>${user.getLastName()}</td>
						<td>${user.getAddress()}</td>
						<td>${user.getEmail()}</td>
						<td>${user.getPhone()}</td>
						<td>${user.getRole()}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">User Details</h4>
      </div>
      <div class="modal-body replace-body">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>
