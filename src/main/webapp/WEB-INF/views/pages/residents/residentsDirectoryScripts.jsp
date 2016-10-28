
<script>
	$(document).ready(function() {

		$('#uTable').DataTable({
			"paging" : false,
			"ordering" : true,
			"info" : false,
			"searching" : false,
			"order" : [ [ 1, "asc" ] ]
		});
	});
</script>
