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

function submit() {
	var firstName = $('#firstName').val();
	var lastName = $('#lastName').val();
	var email = $('#email').val();
	var degree = $("#degreeBtn").val();
	var school = $("#almaMaterBtn").val();
	var program = $("#progBtn").val();
	
	if (validEmail(email)) {
		var data = {
			type: "tutor",
			firstName: firstName,
			lastName: lastName,
			email: email,
			degree: degree,
			school: school,
			program: program
		};
		$.ajax({
			type: "POST",
			url: "EditProfileServlet",
			data: data,
			success: function(success) {
				if (success === "success") {
					alert("Successfully updated profile.");
					window.location.href="tutorProfileLogin.jsp";
				} else {
					alert("An acocunt with that email already exists.")
				}
			}
		});			
	} 
} 


function validEmail (email) {	
	var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}