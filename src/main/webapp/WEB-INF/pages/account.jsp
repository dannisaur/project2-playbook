<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.revature.kkoders.beans.UserImpl" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>The Playbook - Dashboard</title>

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

<link rel="stylesheet" href="resources/css/style1.css">
<link rel="stylesheet" href="resources/css/style2.css">

<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Rambla">
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Open Sans">
	
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
	
	
	<!-- SITE SIDEBAR -->
	<div class="nav-side-menu">
	    <div class="menu-list">
	        <ul id="menu-content" class="menu-content">
	            <li class="icon-button" data-toggle="tooltip" title="New Game Plan" data-placement="bottom"><a href="newgameplan" style="width: 50px; padding-top: 15px; padding-left: 15px"><img class="icon icon-square" src="resources/media/icon-square.png"></img></a></li><!-- NEW GAME PLAN -->
	            <li class="icon-button" data-toggle="tooltip" title="View Game Plans" data-placement="bottom"><a href="gameplan" style="width: 50px; padding-top: 15px; padding-left: 15px"><img class="icon icon-triangle" src="resources/media/icon-triangle.png"></img></a></li><!-- VIEW GAME PLANS -->
            	<li class="icon-button" data-toggle="tooltip" title="View Library" data-placement="bottom"><a href="library" style="width: 50px; padding-top: 15px; padding-left: 15px"><img class="icon icon-circle" src="resources/media/icon-circle.png"></img></a></li><!-- VIEW LIBRARY -->
            	<li class="icon-button" data-toggle="tooltip" title="Edit Account" data-placement="bottom"><a href="account/edit" style="width: 50px; padding-top: 15px; padding-left: 15px"><img class="icon icon-x" src="resources/media/icon-x.png"></img></a></li><!-- EDIT ACCOUNT -->
	        </ul>
	    </div>
	</div>
	<!-- /.SITE SIDEBAR -->
	

	<!-- MAIN HEADING -->
	<div class="main-heading">
		<div class="row">
			<div class="col-md-1">
				<span class="glyphicon glyphicon-user" aria-hidden="true" style="font-size:75px"></span>
			</div>
			<div class="col-md-11">
				<h1>${alsoUser.userName}</h1>
				<p class="user-name">${alsoUser.firstName} ${alsoUser.lastName}</p>
			</div>
		</div>
		
		<p class="user-description">${alsoUser.desc}</p>
	</div>
	<!-- ./MAIN HEADING -->

	<!-- SUB-HEADING -->
	<div class="sub-heading">
		<section style="height: 150px">
			<h1>Recent Game Plan</h1>
		</section>
		
		<section style="height: 400px;">
			<h1>Games</h1>
		</section>
	</div>
	<!-- /.SUB-HEADING -->
	

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
