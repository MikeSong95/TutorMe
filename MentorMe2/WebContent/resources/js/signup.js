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
	isFormValid_tutor();
}

function toCoursesPage_student() {
	isFormValid_student();
}

// Error handling for student form
function isFormValid_student() {
	var firstName = $('#studentFirstName').val();
	var lastName = $('#studentLastName').val();
	var email = $('#studentEmail').val();
	var password = $('#studentPassword').val();
	var confirmPassword = $('#studentConfirmPassword').val();
	var isSuccess;
	
	if (firstName && lastName && email && password) {
		if (validEmail(email)) {
			if (confirmPasswordMatches(password, confirmPassword)) {
				var data = {
					type: "student",
					firstName: firstName,
					lastName: lastName,
					email: email,
					password: password
				};
				$.ajax({
					type: "POST",
					url: "SignupServlet",
					data: data,
					success: function(success) {
						if (success === "success") {
							window.location.href="courses.jsp";
						} else {
							alert("An acocunt with that email already exists.")
						}
					}
				});
			} else {
				alert("The passwords do not match. Please enter again.");
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
			if (confirmPasswordMatches(password, confirmPassword)) {
				var data = {
					type: "tutor",
					firstName: firstName,
					lastName: lastName,
					email: email,
					password: password,
					degree: degree,
					school: school,
					program: program
				};
				$.ajax({
					type: "POST",
					url: "SignupServlet",
					data: data,
					success: function(success) {
						if (success === "success") {
							window.location.href="courses.jsp";
						} else {
							alert("An acocunt with that email already exists.")
						}
					}
				});			
			} else {
				alert("The passwords do not match. Please enter again.");
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

function confirmPasswordMatches (password, confirmPassword) {
	return password === confirmPassword;
}
