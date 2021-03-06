<link href="http://img.weather.weatherbug.com/Style/stickers/v2/Stickers_300x250.css" rel="stylesheet">

<script>
	function initMap() {
		var map = new google.maps.Map(document.getElementById('map-canvas'), {
			zoom : 15,
			center : {
				lat : 39.584666,
				lng : -79.9853
			}
		});

		var ashtonCoords = [ new google.maps.LatLng(39.584507, -79.979610), new google.maps.LatLng(39.586128, -79.980297), new google.maps.LatLng(39.586178, -79.982936),
				new google.maps.LatLng(39.586343, -79.984331), new google.maps.LatLng(39.585020, -79.984696), new google.maps.LatLng(39.584855, -79.987013),
				new google.maps.LatLng(39.583581, -79.989631), new google.maps.LatLng(39.582556, -79.989653), new google.maps.LatLng(39.581564, -79.988151),
				new google.maps.LatLng(39.581150, -79.985533) ];

		var ashton = new google.maps.Polygon({
			paths : ashtonCoords,
			strokeColor : 'blue',
			strokeOpacity : 0.5,
			strokeWeight : 2,
			fillColor : 'blue',
			fillOpacity : 0.05
		});

		ashton.setMap(map);
	}
</script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCnxZVlW4FBhB0Eg3A_UiD-Twxvfpz1tY0&callback=initMap" type="text/javascript"></script>