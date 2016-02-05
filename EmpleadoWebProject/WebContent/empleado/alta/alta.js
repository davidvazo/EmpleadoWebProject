$(document).ready(function() {
    $('#submit').click(function() {
    	$.ajax({
        	type: "POST",
            url : 'UserServlet',
            data : {
            	ssn : $('#ssn').val(),
            	nombre : $('#nombre').val(),
            	edad : $('#edad').val(),
            	sueldo : $('#sueldo').val(),
            	curp : $('#curp').val()
            	
            },
            /*dataType: 'json',*/
            success : function(response) {
            	alert(response);
            }
        });  /* ajax() */
   }); /* #submit() */
}); /* document() */