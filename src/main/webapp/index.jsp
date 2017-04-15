<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
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


	<!-- SITE NAVIGATION BAR -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<!-- NAV CONTAINER -->
		<div class="container-fluid">
			<!-- LOGO -->
			<div class="navbar-header">
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


	<!-- HERO SECTION -->
	<div class="container fill">
		<!-- GRID -->
		<div class="row">
			<!-- PLAY BUTTONS -->
			<div class="col-md-6 col-sm-12">
				<img class="img-responsive" src="resources/media/play-map.png" alt="Buttons" usemap="#play-map">
				<map name="play-map" id="play-map">
					<area id="yellow" shape="circle" coords="225,30,120" href="#" alt="yellow" title="yellow"> <!-- top -->
					<area id="red" shape="circle" coords="75,250,100" href="#" alt="red" title="red"> <!-- left -->
					<area id="green" shape="circle" coords="275,450,100" href="#" alt="green" title="green"> <!-- bottom -->
					<area id="blue" shape="circle" coords="500,275,100" href="#" alt="blue" title="blue"> <!-- right -->
				</map>
			</div>
			<!-- /.PLAY BUTTONS -->
			<!-- INFORMATIONAL SECTION -->
			<div class="col-md-6 col-sm-12">
				<!-- INFORMATION GALLERY -->
				<div id="information" class="carousel slide" data-ride="carousel" data-interval="7500">
					<!-- POSITION INDICATORS -->
					<ol class="carousel-indicators" style="padding-top: 50px">
						<li data-target="#information" data-slide-to="0" class="active"></li>
						<li data-target="#information" data-slide-to="1"></li>
						<li data-target="#information" data-slide-to="2"></li>
					</ol>
					<!-- /.POSITION INDICATORS -->
					<!-- INFORMATION BLURBS -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<h1>Playbook</h1>
							<p>An app for catching up on the games you've always wanted to play. With Steam integration
							it allows you to track your time spent playing your games and set up a game plan for completing
							them. Your plan, your rules; you say when you're done. Find your friends and see what they're up to,
							or how much gaming they have left to do.
							</p>
						</div>
						<div class="item">
							<h1>Stay motivated</h1>
							<p>Chart your progress, see what your friends are playing. The app
								automatically tracks your time spent playing and allows you
								to define a game plan for keeping you on track to finish the
								game.
							</p>
						</div>
						<div class="item">	
							<h1>Steam integration</h1>
							<p>Automatically track your time playing your favorite games on Steam and set up a plan to complete them.</p>
						</div>
					  <!-- /.INFORMATION BLURBS -->
					</div>
					<!-- GALLERY NAV CONTROLS -->
					<a class="left carousel-control" href="#information" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#information" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
					<!-- /.GALLERY NAV CONTROLS -->
				</div>
				<!-- /.INFORMATION GALLERY -->
			</div>
			<!-- /.INFORMATIONAL SECTION -->
		</div>
		<!-- /.GRID -->
	</div>
	<!-- /.HERO SECTION -->


	<!-- FOOTER -->
	<footer>
	
	
	</footer>
	<!-- /.FOOTER -->


	<script>
	$(document).ready(function() {
	    if($('#play-map')) {
	        $('#play-map area').each(function() {
	            $(this).mouseover(function() {
	            	if ($(this).attr('id') == 'yellow') {
	            		$('body').attr('style', 'background-color: #fade6d; transition: all 0.2s ease 0s');
	            	}
	            	else if ($(this).attr('id') == 'red') {
	            		$('body').attr('style', 'background-color: #eb3e3e; transition: all 0.2s ease 0s');
	            	}
	            	else if ($(this).attr('id') == 'green') {
	            		$('body').attr('style', 'background-color: #42cc63; transition: all 0.2s ease 0s');
	            	}
	            	else if ($(this).attr('id') == 'blue') {
	            		$('body').attr('style', 'background-color: #6b6bff; transition: all 0.2s ease 0s');
	            	}
	            });

	            $(this).mouseout(function() {
	                $('body').attr('style', 'background-color: #323232; transition: all 0.2s linear 0s;')
	            });

	        });
	    }
	});
	</script>
</body>
</html>
