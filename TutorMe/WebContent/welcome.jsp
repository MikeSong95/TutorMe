<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
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
		
		<% 
			UserController controller = new UserController();
			String email = (String) session.getAttribute("email");

			Student student = controller.getStudent(email);

			String studentName = student.getFirst() + " " + student.getLast();
    		String username = (String) session.getAttribute("username");
			Tutor[] recommendedTutors = null;
			
			recommendedTutors = controller.getRecommendTutor(email);
		
			String tutorEmail1 = recommendedTutors[0].getEmail();
			String tutorName1 = recommendedTutors[0].getFirst() + " " + recommendedTutors[0].getLast();
			String tutorDegree1 = recommendedTutors[0].getDegree() + " " + recommendedTutors[0].getProgramAttended();
			String tutorSchoolAttended1 = recommendedTutors[0].getSchoolAttended();

			String tutorEmail2 = recommendedTutors[1].getEmail();
			String tutorName2 = recommendedTutors[1].getFirst() + " " + recommendedTutors[1].getLast();
			String tutorDegree2 = recommendedTutors[1].getDegree() + " " + recommendedTutors[1].getProgramAttended();
			String tutorSchoolAttended2 = recommendedTutors[1].getSchoolAttended();

			String tutorEmail3 = recommendedTutors[2].getEmail();
			String tutorName3 = recommendedTutors[2].getFirst() + " " + recommendedTutors[2].getLast();
			String tutorDegree3 = recommendedTutors[2].getDegree() + " " + recommendedTutors[2].getProgramAttended();
			String tutorSchoolAttended3 = recommendedTutors[2].getSchoolAttended();

			String tutorEmail4 = recommendedTutors[3].getEmail();
			String tutorName4 = recommendedTutors[3].getFirst() + " " + recommendedTutors[3].getLast();
			String tutorDegree4 = recommendedTutors[3].getDegree() + " " + recommendedTutors[3].getProgramAttended();
			String tutorSchoolAttended4 = recommendedTutors[3].getSchoolAttended();
		%>
	</head>
	<body>
		<%@ page import="control.UserController, user.*" %>
		
			
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
      			<ul class="nav navbar-nav navbar-right">
       				<li><a href="studentProfile.jsp"><%out.print(session.getAttribute("name"));%>'s Profile</a></li>
      			</ul>
	     	</div>
		</nav>
		<div id="con">
			<div  id="content" >
				<h1 align="center"> Welcome <%= studentName%>!</h1>
				<h2 align="center">Recommended Tutors:</h2>
				<p align="center"> Click a tutor for more details.</p>
					<div class="col-sm-3 fadein" align="center">
						<div id="tutor1" class="transbox" onclick="tutorProfile('<%=tutorEmail1%>')">
							<h3><%=tutorName1%> </h3>
							<h4><%=tutorDegree1%></h4>
							<h4><%=tutorSchoolAttended1%></h4>
							<%
								String[] courses = {recommendedTutors[0].getCourse1(), recommendedTutors[0].getCourse2(), recommendedTutors[0].getCourse3(), recommendedTutors[0].getCourse4()};
							
								for (int i = 0; i < courses.length; i++) {
									if (courses[i] != null) {
							%>
										<h5><%out.print(courses[i]);%></h5>
							<%			
									}
								}
							%>
						</div>
					</div>	
					<div class="col-sm-3 fadein" align="center">
						<div id="tutor2" class="transbox" onclick="tutorProfile('<%=tutorEmail2%>')">
							<h3><%=tutorName2%> </h3>
							<h4><%=tutorDegree2%></h4>
							<h4><%=tutorSchoolAttended2%></h4>
							<%
								String[] courses2 = {recommendedTutors[1].getCourse1(), recommendedTutors[1].getCourse2(), recommendedTutors[1].getCourse3(), recommendedTutors[1].getCourse4()};
							
								for (int i = 0; i < courses2.length; i++) {
									if (courses2[i] != null) {
							%>
										<h5><%out.print(courses2[i]);%></h5>
							<%			
									}
								}
							%>
						</div>
					</div>	
					<div class="col-sm-3 fadein" align="center">
						<div id="tutor3" class="transbox" onclick="tutorProfile('<%=tutorEmail3%>')">
							<h3><%=tutorName3%> </h3>
							<h4><%=tutorDegree3%></h4>
							<h4><%=tutorSchoolAttended3%></h4>
							<%
								String[] courses3 = {recommendedTutors[2].getCourse1(), recommendedTutors[2].getCourse2(), recommendedTutors[2].getCourse3(), recommendedTutors[2].getCourse4()};
							
								for (int i = 0; i < courses3.length; i++) {
									if (courses3[i] != null) {
							%>
										<h5><%out.print(courses3[i]);%></h5>
							<%			
									}
								}
							%>
						</div>
					</div>
					<div class="col-sm-3 fadein" align="center">
						<div id="tutor4" class="transbox" onclick="tutorProfile('<%=tutorEmail4%>')">
							<h3><%=tutorName4%> </h3>
							<h4><%=tutorDegree4%></h4>
							<h4><%=tutorSchoolAttended4%></h4>
							<%
								String[] courses4 = {recommendedTutors[3].getCourse1(), recommendedTutors[3].getCourse2(), recommendedTutors[3].getCourse3(), recommendedTutors[3].getCourse4()};
							
								for (int i = 0; i < courses4.length; i++) {
									if (courses4[i] != null) {
							%>
										<h5><%out.print(courses4[i]);%></h5>
							<%			
									}
								}
							%>
						</div>
					</div>
				</div>
		</div>
	</body>
</html>
