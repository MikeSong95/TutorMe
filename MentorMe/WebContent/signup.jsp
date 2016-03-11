<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<!-- jQuery -->
	    <script src="<c:url value="./resources/js/jquery-1.11.3.min.js" />"></script>
	    
	    <!-- Bootstrap -->
	    <link href="<c:url value="./resources/css/bootstrap.min.css" />" rel="stylesheet">
	    <link href="<c:url value="./resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
	    <script src="<c:url value="./resources/js/bootstrap.min.js" />"></script>
			    
		<!-- JS -->
		<script src="<c:url value="./resources/js/signup.js" />"></script>
		
		<!-- CSS -->
		<link href="<c:url value="./resources/css/signup.css" />" rel="stylesheet">
		
		<title>TutorMe - Sign Up</title>
	</head>
	<body>
		<div id="background">
	  		<img class="stretch" src="./resources/images/splash_img.jpg" alt="background">
		</div>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
 				<ul class="nav navbar-nav">
       				<li><a href="index.jsp">Home</a></li>
       				<li><a href="#">About</a></li>
       				<li><a href="#">FAQs</a></li>
       				<li><a href="#">Contact Us</a></li>
      			</ul>
      			<ul class="nav navbar-nav navbar-right">
       				<li class="active"><a href="signup.jsp">Sign Up</a></li>
       				<li><a href="#">Log In</a></li>
      			</ul>
	     	</div>
		</nav>
		<div class="transbox">
			<div id="intro" class="fadein">
				<br>
				<h1 align="center"> Register As: </h1>
				<br>
				<div class="col-sm-6" align="center">
					<button onclick="studentForm()">Student</button>
				</div>
				<div class="col-sm-6" align="center">
					<button onclick="tutorForm()">Tutor</button>
				</div>
				<br><br><br><br>
			</div>
			<div id="tutorForm" class="fadein" style="display:none">
				<br>
				<h1 align="center"> Registration Form </h1>
				<div class="col-sm-4" align="center">
					<p> First Name: </p> <input type="text" /> 
				</div>
				<div class="col-sm-4" align="center">
					<p> Last Name: </p>	<input type="text" /> 
				</div>
				<div class="col-sm-4" align="center">
					<p> Email: </p> <input type="text">
				</div>
				
				<div class="col-sm-4" align="center">
					<p> School: </p>
					<div class="dropdown">
						<button id="almaMaterBtn" class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
  							Choose...
  							<span class="caret"></span>
						</button>
						<ul id="almaMater" class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<li><a href="#">University of Toronto</a></li>
							<li><a href="#">Western University</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-4" align="center">
					<p > Degree: </p>
					<div class="dropdown">
						<button id="degreeBtn" class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
  							Choose...
  							<span class="caret"></span>
						</button>
						<ul id="degree" class="dropdown-menu" aria-labelledby="dropdownMenu2">
							<li><a href="#">Bachelor's</a></li>
							<li><a href="#">Master's</a></li>
							<li><a href="#">Ph.D</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-4" align="center">
					<p > Program: </p>
					<div class="dropdown">
						<button id="progBtn" class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
  							Choose...
  							<span class="caret"></span>
						</button>
						<ul id="prog" class="dropdown-menu" aria-labelledby="dropdownMenu2">
							<li><a href="#">Computer Engineering</a></li>
							<li><a href="#">Computer Science</a></li>
							<li><a href="#">Electrical Engineering</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-6" align="center">
					<p> Password: </p>	<input type="password" /> 
				</div>
				<div class="col-sm-6" align="center">
					<p> Confirm Password: </p>	<input type="password" /> 
					<br><br><br><br>
				</div>
				
				<div align="center">
					<button onclick="">Submit</button>
				</div>
				<br><br>
			</div>
			
			<div id="studentForm" class="fadein" style="display:none">
				<br>
				<h1 align="center"> Registration Form </h1>
				<div class="col-sm-4" align="center">
					<p> First Name: </p> <input type="text" /> 
				</div>
				<div class="col-sm-4" align="center">
					<p> Last Name: </p>	<input type="text" /> 
				</div>
				<div class="col-sm-4" align="center">
					<p> Email: </p> <input type="text">
				</div>
				<div class="col-sm-6" align="center">
					<p> Password: </p>	<input type="password" /> 
				</div>
				<div class="col-sm-6" align="center">
					<p> Confirm Password: </p>	<input type="password" /> 
					<br><br><br><br>
				</div>
				
				<div align="center">
					<button onclick="">Submit</button>
				</div>
				<br><br>
			</div>
		</div>
	</body>
</html>