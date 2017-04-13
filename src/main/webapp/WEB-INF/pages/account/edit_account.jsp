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
<title>Edit Account page</title>

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

<link rel="stylesheet" href="../resources/css/style2.css">

<style>
.image-preview-input {
	position: relative;
	overflow: hidden;
	margin: 0px;
	color: #333;
	background-color: #fff;
	border-color: #ccc;
}

.image-preview-input input[type=file] {
	position: absolute;
	top: 0;
	right: 0;
	margin: 0;
	padding: 0;
	font-size: 20px;
	cursor: pointer;
	opacity: 0;
	filter: alpha(opacity = 0);
}

.image-preview-input-title {
	margin-left: 2px;
}
</style>

</head>
<body>



	<nav class="navbar navbar-inverse navbar-fixed-top">
<<<<<<< HEAD
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
				<li><a href="../logout">LOGOUT</a></li>
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
					<li><a href="#">New Plan</a></li>
					<li class="active"><a href="#">Edit Account <span
							class="sr-only">(current)</span></a></li>
					<li><a href="#">View Library</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="#">Game Plans</a></li>
					<li><a href="#">#1</a></li>
||||||| merged common ancestors
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
					<li><a href="../logout">LOGOUT</a></li>
=======

	<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!-- <a class="navbar-brand" href="<%--<%= request.getSession().getServletContext().getContextPath() %>--%>">Playbook</a>-->
				<!-- <a class="navbar-brand" href="landing">Playbook</a>-->
				<form action="landing" method="POST"><button class="navbar-brand btn btn-link" type="submit" value="landing">Playbook</button></form>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Dashboard</a></li>
					<li><a href="#">Settings</a></li>
					<li><a href="#">Profile</a></li>
					<li><a href="#">Help</a></li>
					<li class="active"><a href="edit">EDIT</a></li>
					<li><a href="../logout">LOGOUT</a></li>
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
					<li><a href="#">New Plan</a></li>
					<li class="active"><a href="#">Edit Account <span
							class="sr-only">(current)</span></a></li>
					<li><a href="#">View Library</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="#">Game Plans</a></li>
					<li><a href="#">#1</a></li>
>>>>>>> fd6583e8b3540dc6214cf759cdd78e69615bc90b
				</ul>
<<<<<<< HEAD
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">Edit Account</h1>

				<p>Fields marked with (*) are optional.</p>
				<div class="container">
					<form:form action="edit" method="POST"
						modelAttribute="updatedUser" class="form-horizontal">
						<fieldset>
							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="textinput">First
									Name *</label>
								<div class="col-md-4">
									<form:input id="textinput" path="firstName" type="text"
										placeholder="First Name" class="form-control input-md" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label" for="textinput">Last
									Name *</label>
								<div class="col-md-4">
									<form:input id="textinput" path="lastName" type="text"
										placeholder="Last Name" class="form-control input-md" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label" for="textinput">Username</label>
								<div class="col-md-4">
									<form:input id="textinput" path="userName" type="text"
										placeholder="Username" class="form-control input-md" disabled="true" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label" for="textinput">Steam
									ID</label>
								<div class="col-md-4">
									<form:input id="textinput" path="steamId" type="text"
										placeholder="Steam ID" class="form-control input-md" disabled="true" />
								</div>
							</div>

							<!-- Password input-->

							<%-- <div class="form-group">
								<label class="col-md-4 control-label" for="passwordinput">Current
									password</label>
								<div class="col-md-4">
									<form:password id="passwordinput" path="currPw"
										placeholder="current password" class="form-control input-md" />

								</div>
							</div> --%>

							<div class="form-group">
								<label class="col-md-4 control-label" for="passwordinput">New
									password</label>
								<div class="col-md-4">
									<form:password id="passwordinput" path="pw"
										placeholder="new password" class="form-control input-md" />

								</div>
							</div>

							<!-- Password input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="passwordinput">Confirm
									password</label>
								<div class="col-md-4">
									<input type="password" id="validatePw" class="form-control input-md">
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label" for="textinput">Email</label>
								<div class="col-md-4">
									<form:input id="textinput" path="email" type="text"
										placeholder="your current email "
										class="form-control input-md" />
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label" for="textinput">Set
									Profile Pic *</label>
								<div class="col-md-4">
									<!-- image-preview-filename input [CUT FROM HERE]-->
									<div class="input-group image-preview">
										<input type="text" class="form-control image-preview-filename"
											disabled="disabled">
										<!-- don't give a name === doesn't send on POST/GET -->
										<span class="input-group-btn"> <!-- image-preview-clear button -->
											<button type="button"
												class="btn btn-default image-preview-clear"
												style="display: none;">
												<span class="glyphicon glyphicon-remove"></span> Clear
											</button> <!-- image-preview-input -->
											<div class="btn btn-default image-preview-input">
												<span class="glyphicon glyphicon-folder-open"></span> <span
													class="image-preview-input-title">Browse</span> <input
													type="file" accept="image/png, image/jpeg, image/gif"
													name="input-file-preview" />
												<!-- rename it -->
											</div>
										</span>
									</div>
									<!-- /input-group image-preview [TO HERE]-->
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label" for="selectbasic">Tell
									us about yourself *</label>
								<div class="col-md-4">
									<form:textarea path="desc" class="form-control" rows="4"
										id="bio"></form:textarea>
								</div>
							</div>

							<!-- Button -->
							<div class="form-group">
								<label class="col-md-4 control-label" for="singlebutton">Save
									Changes</label>
								<div class="col-md-4">
									<button id="singlebutton" name="singlebutton"
										class="btn btn-success">Save</button>
								</div>
							</div>

						</fieldset>
					</form:form>

				</div>



