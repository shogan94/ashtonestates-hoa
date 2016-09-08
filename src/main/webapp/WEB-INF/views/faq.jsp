<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<c:url value="/resources" var="resources" />
<c:url value="/" var="home" />
<c:url value="/faq" var="faq" />
<c:url value="/residents" var="residents" />
<c:url value="/logout" var="logout" />
<c:url value="/login" var="login" />
<c:url value="/publicDocs" var="publicDocs" />
<c:url value="/upcomingEvents" var="upcomingEvents" />
<c:url value="/admin" var="admin" />


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Ashton Estates - FAQ</title>
<meta name="description" content="Ashton Estates" />
<meta name="author" content="William Hunt" />
<link href="${resources}/css/bootstrap.min.css" rel="stylesheet" />
<link href="${resources}/css/font-awesome.min.css" rel="stylesheet">
<link href="${resources}/css/style.css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h1>
						<a href="${home}"><i class="fa fa-home" id="tooltip1" data-toggle="tooltip" data-placement="top" title="Return to Homepage"></i></a>Ashton Estates <small> -- a
							Morgantown residential community</small>
						<sec:authorize access="isAuthenticated()">
							<div class="btn-group btn-group-sm pull-right">
								<h4>
									Hello ${loggedInUserName}
									<button id="logoutButton" class="btn btn-xs btn-logout">Logout</button>
								</h4>
							</div>
						</sec:authorize>
						<sec:authorize access="isAnonymous()">
							<div class="btn-group btn-group-sm pull-right">
								<button id="loginButton" class="btn btn-xs btn-logout">Login</button>
							</div>
						</sec:authorize>
					</h1>
				</div>

				<div class="row margintop20">
					<div class="col-md-10">
						<div class="row">
							<div class="col-md-12">
								<div class="content">
									<h3>Frequently Asked Questions</h3>

									<p>
										If you have a question not covered below, <span style="color: #333333;"><strong><a style="color: #333333;" title="Contact an Ashton Estates HOA officer"
												href="#">contact an Ashton Estates HOA officer</a></strong></span>.
									</p>

									<dl id="faqs">
										<dt>What is the Ashton Estates Homeowners Association?</dt>
										<dd>The Ashton Estates Homeowners Association (HOA) is a non-profit organization composed of homeowners in the Ashton Estates community. You automatically become a
											member when you purchase an Aston Estates home or townhome.</dd>

										<dt>What are the Covenants and By-laws of the Ashton Estates HOA?</dt>
										<dd>
											The Declaration of Covenants are the <span style="color: #333333;"><strong><a style="color: #333333;" title="Governing Documents" href="#">governing
														documents</a></strong></span> of our association. This document gives the association its power and authority and is recoded against each lot. The owner of each lot is therefore subject
											to the terms and conditions it contains. It is the guideline that all community operations follow.
										</dd>
										<dd>In addition to the Covenants, we have By-laws. While the Covenants bestow the authority of the association, the By-laws detail how that authority is to be
											administered. This document has more specific guidelines regarding the day-to-day operation and management of the association.</dd>
										<dd>Owning a home in an association provides many advantages and benefits, but also comes with some boundaries on individual choices. While some restrictions may
											seem inconvenient, they are necessary to maintain consistency in the community and to help enhance the property values of everyone's homes.</dd>

										<dt>How do I pay my assessments?</dt>
										<dd>HOA dues are due the ~TBD~. For 2016, dues are $850/year.</dd>

										<dt>When is the Annual Meeting?</dt>
										<dd>The annual meeting is usually ~TBD~. Once the date has been officially set, it will be posted in the 'Upcoming Meetings' section of the home page. As with
											regular Board meetings, all homeowners are encouraged to attend. We will discuss the previous year's projects, as well as plans for the upcoming year.</dd>

										<dt>How can I get exterior changes to my home approved?</dt>
										<dd>
											Ashton Estates has a Building Committee which handles review of all new construction and exterior renovation requests. Please refer to the <a title="Building Commitee"
												href="#"><strong><span style="color: #333333;">Building Commitee</span></strong></a> page on this website to know how to contact the committee.
										<dt>How can I use the Pavillion?</dt>
										<dd>The Pavillion is a wonderful resource for our community. Any homeowner can reserve the Pavillion for a private function, party or family gathering for no charge.
											We ask that anyone who uses this facility clean it afterwards and leave it in the condition they found it. Please contact John Rodgers to reserve.</dd>

										<dt>What are my responsibilities as a pet owner?</dt>
										<dd>Although we love our pets, it is important to remember that not everyone wants one. Dog and cat owners are responsible to keep their pets from infringing on
											others' enjoyment of the community. Dogs must be on leash at all times within Ashton Estates and it is the responsibility of the pet owner to pick up all solid waste
											immediately.</dd>

										<dt>How do I contact other homeowners at Aston Estates?</dt>
										<dd>
											Our website is currently a public entity to allow not only homeowners information about our community, but others who are interested in our community and/or might want
											to purchase a home for sale. Given this, our homeowner's contact list is distributed only to current homeowners. The Manager updates this list periodically and it can be
											downloaded from the <span style="color: #333333;"><strong><a style="color: #333333;" title="Residents Only" href="#">Residents Only</a></strong></span> section after
											successful login to the website.
										</dd>
									</dl>
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

	<script>
		$(document).ready(function() {
			$('#tooltip1').tooltip();

			$("#logoutButton").click(function() {
				window.location.href = "${logout}"
			});
			
			$("#loginButton").click(function() {
				window.location.href = "${login}"
			});

		});
	</script>
</body>
</html>
