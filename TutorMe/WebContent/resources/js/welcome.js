$(document).ready(function() {
	$('#tutor1').mouseover(function() {
		$(this).css('border-style', 'inset');
	});
	$('#tutor1').mouseout(function() {
		$(this).css('border-style', 'outset');
	});

	$('#tutor2').mouseover(function() {
		$(this).css('border-style', 'inset');
	});
	$('#tutor2').mouseout(function() {
		$(this).css('border-style', 'outset');
	});

	$('#tutor3').mouseover(function() {
		$(this).css('border-style', 'inset');
	});
	$('#tutor3').mouseout(function() {
		$(this).css('border-style', 'outset');
	});

	$('#tutor4').mouseover(function() {
		$(this).css('border-style', 'inset');
	});
	$('#tutor4').mouseout(function() {
		$(this).css('border-style', 'outset');
	});
});

function tutorProfile(email) {
	$.ajax ({
		type: "GET",
		url: "TutorProfileServlet",
		data: {
			email: email
		},
		success: function(success) {
			if (success === "success") {
				window.location.href="tutorProfile.jsp";
			}
		}
	});
}

function editInfo() {
	window.location.href="editTutorProfile.jsp";
}

function editCourses() {
	window.location.href="courses.jsp";
}