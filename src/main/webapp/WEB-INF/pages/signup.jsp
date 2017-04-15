<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign-Up</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css" />
	
<link rel="stylesheet" href="resources/css/style1.css">
<link rel="stylesheet" href="resources/css/style2.css">


<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>

<script type="text/javascript" src="bootstrap/js/bootstrap.min.js">
	
</script>

<style>
.colorgraph {
	height: 5px;
	border-top: 0;
	background: #c4e17f;
	border-radius: 5px;
}
</style>

</head>
<body>


	<!-- SITE NAVIGATION BAR -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<!-- NAV CONTAINER -->
		<div class="container-fluid">
			<!-- LOGO -->
			<div class="!navbar-header">
				<a class="navbar-brand" href="#">Playbook</a>
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
									<li><a href="account">Profile</a></li>
		            				<li><a href="account/edit">Edit Account</a></li>
		            				<li><a href="logout">Sign out</a></li>
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
	
	

	<!-- MAIN HEADING -->
	<div class="main-heading">
		<div class="cointainer">
			<div class="row" id="signup">
				<div
					class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
					<form:form action="signup" method="post" modelAttribute="userImpl">
						<h2>
							The Playbook <small>Sign up</small>
						</h2>
						<hr class="colorgraph">
						
						<div class="row">
							<div class="col-xs-12 col-sm-6 col-md-6">
								<div class="form-group">
									<form:input type="text" path="firstName" id="first_name"
										class="form-control input-lg" placeholder="First Name"
										tabindex="1" />
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-6">
								<div class="form-group">
									<form:input type="text" path="lastName" id="last_name"
										class="form-control input-lg" placeholder="Last Name"
										tabindex="2" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<form:input type="text" path="userName" id="user_name"
								class="form-control input-lg" placeholder="User Name"
								tabindex="3" />
						</div>
						<div class="form-group">
							<form:input type="email" path="email" id="email"
								class="form-control input-lg" placeholder="Email Address"
								tabindex="4" />
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-6 col-md-6">
								<div class="form-group">
									<form:password path="pw" id="password"
										class="form-control input-lg" placeholder="Password"
										tabindex="5" />
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="password" name="validatePw"
										id="password_confirmation" class="form-control input-lg"
										placeholder="Confirm Password" tabindex="6">
								</div>
							</div>
						</div>
	
	
						<hr class="colorgraph">
						<div class="row">
							<div class="col-xs-12 col-md-6">
								<input type="submit" value="Register"
									class="btn btn-success btn-block btn-lg" tabindex="7">
							</div>
	
						</div>
					</form:form>
				</div>
			</div>
			<!-- Modal -->
		</div>
	</div>
	
	
	<!-- SUB-HEADING -->
	<div class="sub-heading" style="height: 350px">
	</div>



	<script>
		$(function() {
			$('.button-checkbox')
					.each(
							function() {

								// Settings
								var $widget = $(this), $button = $widget
										.find('button'), $checkbox = $widget
										.find('input:checkbox'), color = $button
										.data('color'), settings = {
									on : {
										icon : 'glyphicon glyphicon-check'
									},
									off : {
										icon : 'glyphicon glyphicon-unchecked'
									}
								};

								// Event Handlers
								$button.on('click', function() {
									$checkbox.prop('checked', !$checkbox
											.is(':checked'));
									$checkbox.triggerHandler('change');
									updateDisplay();
								});
								$checkbox.on('change', function() {
									updateDisplay();
								});

								// Actions
								function updateDisplay() {
									var isChecked = $checkbox.is(':checked');

									// Set the button's state
									$button.data('state', (isChecked) ? "on"
											: "off");

									// Set the button's icon
									$button
											.find('.state-icon')
											.removeClass()
											.addClass(
													'state-icon '
															+ settings[$button
																	.data('state')].icon);

									// Update the button's color
									if (isChecked) {
										$button.removeClass('btn-default')
												.addClass(
														'btn-' + color
																+ ' active');
									} else {
										$button.removeClass(
												'btn-' + color + ' active')
												.addClass('btn-default');
									}
								}

								// Initialization
								function init() {

									updateDisplay();

									// Inject the icon if applicable
									if ($button.find('.state-icon').length == 0) {
										$button.prepend('<i class="state-icon '
												+ settings[$button
														.data('state')].icon
												+ '"></i>');
									}
								}
								init();
							});
		});
	</script>
	
		<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
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