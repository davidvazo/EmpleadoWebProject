 function saveDepartamento(id){
		$.ajax({
			type: "POST",
			url: "altaDepartamento",
			data:$(id).serialize(),
			success: function(data){
				 var error=data;
					if(data == ""){
						alert('El departamento fue guardado exitosamente');
					}else{
			        	alert('Se encontro un Error al guardar el departamento __'+error);
					}
	        reset('#departamentoAltaForm');
	        getProveedores();
	      	$('#closePop').trigger('click')
	    },error:function(data){
	    	 alert('Se encontro un Error al guardar departamento');
	    }});
	} 