$(function(){
	funcionesgenerales();
});

function funcionesgenerales(){
	$('#btnBuscar').click(function(){
		
		var nomb=$("#nombre").val();
		var descrip=$("#descripcion").val();
		var idEsta=$("#idEst").val();
		var idEspe=$("#idEsp").val();
		
		$.ajax({
			
			url: "actualizarTipoExamen/buscar",
			async : true,
			type: "get",
			data: {
				nombre: nomb,
				descripcion: descrip,
				idEst: idEsta,
				idEsp: idEspe
			},
			success: function(result){
				crearFormulario(result);
			}
		});
	});
	
	$('#btnNuevo').click(function(){
		window.location="actualizarTipoExamen/nuevoTipoExamen";
	});
	
}

function crearFormulario(respuesta) {
	var contenido="";
	for(var i=0;i<respuesta.listaTiposExamenesMedicos.length;i++){
		contenido=contenido+"<tr class=\"odd gradeX\"><td>"+respuesta.listaTiposExamenesMedicos[i].codigoTipoExamen+"</td><td>"+respuesta.listaTiposExamenesMedicos[i].nombreTipoExamen+"</td><td>"+respuesta.listaTiposExamenesMedicos[i].descripcionExamen+"</td><td>"+respuesta.listaTiposExamenesMedicos[i].nombreEspecialidad+"</td></tr>";
		
	}
	$('#tbDetalleOrdenCompra').html("");
	$('#tbDetalleOrdenCompra').html(contenido);
	
}
