$(document).ready(function() {
    $('#submit').click(function() {
    	alert($("#formAltaDepartamento").serialize());
    	$.ajax({
			type: "POST",
			url: "DepartamentoAltaServlet",
			data:$("#formAltaDepartamento").serialize(),
			success: function(data){
				 var error=data;
					if(data == ""){
						alert('El departamento fue guardado exitosamente');
					}else{
			        	alert('Se encontro un Error al guardar el departamento __'+error);
					}
	        reset('departamentoAltaForm');
	    },error:function(data){
	    	 alert('Se encontro un Error al guardar departamento');
	    }
    	}); /* $.ajax */
    }); /* #submit.click() */
}); /* (document).ready   */