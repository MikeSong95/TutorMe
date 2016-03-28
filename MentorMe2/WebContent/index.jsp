<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
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
		<script src="<c:url value="./resources/js/index.js" />"></script>
		
		<!-- CSS -->
		<link href="<c:url value="./resources/css/index.css" />" rel="stylesheet">
		
		<title>TutorMe</title>
	</head>
	<body>
		<!-- Background Image -->
		<div id="background">
  			<img class="stretch" src="./resources/images/splash_img.jpg" alt="background">
		</div>
		<!-- Navbar -->
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
 				<ul class="nav navbar-nav">
       				<li class="active"><a href="index.jsp">Home</a></li>
       				<li><a href="about.html">About</a></li>
       				<li><a href="faq.html">FAQs</a></li>
       				<li><a href="contact.html">Contact Us</a></li>
      			</ul>
      			<ul class="nav navbar-nav navbar-right">
       				<li><a href="signup.jsp">Sign Up</a></li>
       				<li><a href="login.jsp">Log In</a></li>
      			</ul>
	     	</div>
		</nav>
		<div class="jumbotron">
 			<h1 align="center">Welcome to TutorMe!</h1>
 			<h2 align="center"> TutorMe is an online platform that connects academically motivated students with highly qualified tutors.</h2>
 			<br><br>
 			<div class="row">
				<div class="col-sm-6 col-md-4">
					<div class="transbox">
						<br>
						<p align="center">Search tutors by school, courses, availability, and more!</p>
						<br>
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="transbox">
						<br>
						<p align="center">View the tutor's profile, including their degree and qualifications.</p>
						<br>
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="transbox">
						<br>
						<p align="center">Free, easy to use, and the most convenient way to find a tutor!</p>
						<br>
					</div>
				</div>
			</div>
		</div>
		<!-- Call function to signup.jsp -->
		<div align="center">
 			<button onclick="toSignUpPage()"> Sign Up </button> 
		</div>
	</body>
</html>