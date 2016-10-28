
<script>
	$(document).ready(function() {
		$('#eTable').DataTable({
			"paging" : false,
			"ordering" : true,
			"info" : false,
			"searching" : false,
			"order" : [ [ 1, "asc" ] ]
		});
	});
</script>
