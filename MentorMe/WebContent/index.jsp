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
		<script src="<c:url value="index.js" />"></script>
		
		<!-- CSS -->
		<link href="<c:url value="./resources/css/index.css" />" rel="stylesheet">
		
		<title>TutorMe</title>
	</head>
	<body>
		<div id="background">
  			<img class="stretch" src="./resources/images/splash_img.jpg" alt="background">
		</div>
		<div class="navbarFont">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
 				<ul class="nav navbar-nav">
       				<li class="active"><a href="index.jsp">Home</a></li>
       				<li><a href="#">About</a></li>
       				<li><a href="#">FAQs</a></li>
       				<li><a href="#">Contact Us</a></li>
      			</ul>
      			<ul class="nav navbar-nav navbar-right">
       				<li><a>Sign Up</a></li>
       				<li><a href="#">Log In</a></li>
      			</ul>
	     	</div>
		</nav>
		</div>
		<div class="jumbotron">
 			<h1 align="center">Welcome to TutorMe!</h1>
 			<h2 align="center"> TutorMe is an online platform that connects academically motivated students with highly qualified tutors.</h2>
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
		<div align="center">
 			<button onclick="toSignUpPage()"> Sign Up </button>
		</div>
	</body>
</html>