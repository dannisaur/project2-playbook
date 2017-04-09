<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Playbook App - Landing Page</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Oleo Script">
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Open Sans">
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Source Code Pro">

<link rel="stylesheet" href="css/style1.css">

</head>
<body>
	<div class="col-md-4" id="loginPanel">
		<div class="login-panel panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">The Playbook - Sign In</h3>
			</div>
			<div class="panel-body">
				<form action="test.jsp" role="form">
					<fieldset>
						<div class="form-group">
							<input class="form-control" placeholder="Username"
								name="username">
						</div>
						<div class="form-group">
							<input class="form-control" placeholder="Password"
								name="password" type="password">
						</div>
						<div class="checkbox">
							<label> <input name="remember" type="checkbox"
								value="Remember Me">Remember Me
							</label>
						</div>
						<!-- Change this to a button or input when using this as a form -->
						<a href="login" class="btn btn-sm btn-success">Login</a>
						
					</fieldset>
				</form>
			</div>
		</div>
	</div>


</body>
</html>
