<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

var listaDatos;

function regresar(){
	$('#formRHC').attr('action',"/TP2_Villa/HC/listar");
	$('#formRHC').submit();
}

function validar(){
	$('#hdnIDCLIENTE').val('');
	$('#txtCLIENTE').val('');
	$('#txtMASCOTA').empty().append($('<option>', { 
        value: "-1",
        text : "Seleccione" 
    }));
	
	$.ajax({
		type:'GET',
		url: '/TP2_Villa/HC/validar',
		data: {
			tipoDoc: $('#txtTIPODOC').val(),
			numDoc: $('#txtNUMDOC').val()
		},
		success: function(data){
			listaDatos = data;
			if(data.length > 0){
				datos = data[0];
				$('#hdnIDCLIENTE').val(datos.idCliente);
				$('#txtCLIENTE').val(datos.datosCliente);
				$.each(data,function( index, element ) {
					if(element.idHC != 0 && element.idMascota != 0){
						$('#txtMASCOTA').append($('<option>', { 
					        value: element.idMascota,
					        text : element.datosMascota 
					    }));
					}
				});
			}else{
				mensajeModal("Cliente no encontrado.");
			}
		},
		error: function(e){
			console.log("error: " + e);
		}
	});
}

function mascota(id){
	$('#txtESPECIE').val('');
	$('#txtRAZA').val('');
	$('#txtGENERO').val('');
	
	$.each(listaDatos,function( index, element ) {
		if(element.idMascota == id){
			$('#txtESPECIE').val(element.descripcionEspecie);
			$('#txtRAZA').val(element.descripcionRaza);
			$('#txtGENERO').val(element.descripcionGenMascota);
			return;
		}
	});
}

function registrar(){
	var idMascota = $('#txtMASCOTA').val();
	
	if(idMascota == "-1"){
		mensajeModal("Seleccione alguna Mascota.");return false;
	}
	
	$('#formRHC').attr('action',"/TP2_Villa/HC/registrar");
	$('#formRHC').submit();	
}

</script>


<div class="container">
	<div class="page-header" align="center">
       <h1>Registrar Historia Clínica</h1>
    </div>

	<form class="form-horizontal" action="" id="formRHC" method="POST">
	<input type="hidden" id="hdnIDCLIENTE" name="hdnIDCLIENTE" value=""/>

    <div class="col-sm-12">
    	<div class="col-sm-8">
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtTIPODOC">TIPO DOCUMENTO:</label>
		        <div class="col-xs-5">
		            <select id="txtTIPODOC" class="form-control">
		            <c:forEach items="${listaTipoDoc}" var="doc">
			            <option value="${doc.id}">${doc.desc}</option>		            
		            </c:forEach>		            	
		            </select>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtNUMDOC">NÚMERO DOCUMENTO:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="txtNUMDOC" name="txtNUMDOC" class="form-control" value="" onkeydown="return isNumeric(event);"/>
		            <input type="button" id="btnVALIDAR" value="VALIDAR" class="btn btn-info" onclick="validar();"/>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtCLIENTE">CLIENTE:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtCLIENTE" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtMASCOTA">MASCOTA:</label>
		        <div class="col-xs-5">
		            <select type="text" id="txtMASCOTA" name="txtMASCOTA" class="form-control" onchange="mascota(this.value);">
		            	<option value="-1">Seleccione</option>
		            </select>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtESPECIE">ESPECIE:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtESPECIE" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtRAZA">RAZA:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtRAZA" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
	        <div class="form-group">
		        <label class="control-label col-xs-3" for="txtGENERO">GÉNERO:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtGENERO" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtEDAD">EDAD:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtEDAD" name="txtEDAD" class="form-control" maxlength="3" onkeydown="return isNumeric(event);"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtOBS">OBSERVACIÓN:</label>
		        <div class="col-xs-5">
		        	<textarea class="form-control" id="txtOBS" name="txtOBS" rows="3" cols="100" maxlength="255"></textarea>
		        </div>
	        </div>
	    </div>
        <div class="col-sm-4" align="left">
        	<img class="thumbnail" alt="IMG" src="/TP2_Villa/static/img/x.png" width="150px" height="150px">
        </div>
    </div>
    
    <br>
    <div class="form-group">
        <div class="col-sm-3" align="left">
        	<input type="button" class="btn btn-primary" value="REGRESAR" onclick="regresar();"/>
	    </div>
        <div class="col-sm-3" align="center">
        	<input type="button" class="btn btn-success" value="GRABAR" onclick="registrar();"/>
        </div>
    </div>
</form>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>