<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Playbook App - Sign In</title>

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

<link rel="stylesheet" href="resources/css/style1.css">
<link rel="stylesheet" href="resources/css/style2.css">

<style>
body {
	background-image: url('resources/media/coffee.jpg');
	background-size: cover;
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
	

	<div class="col-md-4" id="loginPanel">
		<c:if test="${errorMessage != null}">
			<div class="alert alert-danger">${errorMessage}</div>
		</c:if>

		<div class="login-panel panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">The Playbook - Sign In</h3>
			</div>
			<div class="panel-body">
				<form:form action="login" method="POST" commandName="user">
					<fieldset>
						<div class="form-group">
							<form:input class="form-control input-lg" path="userName"
								placeholder="Username" />
						</div>
						<div class="form-group">
							<form:password class="form-control input-lg" path="pw"
								placeholder="Password" />
						</div>
						<input class="btn btn-success btn-block btn-lg" type="submit"
							value="Login" />
					</fieldset>
				</form:form>

				<br>
				<p>
					<a href="signup">New User? Sign Up Here.</a>
				</p>
			</div>
		</div>
	</div>


</body>
</html>
