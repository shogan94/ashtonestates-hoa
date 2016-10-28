<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/faq" var="faq" />
<c:url value="/residents" var="residents" />
<c:url value="/publicDocs" var="publicDocs" />
<c:url value="/upcomingEvents" var="upcomingEvents" />
<c:url value="/admin" var="admin" />

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
		<a href="${publicDocs}">Public Documents</a>
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
