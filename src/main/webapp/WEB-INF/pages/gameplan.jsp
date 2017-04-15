<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The Playbook App - Game Plan</title>

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
<%@ page isELIgnored="false" %>

</head>
<body>

	

	<h3 align="center">This page is still under construction</h3>
	<h4 align="center">Below are your game plans --> insert name of user in the session</h4>
	<div align="center">
	<!-- putting table below these lines in the center -->
	</div>
    
    <!--  
    <button class="btn">Import</button>
    <button class="btn">Export</button>
    
    -->
    
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
				<a class="navbar-brand" href="#">Playbook</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Dashboard</a></li>
					<li><a href="#">Settings</a></li>
					<li><a href="#">Profile</a></li>
					<li><a href="#">Help</a></li>
					<li><a href="account/edit">EDIT</a></li>
					<li><a href="logout">LOGOUT</a></li>
				 	
				 	<li class="dropdown">
          				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
          					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
          					UserOptions 
          					<span class="caret"></span>
          				</a>
          				<ul class="dropdown-menu">
							<li><a href="#">Profile</a></li>
            				<li><a href="account/edit">Edit Account</a></li>
            				<li><a href="logout">Logout</a></li>
          				</ul>
        			</li>
        			
        			
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
					<li class="active"><a href="#">New Plan <span
							class="sr-only">(current)</span></a></li>
					<li><a href="account/edit">Edit Account</a></li>
					<li><a href="#">View Library</a></li>
				</ul>
				<ul class="nav nav-sidebar">
					<li><a href="gameplan">Game Plans</a></li>
					<li><a href="#">#1</a></li>
				</ul>
			</div>
		</div>
<div class="gameplan" align="center"  >
<div class="btn-toolbar">
    <button class="btn btn-primary" onClick="location.href='newgameplan'">New Game Plan</button>
    <table class="table" align="center">
      <thead>
        <tr>
         
          <th>Title</th>
          <th>Start Date</th>
          <th>End date</th>
          <th>Hour Per day</th>
          
          <th style="width: 36px;"></th>
        </tr>
      </thead>
      <tbody>
       
        <c:forEach items="${gameplans}" var="Plans">
        	<tr>
        		
        		<td><c:out value="${Plans.title}"></c:out>
        		<td><c:out value="${Plans.startDate}"></c:out>
        		<td><c:out value="${Plans.endDate}"></c:out>
        		<td><c:out value="${Plans.hours}"></c:out>
        		
        	</tr>
        </c:forEach>
      </tbody>
    </table>
</div>

<div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">Delete Confirmation</h3>
    </div>
    <div class="modal-body">
        <p class="error-text">Are you sure you want to delete the user?</p>
    </div>
    <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button>
        <button class="btn btn-danger" data-dismiss="modal">Delete</button>
    </div>
</div>
	

</body>
</html>