||||||| merged common ancestors
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
				</form>
=======
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">Edit Account</h1>
        

				<p>Fields marked with (*) are optional.</p>
				<div class="container">
					<form:form action="edit" method="POST"
						modelAttribute="updatedUser" class="form-horizontal">
						<fieldset>
							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="textinput">First
									Name *</label>
								<div class="col-md-4">
									<form:input id="textinput" path="firstName" type="text"
										placeholder="First Name" class="form-control input-md" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label" for="textinput">Last
									Name *</label>
								<div class="col-md-4">
									<form:input id="textinput" path="lastName" type="text"
										placeholder="Last Name" class="form-control input-md" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label" for="textinput">Username</label>
								<div class="col-md-4">
									<form:input id="textinput" path="userName" type="text"
										placeholder="Username" class="form-control input-md" disabled="true" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label" for="textinput">Steam
									ID</label>
								<div class="col-md-4">
									<form:input id="textinput" path="steamId" type="text"
										placeholder="Steam ID" class="form-control input-md" disabled="true" />
								</div>
							</div>

							<!-- Password input-->

							<%-- <div class="form-group">
								<label class="col-md-4 control-label" for="passwordinput">Current
									password</label>
								<div class="col-md-4">
									<form:password id="passwordinput" path="currPw"
										placeholder="current password" class="form-control input-md" />

								</div>
							</div> --%>

							<div class="form-group">
								<label class="col-md-4 control-label" for="passwordinput">New
									password</label>
								<div class="col-md-4">
									<form:password id="passwordinput" path="pw"
										placeholder="new password" class="form-control input-md" />

								</div>
							</div>

							<!-- Password input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="passwordinput">Confirm
									password</label>
								<div class="col-md-4">
									<input type="password" id="validatePw" class="form-control input-md">
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label" for="textinput">Email</label>
								<div class="col-md-4">
									<form:input id="textinput" path="email" type="text"
										placeholder="your current email "
										class="form-control input-md" />
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label" for="textinput">Set
									Profile Pic *</label>
								<div class="col-md-4">
									<!-- image-preview-filename input [CUT FROM HERE]-->
									<div class="input-group image-preview">
										<input type="text" class="form-control image-preview-filename"
											disabled="disabled">
										<!-- don't give a name === doesn't send on POST/GET -->
										<span class="input-group-btn"> <!-- image-preview-clear button -->
											<button type="button"
												class="btn btn-default image-preview-clear"
												style="display: none;">
												<span class="glyphicon glyphicon-remove"></span> Clear
											</button> <!-- image-preview-input -->
											<div class="btn btn-default image-preview-input">
												<span class="glyphicon glyphicon-folder-open"></span> <span
													class="image-preview-input-title">Browse</span> <input
													type="file" accept="image/png, image/jpeg, image/gif"
													name="input-file-preview" />
												<!-- rename it -->
											</div>
										</span>
									</div>
									<!-- /input-group image-preview [TO HERE]-->
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label" for="selectbasic">Tell
									us about yourself *</label>
								<div class="col-md-4">
									<form:textarea path="desc" class="form-control" rows="4"
										id="bio"></form:textarea>
								</div>
							</div>

							<!-- Button -->
							<div class="form-group">
								<label class="col-md-4 control-label" for="singlebutton">Save
									Changes</label>
								<div class="col-md-4">
									<button id="singlebutton" name="singlebutton"
										class="btn btn-success">Save</button>
								</div>
							</div>

						</fieldset>
					</form:form>

				</div>



>>>>>>> fd6583e8b3540dc6214cf759cdd78e69615bc90b
			</div>
		</div>
	</div>

	<script>
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
			$('.image-preview').popover({
				trigger : 'manual',
				html : true,
				title : "<strong>Preview</strong>" + $(closebtn)[0].outerHTML,
				content : "There's no image",
				placement : 'bottom'
			});
			// Clear event
			$('.image-preview-clear').click(function() {
				$('.image-preview').attr("data-content", "").popover('hide');
				$('.image-preview-filename').val("");
				$('.image-preview-clear').hide();
				$('.image-preview-input input:file').val("");
				$(".image-preview-input-title").text("Browse");
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
							$(".image-preview-input-title").text("Change");
							$(".image-preview-clear").show();
							$(".image-preview-filename").val(file.name);
							img.attr('src', e.target.result);
							$(".image-preview").attr("data-content",
									$(img)[0].outerHTML).popover("show");
						}
						reader.readAsDataURL(file);
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
