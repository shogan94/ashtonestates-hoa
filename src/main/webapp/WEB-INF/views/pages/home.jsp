<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/resources" var="resources" />

<div class="row">
	<div class="col-md-12">
		<p>Ashton Estates is located in Monongalia County West Virginia just off of Route 73 and approximately 5 miles south of downtown Morgantown. Morgantown, home of West Virginia
			University, has been recognized as one of the best small cities in the Country. Ashton Estates is located west of I-79, just north of the I-79/I-68 interchange, and is easily
			visible to anyone travelling I-79. The Monongahela River is visible from many residents.</p>
		<p>There are approximately 120 single family homes and 90 townhouses. Residential homes are located along Andrew Drive, Ashton Drive, Bradford Lane, Chase Street, and
			Jamestown Drive. Town homes are located along Ashton Place. Directions to Ashton Estates are available via Google Maps.</p>
		<p>Residents enjoy a family-friendly neighborhood with many children of all ages. A private park and pavilion is centrally located. There is also easy access to the Mon River
			Trail.</p>
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