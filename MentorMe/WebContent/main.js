




function callAPI(){


var element= $("#msg");

element.append("<h2>Sending....</h2>");

$.ajax({
    url: '/servlet',
    type: 'GET',
    datatype: 'JSON',
    headers: {
      Accept:"application/json",
      "Access-Control-Allow-Origin": "*"
    },
    success: function(data) {
      
      element.append("<br><h2>Message Received: "+ JSON.stringify(data)+ " + YAY!");

    },
    error: function(data){

      alert(data);
    }
});



}
