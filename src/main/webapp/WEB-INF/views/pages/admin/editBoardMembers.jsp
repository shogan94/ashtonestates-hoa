<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-md-12">
		<div class="content">
			<h3>Master Association Board Members</h3>
			<button class="btn btn-success" onclick="addMasterMember()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
			</button>
			<table id="mTable" class="table table-bordered table-hover">
				<thead>
					<tr>
						<th></th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Member Role</th>
					</tr>
				</thead>
				<c:forEach items="${masterMembers}" var="masterMember">
					<tr>
						<td>
							<div class="btn-group">
								<button class="btn btn-success btn-xs" onclick="editMasterMember(${masterMember.getId()})">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								</button>
								&nbsp;
								<button class="btn btn-danger btn-xs" onclick="removeMasterMember(${masterMember.getId()})">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								</button>
							</div>
						</td>
						<td>${masterMember.getFirstName()}</td>
						<td>${masterMember.getLastName()}</td>
						<td>${masterMember.getEmail()}</td>
						<td>${masterMember.getMemberRole()}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-12">
		<div class="content">
			<h3>Home Owner Board Members</h3>
			<button class="btn btn-success" onclick="addHomeMember()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
			</button>
			<table id="hTable" class="table table-bordered table-hover">
				<thead>
					<tr>
						<th></th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>
				</thead>
				<c:forEach items="${homeMembers}" var="homeMember">
					<tr>
						<td>
							<div class="btn-group">
								<button class="btn btn-success btn-xs" onclick="editHomeMember(${homeMember.getId()})">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								</button>
								&nbsp;
								<button class="btn btn-danger btn-xs" onclick="removeHomeMember(${homeMember.getId()})">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								</button>
							</div>
						</td>
						<td>${homeMember.getFirstName()}</td>
						<td>${homeMember.getLastName()}</td>
						<td>${homeMember.getEmail()}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-12">
		<div class="content">
			<h3>Townhome Board Members</h3>
			<button class="btn btn-success" onclick="addTownhomeMember()">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
			</button>
			<table id="tTable" class="table table-bordered table-hover">
				<thead>
					<tr>
						<th></th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
					</tr>
				</thead>
				<c:forEach items="${townhomeMembers}" var="townhomeMember">
					<tr>
						<td>
							<div class="btn-group">
								<button class="btn btn-success btn-xs" onclick="editTownhomeMember(${townhomeMember.getId()})">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
								</button>
								&nbsp;
								<button class="btn btn-danger btn-xs" onclick="removeTownhomeMember(${townhomeMember.getId()})">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								</button>
							</div>
						</td>
						<td>${townhomeMember.getFirstName()}</td>
						<td>${townhomeMember.getLastName()}</td>
						<td>${townhomeMember.getEmail()}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>