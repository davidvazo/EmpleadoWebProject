$(document).ready(function() {
    $('#submit').click(function() {    	
    	$.ajax({
			type: "POST",
			url: "DepartamentoAltaServlet",
			data:$("#formAltaDepartamento").serialize(),
			success: function(response){				
				alert(response);
	    },error:function(data){
	    	 alert('Se encontro un Error al guardar departamento');
	    }
    }); /* $.ajax */
  }); /* #submit.click() */
}); /* (document).ready   */