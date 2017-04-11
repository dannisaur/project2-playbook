<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

</head>
<body>
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
    						<form:input  class="form-control" path="userName" placeholder="Username" />
						</div>
					 	<div class="form-group">
    						<form:password  class="form-control" path="pw" placeholder="Password"  />
						</div>
					<input class="btn btn-success btn-block btn-lg" type="submit" value="Login" />
					</fieldset>
				</form:form>

			<br>
			<p>New User? <a href="signup">Sign Up Here.</a></p>
			</div>
		</div>
	</div>


</body>
</html>
