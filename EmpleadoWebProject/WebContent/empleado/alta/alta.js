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
            success : function(response) {
            	alert("Exitoso");
            }
        });  /* ajax() */
   }); /* #submit() */
}); /* document() */