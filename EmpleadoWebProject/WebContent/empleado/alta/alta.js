$(document).ready(function() {
	
    $('#submit').click(function() {
/*    	$(".anormal").addClass("normal");   */
    	$.ajax({
        	type: "POST",
            url : 'EmpleadoServlet',
            dataType: "json",
            data : {
            	ssn : $('#ssn').val(),
            	nombre : $('#nombre').val(),
            	edad : $('#edad').val(),
            	sueldo : $('#sueldo').val(),
            	curp : $('#curp').val()
            	
            },
            error:function(data) {
            	alert("Error: Contacte al administrador ja-ja \n Codigo de error: "+ data.status);
            	
            	console.log("");
            },
            success : function(data) {
            	if (data.success == true  ){
            		console.log(data);
            	} else {
            		
            		var foo = data.message.replace("|","\n");
            		alert(foo);
            		
            		for(var i=0; i<data.inputerror.length; i++){
            			var aidi = data.inputerror[i];
            			$("#"+aidi).removeClass();
            			$("#"+aidi).addClass("anormal");
            			console.log("aiid: " + aidi);
            		}
            	}
            }
        });  /* ajax() */
   }); /* #submit() */
}); /* document() */