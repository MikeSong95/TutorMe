function tutorForm() {
	$('#intro').hide();
	$('#tutorForm').show();
}

function studentForm() {
	$('#intro').hide();
	$('#studentForm').show();
}

$(function(){
    $("#almaMater li a").click(function(){
    	$("#almaMaterBtn").html($(this).text() + ' <span class="caret"></span>');
    	$("#almaMaterBtn").val($(this).text());
   });
});

$(function(){
    $("#prog li a").click(function(){
    	$("#progBtn").html($(this).text() + ' <span class="caret"></span>');
    	$("#progBtn").val($(this).text());
   });
});

$(function(){
    $("#degree li a").click(function(){
    	$("#degreeBtn").html($(this).text() + ' <span class="caret"></span>');
    	$("#degreeBtn").val($(this).text());
   });
});

function toCoursesPage_tutor() {
	if (isFormValid_tutor()) {
		window.location.href="courses.jsp";
	}
}

function toCoursesPage_student() {
	if (isFormValid_student()) {
		window.location.href="courses.jsp";
	}
}

function isFormValid_student() {
	var firstName = $('#studentFirstName').val();
	var lastName = $('#studentLastName').val();
	var email = $('#studentEmail').val();
	var password = $('#studentPassword').val();
	var confirmPassword = $('#studentConfirmPassword').val();
	
	if (firstName && lastName && email && password) {
		if (validEmail(email)) {
			if (isUniqueEmail(email)) {
				if (confirmPasswordMatches(password, confirmPassword)) {
					// Call to student signup servlet to add student to database
				} else {
					alert("The passwords do not match. Please enter again.");
				}
			} else {
				alert("An account with this email has already been created.");
			}
		} else {
			alert("The email you have entered is not valid.");
		}
	} else {
		alert("Please fill in all fields.");
	}
}

function isFormValid_tutor() {
	var firstName = $('#tutorFirstName').val();
	var lastName = $('#tutorLastName').val();
	var email = $('#tutorEmail').val();
	var password = $('#tutorPassword').val();
	var confirmPassword = $('#tutorConfirmPassword').val();
	var degree = $("#degreeBtn").val();
	var school = $("#almaMaterBtn").val();
	var program = $("#progBtn").val();
	
	if (firstName && lastName && email && password && degree && school && program) {
		if (validEmail(email)) {
			if (isUniqueEmail(email)) {
				if (confirmPasswordMatches(password, confirmPassword)) {
					// Call to tutor signup servlet to add tutor to database
				} else {
					alert("The passwords do not match. Please enter again.");
				}
			} else {
				alert("An account with this email has already been created.");
			}
		} else {
			alert("The email you have entered is not valid.");
		}
	} else {
		alert("Please fill in all fields.");
	}
}

function validEmail (email) {	
	var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}

function isUniqueEmail(email) {
	// Call to signup servlet to see if email exists in database
}

function confirmPasswordMatches (password, confirmPassword) {
	return password === confirmPassword;
}
