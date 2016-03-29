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
		<script src="./resources/js/studentProfile.js"></script>
		
		<!-- CSS -->
		<link href="./resources/css/tutorProfile.css" rel="stylesheet">
		
		<title>TutorMe</title>
	</head>
	<body>
		<%@ page import="control.UserController, user.*" %>
		<%  
			String email = (String) session.getAttribute("email");
			Student student = UserController.getInstance().getStudent(email);
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
      			</ul>
      			<ul class="nav navbar-nav navbar-right">
       				<li><a href="index.jsp">Logout</a></li>
      			</ul>
	     	</div>
		</nav>
		<div class="transbox fadein">
			<h1 align="center"><%out.print(student.getFirst() + " " + student.getLast());%></h1>
			<h2 align="center"><%out.print(student.getEmail()); %></h2>
				<h3> School:</h3> <h4><%out.print(student.getSchoolAttending()); %></h4>
				<h3> Program Tutoring: </h3><h4><%out.print(student.getProgramAttending()); %></h4>
				<h3> Courses Tutoring: </h3>
					<% String[] courses = {student.getCourse1(), student.getCourse2(), student.getCourse3(), student.getCourse4()};
						for (int i = 0; i < courses.length; i++) {
							if (courses[i] != null) { %>
								<h4> <%out.print(courses[i]);%>	</h4>
						<%  } 
						}
						%>
				<div align="center">
					<button onclick="editInfo()">Edit Info</button> <button onclick="editCourses()">Edit Courses</button>
				</div>
			</div>
			<br><br><br><br><br><br><br><br><br><br><br><br><br>
		</div>
	</body>
</html>