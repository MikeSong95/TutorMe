<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			
		<!-- jQuery -->
	    <script src="./resources/js/jquery-1.11.3.min.js"></script>
	    
	    <!-- Bootstrap -->
	    <link href="./resources/css/bootstrap.min.css" rel="stylesheet">
	    <link href="./resources/css/bootstrap-theme.min.css" rel="stylesheet">
	    <script src="./resources/js/bootstrap.min.js"></script>
	    
	    <!-- JS -->
		<script src="./resources/js/login.js"></script>
		
		<!-- CSS -->
		<link href="./resources/css/login.css" rel="stylesheet">
		
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
       				<li><a href="index.jsp">Home</a></li>
       				<li><a href="#">About</a></li>
       				<li><a href="#">FAQs</a></li>
       				<li><a href="#">Contact Us</a></li>
      			</ul>
      			<ul class="nav navbar-nav navbar-right">
       				<li><a href="signup.jsp">Sign Up</a></li>
       				<li class="active"><a href="#">Log In</a></li>
      			</ul>
	     	</div>
		</nav>
		<div class="transbox fadein" align="center"> 
			<br>
			<h1>Log In</h1>
			<br>
			<h2> Email</h2>
			<input id="email" type="text"/>
			<h2>Password</h2>
			<input id="password" type="password"/>
			<br><br><br><br><br>
			<button onclick="login()">Log In</button>
			<br><br><br><br>
		</div>
	</body>
</html>