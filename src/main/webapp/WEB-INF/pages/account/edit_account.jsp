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

<link rel="stylesheet" href="../resources/css/style1.css">
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

<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Rambla">
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Open Sans">

<%@ page isELIgnored="false"%>

</head>
<body>

	<!-- SITE NAVIGATION BAR -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<!-- NAV CONTAINER -->
		<div class="container-fluid">
			<!-- LOGO -->
			<div class="!navbar-header">
				<a class="navbar-brand" href="landing">Playbook</a>
			</div>
			<!-- /.LOGO -->
			<!-- NAV OPTIONS -->
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<!-- display user button if user signed in; otherwise display login button -->
					<c:choose>
						<c:when test="${not empty alsoUser}">
							<!-- USER BUTTON -->
						 	<li class="dropdown">
		          				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
		          					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
		          					${alsoUser.userName}
		          					<span class="caret"></span>
		          				</a>
		          				<ul class="dropdown-menu">
									<li><a href="../account">Profile</a></li>
		            				<li><a href="edit">Edit Account</a></li>
		            				<li><a href="../logout">Sign out</a></li>
		          				</ul>
		        			</li>
        					<!-- /.USER BUTTON -->
						</c:when>
						<c:otherwise>
							<!-- LOGIN BUTTON -->
		          			<li>
		          				<a href="login">Sign in</a>
		          			</li>
		         			<!-- /.LOGIN BUTTON -->
						</c:otherwise>
					</c:choose>
				</ul>
				<!-- USER SEARCH BAR -->
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search users...">
				</form>
				<!-- /.USER SEARCH BAR -->
			</div>
			<!-- /.NAV OPTIONS -->
		</div>
		<!-- /.NAV CONTAINER -->
	</nav>
	<!-- /.SITE NAVIGATION BAR -->


	<!-- SITE SIDEBAR -->
	<div class="nav-side-menu">
	    <div class="menu-list">
	        <ul id="menu-content" class="menu-content">
	            <li class="icon-button" data-toggle="tooltip" title="New Game Plan" data-placement="bottom"><a href="../newgameplan" style="width: 50px; padding-top: 15px; padding-left: 15px"><img class="icon icon-square" src="../resources/media/icon-square.png"></img></a></li><!-- NEW GAME PLAN -->
	            <li class="icon-button" data-toggle="tooltip" title="View Game Plans" data-placement="bottom"><a href="../gameplan" style="width: 50px; padding-top: 15px; padding-left: 15px"><img class="icon icon-triangle" src="../resources/media/icon-triangle.png"></img></a></li><!-- VIEW GAME PLANS -->
            	<li class="icon-button" data-toggle="tooltip" title="View Library" data-placement="bottom"><a href="../library" style="width: 50px; padding-top: 15px; padding-left: 15px"><img class="icon icon-circle" src="../resources/media/icon-circle.png"></img></a></li><!-- VIEW LIBRARY -->
            	<li class="icon-button" data-toggle="tooltip" title="Edit Account" data-placement="bottom"><a href="edit" style="width: 50px; padding-top: 15px; padding-left: 15px"><img class="icon icon-x" src="../resources/media/icon-x.png"></img></a></li><!-- EDIT ACCOUNT -->
	        </ul>
	    </div>
	</div>
	<!-- /.SITE SIDEBAR -->
	
		
	<!-- MAIN HEADING -->
	<div class="main-heading">
		<h1>Edit Account</h1>
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
							<form:password id="password" path="pw"
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
	</div>
	<!-- /.MAIN HEADING -->


	<!-- SUB-HEADING -->
	<div class="sub-heading" style="height: 200px;"></div>

	<script>
	$(document).ready(function(){
		var pw = $('#password');
		var confirm = $('#validatePw');
		$('#validatePw').blur(function(){
			if (confirm != pw){
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
		
	<script>
		$(function () {
			  $('[data-toggle="tooltip"]').tooltip()
			})
	</script>

</body>
</html>