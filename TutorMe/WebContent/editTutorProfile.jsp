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
		<script src="./resources/js/editTutorProfile.js"></script>
		
		<!-- CSS -->
		<link href="./resources/css/editTutorProfile.css" rel="stylesheet">
		
		<title>TutorMe</title>
	</head>
	<body>
		<%@ page import="control.UserController, user.*" %>
		<%  
			String tutorEmail = (String) session.getAttribute("tutorEmail");
			Tutor tutor = UserController.getInstance().getTutor(tutorEmail);
        %>
		<!-- Background Image -->
		<div id="background">
  			<img class="stretch" src="./resources/images/splash_img.jpg" alt="background">
		</div>
		<!-- Navbar -->
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
 				<ul class="nav navbar-nav">
       				<li><a href="tutorProfileLogin.jsp">Profile</a></li>
      			</ul>
      			<ul class="nav navbar-nav navbar-right">
       				<li><a href="index.jsp">Logout</a></li>
      			</ul>
	     	</div>
		</nav>
		<div id="con">
			<div  id="content" >
				<div class="transbox fadein">
					<h1>Edit Profile</h1>
					<div align="center">
						<input id="firstName" type="text" value="<%out.print(tutor.getFirst());%>"> <input id="lastName" type="text" value="<%out.print(tutor.getLast());%>">
					</div>
					<div align="center">
						<input id="email" type="text" value="<%out.print(tutor.getEmail());%>">
					</div>
					<div class="col-sm-6">
						<h3> Program Attended: </h3>
						<div class="dropdown">
							<button id="progBtn" value="<%out.print(tutor.getProgramAttended());%>" class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
		 							<%out.print(tutor.getProgramAttended());%>
		 							<span class="caret"></span>
							</button>
							<ul id="prog" class="dropdown-menu" aria-labelledby="dropdownMenu2">
								<li><a href="#">Computer Engineering</a></li>
								<li><a href="#">Computer Science</a></li>
								<li><a href="#">Electrical Engineering</a></li>
							</ul>
						</div>
						<h3> Degree:</h3> 
						<div class="dropdown">
							<button id="degreeBtn" value="<%out.print(tutor.getDegree());%>" class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
		 							<%out.print(tutor.getDegree());%>
		 							<span class="caret"></span>
							</button>
							<ul id="degree" class="dropdown-menu" aria-labelledby="dropdownMenu2">
								<li><a href="#">Bachelor's</a></li>
								<li><a href="#">Master's</a></li>
								<li><a href="#">Ph.D</a></li>
							</ul>
						</div>
						<h3> School Attended: </h3> 
						<div class="dropdown">
							<button id="almaMaterBtn" value="<%out.print(tutor.getSchoolAttended());%>" class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
		 							<%out.print(tutor.getSchoolAttended());%>
		 							<span class="caret"></span>
							</button>
							<ul id="almaMater" class="dropdown-menu" aria-labelledby="dropdownMenu1">
								<li><a href="#">University of Toronto</a></li>
								<li><a href="#">Western University</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-6">
						<h3> School Tutoring At:</h3> <h4><%out.print(tutor.getSchool()); %></h4>
						<h3> Program Tutoring: </h3> <h4><%out.print(tutor.getProgram()); %></h4>
						
						<h3> Courses Tutoring: </h3>
							<% String[] courses = {tutor.getCourse1(), tutor.getCourse2(), tutor.getCourse3(), tutor.getCourse4()};
								for (int i = 0; i < courses.length; i++) {
									if (courses[i] != null) { %>
										<h4> <%out.print(courses[i]);%>	</h4>
								<%  } 
								}
								%>
					</div>
					<br><br><br><br><br><br><br><br><br><br><br><br>
				</div>
			</div>
			<div  id="footer" align="center">
				<button onclick="submit()" type="submit">Submit</button>
			</div>
		</div>
	</body>
</html>