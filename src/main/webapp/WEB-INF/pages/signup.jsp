<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
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


	<div class="container">

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
								<form:password path="pw"
									id="password_confirmation" class="form-control input-lg"
									placeholder="Confirm Password" tabindex="6" />
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

</body>
</html>