<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/resources" var="resources" />

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
