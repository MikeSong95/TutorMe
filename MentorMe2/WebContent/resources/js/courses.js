var courseCounter = 0;
var courses = [];
var schoolAttending;
var programStudy;

function programs(school) {
	if (school === "uoft") {
		schoolAttending = "uoft";
		$('#uoft_programs').show();
		$('#uoft').attr('class', 'info');
		$('#spacingTable').hide();
		$('#western_programs').hide();
		
		if ($('#western').attr('class') === 'info') {
			$('#western').removeAttr('class');
		}
		
		$('.hideAllCourses').hide();
		programStudy = undefined;
	} else if (school === "western") {
		schoolAttending = "western";
		$('#western_programs').show();
		$('#western').attr('class', 'info');
		$('#spacingTable').hide();
		$('#uoft_programs').hide();
		
		if ($('#uoft').attr('class') === 'info') {
			$('#uoft').removeAttr('class');
		}
		
		$('.hideAllCourses').hide();
		programStudy = undefined;
	}
	
	$('#uoft_compsci').removeAttr('class');
	$('#uoft_compeng').removeAttr('class');
	$('#western_chemistry').removeAttr('class');
}

function uoftCourses(program) {
	if (program === "compeng") {
		programStudy = "compEng"
		$('#uoft_courses_compsci').hide();
		$('#uoft_compsci').removeAttr('class');
		
		// Remove courses
		for (var i = 0; i < courseCounter; i++) {
			$('#' + window.courses[i]).removeAttr('class');
		}
		
		courses = [];
		
		// Reset course counter
		window.courseCounter = 0;
	} else if (program === "compsci") {
		programStudy = "compSci"
		$('#uoft_courses_compeng').hide();
		$('#uoft_compeng').removeAttr('class');

		// Remove courses
		for (var j = 0; j < courseCounter; j++) {
			$('#' + window.courses[j]).removeAttr('class');
		}
		
		courses = [];

		// Reset course counter
		window.courseCounter = 0;
	}
	
	$('#western_courses_chemistry').hide();
	$('.hideAllCourses').show();
	$('#uoft_courses_' + program).show();
	
	$('#uoft_' + program).attr('class', 'info');
}

function westernCourses(program) {
	programStudy = "chemistry"

	// Remove courses
	for (var j = 0; j < courseCounter; j++) {
		$('#' + window.courses[j]).removeAttr('class');
	}
	
	courses = [];

	// Reset course counter
	window.courseCounter = 0;
	$('#uoft_courses_compeng').hide();
	$('#uoft_courses_compsci').hide();
	$('.hideAllCourses').show();
	$('#western_courses_' + program).show();

	$('#western_' + program).attr('class', 'info');
}

$('td[data-toggle="tooltip"]').tooltip({
    animated: 'fade',
    placement: 'bottom',
});

function courseClicked(course) {
	if ($('#' + course).attr('class') === "info") {
		$('#' + course).removeAttr('class');
		
		// Remove course from array
		for (var i = 0; i < window.courses.length; i++) {
			if (window.courses[i] === course) {
				window.courses.splice(i, 1);
			}
		}
		
		window.courseCounter--;
	} else if (window.courseCounter < 4) {
		$('#' + course).attr('class', 'info');
		
		// Add course to array
		window.courses[window.courseCounter] = course;
		window.courseCounter++;
	} else {
		alert("You may only select a max of 4 courses.");		
	}
}

function submit() {
	if (schoolAttending !== undefined) {
		if (programStudy !== undefined) {
			if (courseCounter !== 0) {
				var data = {
					school: schoolAttending,
					program: programStudy,
					course1: courses[0],
					course2: courses[1],
					course3: courses[2],
					course4: courses[3]
				};
				
				$.ajax ({
					type: "post",
					url: "CoursesServlet",
					data: data,
					success: function(success) {
						alert(success);
						if (success.equals("success")) {
							window.location.href="welcome.jsp";
						} else {
							alert("An error has occurred.")
						}
					}
				});
			} else {
				alert("Please select at least one course.");
			}
		} else {
			alert("Please select a program of study.");
		}
	} else {
		alert("Please select a school.");
	}
}
