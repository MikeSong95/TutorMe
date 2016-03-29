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
		<link href="./resources/css/tutorProfile.css" rel="stylesheet">
		
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
       				<li class="active"><a href="tutorProfileLogin.jsp">Profile</a></li>
      			</ul>
      			<ul class="nav navbar-nav navbar-right">
       				<li><a href="index.jsp">Logout</a></li>
      			</ul>
	     	</div>
		</nav>
		<div class="transbox fadein">
			<h1 align="center"><%out.print(tutor.getFirst() + " " + tutor.getLast());%></h1>
			<h2 align="center"><%out.print(tutor.getEmail()); %></h2>
			<div class="col-sm-6">
				<h3> Program Attended: </h3><h4> <%out.print(tutor.getProgramAttended()); %></h4>
				<h3> Degree:</h3> <h4> <%out.print(tutor.getDegree()); %></h4>
				<h3> School Attended: </h3> <h4><%out.print(tutor.getSchoolAttended()); %></h4>
				<div align="center">
					<button onclick="editInfo()">Edit Info</button>
				</div>
			</div>
			<div class="col-sm-6">
				<h3> School Tutoring At:</h3> <h4><%out.print(tutor.getSchool()); %></h4>
				<h3> Program Tutoring: </h3><h4><%out.print(tutor.getProgram()); %></h4>
				<h3> Courses Tutoring: </h3>
					<% String[] courses = {tutor.getCourse1(), tutor.getCourse2(), tutor.getCourse3(), tutor.getCourse4()};
						for (int i = 0; i < courses.length; i++) {
							if (courses[i] != null) { %>
								<h4> <%out.print(courses[i]);%>	</h4>
						<%  } 
						}
						%>
				<div align="center">
					<button onclick="editCourses()">Edit Courses</button>
				</div>
			</div>
			<br><br><br><br><br><br><br><br><br><br><br><br><br>
		</div>
	</body>
</html>