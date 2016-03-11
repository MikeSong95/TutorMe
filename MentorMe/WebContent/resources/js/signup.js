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

