<html>
    <head>
    
        <title>Register form</title>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
         <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
    	<script type="text/javascript">
        $(document).ready(function() {
            $('#DisplayAllUsers').click(function ()
            {
                $.ajax({
                    type: "post",
                    url: "DisplayAllUsers", //this is my servlet
                    success: function(msg){
                          	$('#output').empty();
                            $('#output').append(msg);
                    }
                });
            });

        });
    </script>
    </head>
    <body>
    	<h2>Welcome   <%= session.getAttribute("user") %> !</h2>
        
        <input id="DisplayAllUsers" type="submit" value="DisplayAllUsers" />
        
        <div id="output">
        </div>
        
        
    </body>
</html>