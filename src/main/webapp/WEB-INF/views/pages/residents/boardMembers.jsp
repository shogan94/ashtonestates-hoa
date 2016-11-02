<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<div class="col-md-12 text-center center-block">
		<div class="publicInfo">
			<h2>Contact Information</h2>
			<div class="row">
				<div class="col-md-6 text-center center-block">
					<div class="contactInfo">
						<h3>Master Association Board</h3>
						<ul class="list-group">
							<c:forEach var="member" items="${masterMembers}">
								<li class="list-group-item"><span class="badge"><a href="mailto:${member.getEmail()}"><span class="glyphicon glyphicon-envelope"></span></a></span>
								<c:out value="${member.getMemberRole()} - ${member.getFirstName()} ${member.getLastName()}" /></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="col-md-6 text-center center-block">
					<div class="contactInfo">
						<h3>Building Committee Chair</h3>
						<ul class="list-group">
							<li class="list-group-item"><span class="badge"><a href="mailto:Jacki.marino@ gmail.com"><span class="glyphicon glyphicon-envelope"></span></a></span>Jacki Marino</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 text-center center-block">
					<div class="contactInfo">
						<h3>Home Owners Board Members</h3>
						<ul class="list-group">
							<c:forEach var="member" items="${homeMembers}">
								<li class="list-group-item"><span class="badge"><a href="mailto:${member.getEmail()}"><span class="glyphicon glyphicon-envelope"></span></a></span>
								<c:out value="${member.getFirstName()} ${member.getLastName()}" /></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<div class="col-md-6 text-center center-block">
					<div class="contactInfo">
						<h3>Townhome Owners Board Members</h3>
						<ul class="list-group">
							<c:forEach var="member" items="${townhomeMembers}">
								<li class="list-group-item"><span class="badge"><a href="mailto:${member.getEmail()}"><span class="glyphicon glyphicon-envelope"></span></a></span>
								<c:out value="${member.getFirstName()} ${member.getLastName()}" /></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
