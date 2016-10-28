<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<c:url value="/resources" var="resources" />
<c:url value="/" var="home" />
<c:url value="/faq" var="faq" />
<c:url value="/residents" var="residents" />
<c:url value="/admin/editUser/" var="editUser" />
<c:url value="/admin/removeUser/" var="removeUser" />
<c:url value="/admin/changePwd/" var="changePwd" />
<c:url value="/upcomingEvents" var="upcomingEvents" />
<c:url value="/admin" var="admin" />
<c:url value="/logout" var="logout" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Ashton Estates - Edit Users</title>
<meta name="description" content="Ashton Estates" />
<meta name="author" content="William Hunt" />
<link href="${resources}/css/bootstrap.min.css" rel="stylesheet" />
<link href="${resources}/css/font-awesome.min.css" rel="stylesheet">
<link href="${resources}/css/style.css" rel="stylesheet" />
<link href="${resources}/css/jquery.dataTables.min.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h1>
						<a href="${home}"><i class="fa fa-home" id="tooltip1" data-toggle="tooltip" data-placement="top" title="Return to Homepage"></i></a>Ashton Estates <small> -- a
							Morgantown residential community</small>
						<div class="btn-group btn-group-sm pull-right">
							<h4>
								Hello ${loggedInUserName}
								<button id="logoutButton" class="btn btn-xs btn-logout">Logout</button>
							</h4>
						</div>
					</h1>
				</div>

				<div class="row margintop20">
					<div class="col-md-10">
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
					</div>
					<div class="col-md-2">
						<div class="sidebar">
							<h4>
								<a href="${residents}">Residents</a>
							</h4>
						</div>
						<div class="sidebar">
							<h4>
								<a href="${faq}">FAQs</a>
							</h4>
						</div>
						<div class="sidebar">
							<h4>
								<a href="${faq}">Public Documents</a>
							</h4>
						</div>
						<div class="sidebar">
							<h4>
								<a href="${upcomingEvents}">Upcoming Events</a>
							</h4>
						</div>
						<sec:authorize access="hasRole('ADMIN')">
							<div class="sidebar admin">
								<h4>
									<a href="${admin}">Administrator</a>
								</h4>
							</div>
						</sec:authorize>
					</div>
				</div>
			</div>
		</div>

		<footer id="main-footer" class="margintop20">
			<div id="footer-bottom">
				<div class="container clearfix">
					<ul class="social-icons">
						<li class="social-icon-facebook"><a href="https://www.facebook.com/groups/ashtonestates/" target="_blank"><i class="fa fa-facebook-square"></i></a></li>
						<li class="social-icon-nextdoor"><a href="https://ashtonestates.nextdoor.com/neighborhood_feed/" target="_blank"><i class="fa fa-home"></i></a></li>
					</ul>
					<p id="footer-info" class="pull-right">© 2016 William Hunt | Morgantown, WV 26508</p>
				</div>
			</div>
		</footer>

	</div>

	<script src="${resources}/js/jquery-3.1.0.min.js"></script>
	<script src="${resources}/js/bootstrap.min.js"></script>
	<script src="${resources}/js/jquery.dataTables.min.js"></script>

	<script>
		$(document).ready(function() {
			$('[data-toggle="tooltip"]').tooltip(); 

			$("#logoutButton").click(function() {
			window.location.href = "${logout}"
			});
			
			$('#uTable').DataTable({
				"paging" : false,
				"ordering" : true,
				"info" : false,
				"searching" : false,
				"order" : [ [ 2, "asc" ] ],
				"columnDefs": [ {
				      "targets"  : 0,
				      "orderable": false,
				    }]
			});
		});
		
		function editUser(id) {
			window.location.href = "${editUser}" + id;
		};

		function removeUser(id) {
			window.location.href = "${removeUser}" + id;
		};
		
		function changePwd(id) {
			window.location.href = "${changePwd}" + id;
		};
		
	</script>
</body>
</html>
