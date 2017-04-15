<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>Link Steam</title>

<!-- Bootstrap core CSS -->
<link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="../../assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="dashboard.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<link rel="stylesheet" href="resources/css/style2.css">
<link rel="stylesheet" href="resources/css/style3.css">

<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Rambla">
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Open Sans">

<%@ page isELIgnored="false"%>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Project name</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Dashboard</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="#">Help</a></li>
				<li class="active"><a href="edit">EDIT</a></li>
				<li><a href="logout">LOGOUT</a></li>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
	</nav>


	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">

					<li><a href="newgameplan">New Plan</a></li>
					<li><a href="account/edit">Edit Account</a></li>
					<li class="active"><a href="library">View Library <span
							class="sr-only">(current)</span></a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="#">Game Plans</a></li>
					<li><a href="#">#1</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">Link Your Steam Account</h1>

				${message}

				<div class="container">
					<form action="link_steam" method="post"
						class="form-horizontal">
						<fieldset>
							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="textinput">Enter
									your Steam ID</label>
								<div class="col-md-4">
									<input id="textinput" name="steamId" type="text"
										placeholder="Steam ID" class="form-control input-md" />
								</div>
							</div>
							
							
							<div class="form-group">
								<label class="col-md-4 control-label" for="steamButton">Get</label>
								<div class="col-md-4">
									<button id="steamButton" name="steamButton"
										class="btn btn-success">Save</button>
								</div>
							</div>
						</fieldset>
					</form>

				</div>

			</div>
		</div>
	</div>

	<script>
		$(document).ready(
				function() {
					var pw = $('#password');
					var confirm = $('#validatePw');
					$('#validatePw').blur(function() {
						if (confirm != pw) {
							alert("passwords do not match!")
						}
					});
					$(document).on('click', '#close-preview', function() {
						$('.image-preview').popover('hide');
						// Hover befor close the preview
						$('.image-preview').hover(function() {
							$('.image-preview').popover('show');
						}, function() {
							$('.image-preview').popover('hide');
						});
					});
					$(function() {
						// Create the close button
						var closebtn = $('<button/>', {
							type : "button",
							text : 'x',
							id : 'close-preview',
							style : 'font-size: initial;',
						});
						closebtn.attr("class", "close pull-right");
						// Set the popover default content
						$('.image-preview').popover(
								{
									trigger : 'manual',
									html : true,
									title : "<strong>Preview</strong>"
											+ $(closebtn)[0].outerHTML,
									content : "There's no image",
									placement : 'bottom'
								});
						// Clear event
						$('.image-preview-clear').click(
								function() {
									$('.image-preview')
											.attr("data-content", "").popover(
													'hide');
									$('.image-preview-filename').val("");
									$('.image-preview-clear').hide();
									$('.image-preview-input input:file')
											.val("");
									$(".image-preview-input-title").text(
											"Browse");
								});
						// Create the preview image
						$(".image-preview-input input:file").change(
								function() {
									var img = $('<img/>', {
										id : 'dynamic',
										width : 250,
										height : 200
									});
									var file = this.files[0];
									var reader = new FileReader();
									// Set preview image into the popover data-content
									reader.onload = function(e) {
										$(".image-preview-input-title").text(
												"Change");
										$(".image-preview-clear").show();
										$(".image-preview-filename").val(
												file.name);
										img.attr('src', e.target.result);
										$(".image-preview").attr(
												"data-content",
												$(img)[0].outerHTML).popover(
												"show");
									}
									reader.readAsDataURL(file);
								});
					});
				});
	</script>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="../../dist/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="../../assets/js/vendor/holder.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>