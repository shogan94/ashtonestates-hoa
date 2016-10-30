<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<c:url value="/resources" var="resources" />

<!DOCTYPE html>
<html lang="en">

<head>
<title><tiles:getAsString name="title" /></title>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Ashton Estates" />
<meta name="author" content="William Hunt" />

<link href="${resources}/css/bootstrap.min.css" rel="stylesheet" />
<link href="${resources}/css/font-awesome.min.css" rel="stylesheet">
<link href="${resources}/css/style.css" rel="stylesheet" />
<link href="${resources}/css/jquery.dataTables.min.css" rel="stylesheet" />
<link href="${resources}/css/dropzone.min.css" rel="stylesheet" />
<link href="${resources}/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />

<!--[if lt IE 9]>
    <script src="${resources}/js/html5shiv.min.js"></script>
    <script src="${resources}/js/respond.min.js"></script>
<![endif]-->

<tiles:insertAttribute name="head" />

</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<tiles:insertAttribute name="header" />
				<tiles:insertAttribute name="preBody" />
				<div class="row margintop20">
					<div class="col-md-10">
						<tiles:insertAttribute name="body" />
					</div>
					<div class="col-md-2">
						<tiles:insertAttribute name="sidebar" />
					</div>
				</div>
			</div>
		</div>
		<tiles:insertAttribute name="footer" />
	</div>

	<script src="${resources}/js/jquery-3.1.0.min.js"></script>
	<script src="${resources}/js/bootstrap.min.js"></script>
	<script src="${resources}/js/jquery.dataTables.min.js"></script>
	<script src="${resources}/js/dropzone.min.js"></script>
	<script src="${resources}/js/moment.js"></script>
	<script src="${resources}/js/bootstrap-datetimepicker.min.js"></script>

	<tiles:insertAttribute name="bodyScripts" />

	<script>
		$(document).ready(function() {
			$('[data-toggle="tooltip"]').tooltip();
		});
	</script>

</body>

</html>