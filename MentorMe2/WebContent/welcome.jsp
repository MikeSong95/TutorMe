<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<!-- jQuery -->
	    <script src="./resources/js/jquery-1.11.3.min.js"></script>
	    
	    <!-- Bootstrap -->
	    <link href="./resources/css/bootstrap.min.css" rel="stylesheet">
	    <link href="./resources/css/bootstrap-theme.min.css" rel="stylesheet">
	    <script src="./resources/js/bootstrap.min.js"></script>
	    
	    <!-- JS -->
		<script src="./resources/js/welcome.js"></script>
		
		<!-- CSS -->
		<link href="./resources/css/welcome.css" rel="stylesheet">
		
		<title>TutorMe</title>
	</head>
	<body>
		<%  
    		String username = (String) session.getAttribute("username");
        %>
		<!-- Background Image -->
		<div id="background">
  			<img class="stretch" src="./resources/images/splash_img.jpg" alt="background">
		</div>
		<!-- Navbar -->
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
 				<ul class="nav navbar-nav">
       				<li class="active"><a href="welcome.jsp">Dashboard</a></li>
       				<li><a href="#">Browse Tutors</a></li>
      			</ul>
      			<ul class="nav navbar-nav navbar-right">
       				<li><a href="#"><%out.print(username);%>'s Profile</a></li>
      			</ul>
	     	</div>
		</nav>
		<div id="con">
			<div  id="content" >
				<h1 align="center"> Welcome <% out.print(username);%>!</h1>
				<h2 align="center">Recommended Tutors:</h2>
				<p align="center"> Click a tutor for more details.</p>
					<div class="col-sm-3 fadein" align="center">
						<div id="tutor1" class="transbox">
							<h3>Mike Song</h3>
							<h4>Ph.D, Computer Engineering</h4>
							<h4>University of Toronto</h4>
							<h5>Course 1</h5>
							<h5>Course 1</h5>
						</div>
					</div>	
					<div class="col-sm-3 fadein" align="center">
						<div id="tutor2" class="transbox">
							<h3>Mike Song</h3>
							<h4>Ph.D, Computer Engineering</h4>
							<h4>University of Toronto</h4>
							<h5>Course 1</h5>
							<h5>Course 1</h5>
							<h5>Course 1</h5>
						
						</div>
					</div>	
					<div class="col-sm-3 fadein" align="center">
						<div id="tutor3" class="transbox">
							<h3>Mike Song</h3>
							<h4>Ph.D, Computer Engineering</h4>
							<h4>University of Toronto</h4>
							<h5>Course 1</h5>
							<h5>Course 1</h5>
							<h5>Course 1</h5>
							<h5>Course 1</h5>
						</div>
					</div>	
					<div class="col-sm-3 fadein" align="center">
						<div id="tutor4" class="transbox">
							<h3>Mike Song</h3>
							<h4>Ph.D, Computer Engineering</h4>
							<h4>University of Toronto</h4>
							<h5>Course 1</h5>
							<h5>Course 1</h5>
						</div>
					</div>	
				</div>
			<div  id="footer" align="center">
				<button onclick="submit()" type="submit">View More</button>
			</div>
		</div>
	</body>
</html>
