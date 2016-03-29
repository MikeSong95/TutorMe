function editInfo() {
	window.location.href="editStudentProfile.jsp";
}

function editCourses() {
	window.location.href="courses.jsp";
}

function submit() {
	var firstName = $('#firstName').val();
	var lastName = $('#lastName').val();
	var email = $('#email').val();
		
	if (validEmail(email)) {
		var data = {
			type: "student",
			firstName: firstName,
			lastName: lastName,
			email: email,
		};
		$.ajax({
			type: "POST",
			url: "EditProfileServlet",
			data: data,
			success: function(success) {
				if (success === "success") {
					alert("Successfully updated profile.");
					window.location.href="studentProfile.jsp";
				} else {
					alert("An error has occurred.")
				}
			}
		});			
	} else {
		alert("The email you have entered is invalid");
	}
} 


function validEmail (email) {	
	var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}