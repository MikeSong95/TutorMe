function login() {
	var email = $("#email").val();
	var password = $("#password").val();
	
	if (email !== null) {
		if (password !== null) {
			isValidLogin(email, password);
		} else {
			alert("Please enter a password.");
		}
	} else {
		alert("Please enter an email.");
	}
}

function isValidLogin(email, password) {
	$.ajax({
		type: "GET",
		url: "LoginServlet",
		data: {
			email: email,
			password: password
		},
		success: function(success) {
			if (success === "student") {
				window.location.href="welcome.jsp";
			} else if (success === "tutor"){
				window.location.href="tutorProfileLogin.jsp";
			} else {
				alert("The email or password provided is incorrect.");
			}
		}
	});
}