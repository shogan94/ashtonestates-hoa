<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url value="/resources" var="resources" />
<c:url value="/faq" var="faq" />
<c:url value="/residents" var="residents" />
<c:url value="/logout" var="logout" />
<c:url value="/publicDocs" var="publicDocs" />
<c:url value="/upcomingEvents" var="upcomingEvents" />
<c:url value="/admin" var="admin" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Ashton Estates - Morgantown, WV</title>
<meta name="description" content="Ashton Estates" />
<meta name="author" content="William Hunt" />
<link href="${resources}/css/bootstrap.min.css" rel="stylesheet" />
<link href="${resources}/css/font-awesome.min.css" rel="stylesheet">
<link href="${resources}/css/style.css" rel="stylesheet" />
<link href="http://img.weather.weatherbug.com/Style/stickers/v2/Stickers_300x250.css" rel="stylesheet">
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
<script>
	var map;
	function initialize() {
		map = new google.maps.Map(document.getElementById('map-canvas'), {
			zoom : 15,
			center : {
				lat : 39.584666,
				lng : -79.9835
			}

		});

		var ashtonCoords = [ new google.maps.LatLng(39.584507, -79.979610),
				new google.maps.LatLng(39.586128, -79.980297),
				new google.maps.LatLng(39.586178, -79.982936),
				new google.maps.LatLng(39.586343, -79.984331),
				new google.maps.LatLng(39.585020, -79.984696),
				new google.maps.LatLng(39.584855, -79.987013),
				new google.maps.LatLng(39.583581, -79.989631),
				new google.maps.LatLng(39.582556, -79.989653),
				new google.maps.LatLng(39.581564, -79.988151),
				new google.maps.LatLng(39.581150, -79.985533) ];

		var ashton = new google.maps.Polygon({
			paths : ashtonCoords,
			strokeColor : 'blue',
			strokeOpacity : 0.5,
			strokeWeight : 2,
			fillColor : 'blue',
			fillOpacity : 0.15
		});

		ashton.setMap(map);
	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="page-header">
					<h1>
						Ashton Estates <small> -- a Morgantown residential community</small>
						<c:if test="${residentUser != null}">
							<div class="btn-group btn-group-sm pull-right">
								<h4>
									Hello ${residentUser.getFirstName()} ${residentUser.getLastName()}
									<button id="logoutButton" class="btn btn-xs btn-logout">Logout</button>
								</h4>
							</div>
						</c:if>
					</h1>
				</div>

				<div id="fixed" class="carousel slide" data-ride="carousel">

					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#fixed" data-slide-to="0" class="active"></li>
						<li data-target="#fixed" data-slide-to="1"></li>
						<li data-target="#fixed" data-slide-to="2"></li>
						<li data-target="#fixed" data-slide-to="3"></li>
						<li data-target="#fixed" data-slide-to="4"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner">
						<div class="item active">
							<div style="background:url(${resources}/images/ashtonsign.jpg) center center; background-size:cover;" class="slider-size"></div>
						</div>
						<div class="item">
							<div style="background:url(${resources}/images/park.jpg) center center; background-size:cover;" class="slider-size"></div>
						</div>
						<div class="item">
							<div style="background:url(${resources}/images/ashtonnorth.jpg) center center; background-size:cover;" class="slider-size"></div>
						</div>
						<div class="item">
							<div style="background:url(${resources}/images/playground.jpg) center center; background-size:cover;" class="slider-size"></div>
						</div>
						<div class="item">
							<div style="background:url(${resources}/images/pavillion.jpg) center center; background-size:cover;" class="slider-size"></div>
						</div>

					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="javascript:void(0)" data-slide="prev" data-target="#fixed"> <span class="glyphicon glyphicon-chevron-left"></span>
					</a> <a class="right carousel-control" href="javascript:void(0)" data-slide="next" data-target="#fixed"> <span class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>
				<div class="row margintop20">
					<div class="col-md-10">
						<div class="row">
							<div class="col-md-12">
								<p>Ashton Estates is located in Monongalia County West Virginia just off of Route 73 and approximately 5 miles south of downtown Morgantown. Morgantown, home of West
									Virginia University, has been recognized as one of the best small cities in the Country. Ashton Estates is located west of I-79, just north of the I-79/I-68 interchange,
									and is easily visible to anyone travelling I-79. The Monongahela River is visible from many residents.</p>
								<p>There are approximately 120 single family homes and 90 townhouses. Residential homes are located along Andrew Drive, Ashton Drive, Bradford Lane, Chase Street, and
									Jamestown Drive. Town homes are located along Ashton Place. Directions to Ashton Estates are available via Google Maps.</p>
								<p>Residents enjoy a family-friendly neighborhood with many children of all ages. A private park and pavilion is centrally located. There is also easy access to the Mon
									River Trail.</p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 text-center center-block">
								<div class="publicInfo">
									<h2>Interested in living here?</h2>
									<a href="http://www.zillow.com/homes/for_sale/1_pnd/days_sort/39.596942,-79.957831,39.570119,-80.013621_rect/14_zm/" target="_blank"> <img
										class="img-responsive image-center" src="${resources}/images/search-house.png" alt="search houses" />
									</a> <small>Zillow.com</small>
								</div>
							</div>
							<div class="col-md-6 text-center center-block">
								<div class="publicInfo">
									<h2>Local Events/News</h2>
									<div class="table-responsive">
										<table class="table">
											<tbody>
												<tr>
													<td><a class="btn" target="_blank" href="http://www.downtownmorgantown.com">Downtown Morgantown</a></td>
													<td><a class="btn" target="_blank" href="http://www.morgantownmag.com/morgantown/events">Morgantown Events</a></td>
												</tr>
												<tr>
													<td><a class="btn" target="_blank" href="http://www.mylanpark.com/events">Mylan Park Events</a></td>
													<td><a class="btn" target="_blank" href="http://www.events.wvu.edu">WVU Events</a></td>
												</tr>
												<tr>
													<td><a class="btn" target="_blank" href="http://www.wvusports.com/">WVU Sports</a></td>
													<td><a class="btn" target="_blank" href="http://www.wboy.com">WBOY News</a></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6 text-center center-block">
								<div class="publicInfo">
									<h2>Our Location</h2>
									<div id="map-canvas"></div>
								</div>
							</div>
							<div class="col-md-6 text-center center-block">
								<div class="publicInfo">
									<h2>Current Weather</h2>
									<a href="http://www.accuweather.com/en/us/morgantown-wv/26505/weather-forecast/331473" class="aw-widget-legal"> </a>
									<div id="awcc1457287105136" class="aw-widget-current" data-locationkey="331473" data-unit="f" data-language="en-us" data-useip="false" data-uid="awcc1457287105136"></div>
									<script type="text/javascript" src="http://oap.accuweather.com/launch.js"></script>
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
						<c:if test="${residentUser.isAdmin()}">
							<div class="sidebar admin">
								<h4>
									<a href="${admin}">Administrator</a>
								</h4>
							</div>
						</c:if>
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

	<script src="${resources}/js/jquery.min.js"></script>
	<script src="${resources}/js/bootstrap.min.js"></script>
	<script src="${resources}/js/scripts.js"></script>

	<script>
		$(document).ready(function() {
			$("#logoutButton").click(function() {
				window.location.href = "${logout}"
			});
		});
	</script>

</body>
</html>
