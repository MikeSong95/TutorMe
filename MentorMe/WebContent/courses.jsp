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
		<script src="./resources/js/courses.js"></script>
		
		<!-- CSS -->
		<link href="./resources/css/courses.css" rel="stylesheet">
		
		<title>TutorMe</title>
	</head>
	<body>
		<!-- Background Image -->
		<div id="background">
  			<img class="stretch" src="./resources/images/splash_img.jpg" alt="background">
		</div>
		<div id="con">
			<div  id="content" >
				<h1 align="center"> Course Tutoring Selection </h1>
				<div class="col-sm-4 fadein" align="center">
					<h2 align="center">School</h2>
					<div class="transbox">
						<table class="table table-hover">
							<tr>
								<td id="uoft" onclick="programs('uoft')">University of Toronto</td>
							</tr>
							<tr>
								<td id="western" onclick="programs('western')">University of Western Ontario</td>
							</tr>
						</table>
					</div>
				</div>
				<div class="col-sm-4 fadein" align="center">
					<h2 align="center">Program of Study</h2>
					<div class="transbox">
						<div class="fadein" id="uoft_programs" style="display:none">
							<table class="table table-hover">
								<tr>
									<td id="uoft_compeng" onclick="uoftCourses('compeng')">Computer Engineering</td>
								</tr>
								<tr>
									<td id="uoft_compsci" onclick="uoftCourses('compsci')">Computer Science</td>
								</tr>
							</table>
						</div>
					</div>
					<div class="transbox">
						<div class="fadein" id="western_programs" style="display:none">
							<table class="table table-hover">
								<tr>
									<td id="western_chemistry" onclick="westernCourses('chemistry')">Chemistry</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<div class="col-sm-4 fadein" align="center">
					<h2 align="center">Courses (Max 4)</h2>	
					<div class="transbox">
						<div class="hideAllCourses" style="display:none">
							<div class="fadein" id="uoft_courses_compeng" style="display:none">
								<table class="table table-hover">
									<tr>
										<td id="aps105" onclick="courseClicked('aps105')" data-toggle="tooltip" title="An introduction to computer systems and problem solving using computers. Topics include: the representation of information, programming techniques, programming style, basic loop structures, functions, arrays, strings, pointer-based data structures and searching and sorting algorithms. The laboratories reinforce the lecture topics and develops essential programming skills.">   
			        						APS 105: Computer Fundamentals
										</td>
									</tr>
									<tr>
										<td id="mat186" onclick="courseClicked('mat186')" data-toggle="tooltip" title="Topics include: limits and continuity; differentiation; applications of the derivative – related rates problems, curve sketching, optimization problems, L'Hopital's rule; definite and indefinite integrals; the Fundamental Theorem of Calculus; applications of integration in geometry, mechanics and other engineering problems.">
											MAT 186: Calculus 1
										</td>
									</tr>
									<tr>
										<td id="ece212" onclick="courseClicked('ece212')" data-toggle="tooltip" title="Nodal and loop analysis and network theorems. Natural and forced response of RL, RC, and RLC circuits. Sinusoidal steady-state analysis. Frequency response; resonance phenomena; poles and zeros; applications of the Laplace transform.">
											ECE 212: Circuit Analysis
										</td>
									</tr>
									<tr>
										<td id="ece216" onclick="courseClicked('ece216')" data-toggle="tooltip" title="Fundamental discrete- and continuous-time signals, definition and properties of systems, linearity and time invariance, convolution, impulse response, differential and difference equations, Fourier analysis, sampling and aliasing, applications in communications.">
											ECE 216: Signals and Systems
										</td>
									</tr>
									<tr>
										<td id="ece320" onclick="courseClicked('ece320')" data-toggle="tooltip" title="Voltage and current waves on a general transmission line, reflections from the load and source, transients on the line, and Smith’s chart. Maxwell’s equations, electric and magnetic fields wave equations, boundary conditions, plane wave propagation, reflection and transmission at boundaries, constitutive relations, dispersion, polarization; Poynting vector; waveguides.">
											ECE 320: Fields and Waves
										</td>
									</tr>
									<tr>
										<td id="ece344" onclick="courseClicked('ece344')" data-toggle="tooltip" title="Operating system structures, concurrency, synchronization, deadlock, CPU scheduling, memory management, file systems. The laboratory exercises will require implementation of part of an operating system.">
											ECE 344: Operating Systems
										</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="hideAllCourses" style="display:none">
							<div class="fadein" id="uoft_courses_compsci" style="display:none">
								<table class="table table-hover">
									<tr>
										<td id="csc148" onclick="courseClicked('csc148')" data-toggle="tooltip" title="Abstract data types and data structures for implementing them. Linked data structures. Encapsulation and information-hiding. Object-oriented programming. Specifications. Analyzing the efficiency of programs. Recursion.">   
			        						CSC 148: Introduction to Computer Science
										</td>
									</tr>
									<tr>
										<td id="csc209" onclick="courseClicked('csc209')" data-toggle="tooltip" title="Software techniques in a Unix-style environment, using scripting languages and a machine-oriented programming language (typically C). What goes on in the operating system when programs are executed. Core topics: creating and using software tools, pipes and filters, file processing, shell programming, processes, system calls, signals, basic network programming.">
											CSC 209: Software Tools and Systems Programming
										</td>
									</tr>
									<tr>
										<td id="csc258" onclick="courseClicked('csc258')" data-toggle="tooltip" title="Computer structures, machine languages, instruction execution, addressing techniques, and digital representation of data. Computer system organization, memory storage devices, and microprogramming. Block diagram circuit realizations of memory, control and arithmetic functions.">
											CSC 258: Computer Organization
										</td>
									</tr>
									<tr>
										<td id="csc263" onclick="courseClicked('csc263')" data-toggle="tooltip" title="Algorithm analysis: worst-case, average-case, and amortized complexity. Expected worst-case complexity, randomized quicksort and selection.  Standard abstract data types, such as graphs, dictionaries, priority queues, and disjoint sets. A variety of data structures for implementing these abstract data types, such as balanced search trees, hashing, heaps, and disjoint forests. Design and comparison of data structures. Introduction to lower bounds.">
											CSC 263: Data Structures and Analysis
										</td>
									</tr>
								</table>
							</div>
						</div>
						<div class="hideAllCourses" style="display:none">
							<div class="fadein" id="western_courses_chemistry" style="display:none">
								<table class="table table-hover">
									<tr>
										<td id="chemistry1301" onclick="courseClicked('chemistry1301')" data-toggle="tooltip" title="An introduction to the foundational principles of chemical structure and properties, emphasizing their relevance to modern science. Topics include: atomic structure, theories of chemical bonding, structure and stereochemistry of organic molecules, and structure of coordination complexes.">   
			        						Chemistry 1301: Discovering Chemical Structures
										</td>
									</tr>
									<tr>
										<td id="chemistry2214" onclick="courseClicked('chemistry2214')" data-toggle="tooltip" title="Basic thermodynamic concepts and relations and illustration of their relevance and applications to biological systems. In addition, some aspects of electrochemistry, and spectroscopic techniques will be introduced, again with emphasis on the role of these techniques in understanding the structure and nature of important biological molecules.">
											Chemistry 2214: Physical Chemistry for Life Sciences
										</td>
									</tr>
									<tr>
										<td id="chemistry3320" onclick="courseClicked('chemistry3320')" data-toggle="tooltip" title="A comprehensive treatment of the preparation and uses of polymers, and their chemical and physical properties in the solid state and in solution.">
											Chemistry 3320: Polymer Chemistry
										</td>
									</tr>
									<tr>
										<td id="chemistry3391" onclick="courseClicked('chemistry3391')" data-toggle="tooltip" title="The role of the chemical elements and their compounds in biology. The emphasis will be on the functional and mechanistic aspects of the biological chemistry of the metallic elements. The toxicology and medicinal chemistry of metal ions will also be discussed.">
											Chemistry 3391: Bioinorganic Chemistry
										</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div  id="footer" align="center">
				<button onclick="submit()" type="submit">Submit</button>
			</div>
		</div>
	</body>
</html>