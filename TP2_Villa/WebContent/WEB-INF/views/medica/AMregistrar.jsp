<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

var listaDatos;

function regresar(){
	$('#formRAM').attr('action',"/TP2_Villa/AM/inicio");
	$('#formRAM').submit();
}

function validar(){
	$('#hdnIDHC').val('');
	$('#txtHC').val('');
	$('#txtCLIENTE').val('');
	$('#txtMASCOTA').empty().append($('<option>', { 
        value: "-1",
        text : "Seleccione" 
    }));
	
	$.ajax({
		type:'GET',
		url: '/TP2_Villa/AM/validar',
		data: {
			tipoDoc: $('#txtTIPODOC').val(),
			numDoc: $('#txtNUMDOC').val()
		},
		success: function(data){
			listaDatos = data;
			if(data.length > 0){
				datos = data[0];
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
	$('#hdnIDHC').val('');
	$('#txtHC').val('');
	
	$.each(listaDatos,function( index, element ) {
		if(element.idMascota == id){
			$('#hdnIDHC').val(element.idHC);
			$('#txtHC').val(element.idHC);
			return;
		}
	});
}

function registrar(){
	var idMascota = $('#txtMASCOTA').val();
	
	if(idMascota == "-1"){
		mensajeModal("Seleccione alguna Mascota.");return false;
	}
	
	$('#formRAM').attr('action',"/TP2_Villa/AM/registrar");
	$('#formRAM').submit();	
}

</script>


<div class="container">
	<div class="page-header" align="center">
       <h1>Registrar Atención Médica</h1>
    </div>

	<form class="form-horizontal" action="" id="formRAM" method="POST">
	<input type="hidden" id="hdnIDHC" name="hdnIDHC" value=""/>
	<input type="hidden" id="txtIDMEDICO" name="txtIDMEDICO" value="${codigoMedico}"/>
	<input type="hidden" id="txtMEDICO" name="txtMEDICO" value="${datosMedico}"/>

    <div class="col-sm-12">
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
		            <input type="text" id="txtNUMDOC" name="txtNUMDOC" class="form-control" value="10233775"/>
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
		            <select id="txtMASCOTA" name="txtMASCOTA" class="form-control" onchange="mascota(this.value);">
		            	<option value="-1">Seleccione</option>
		            </select>
		        </div>
	        </div>
	        <div class="form-group">
		        <label class="control-label col-xs-3" for="txtHC">NÚMERO HISTORIA CLÍNICA:</label>
		        <div class="col-xs-5" align="right">
		            <input type="text" id="txtHC" name="txtHC" class="form-control" value="" disabled="disabled"/>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtMEDICO">MÉDICO:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtMEDICO" class="form-control" value="${datosMedico}" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtDEPO">DEPOSICIONES AL DÍA:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtDEPO" name="txtDEPO" class="form-control"/>
		        </div>
	        </div>
	        <div class="form-group">
		        <label class="control-label col-xs-3" for="txtPESO">PESO KG:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtPESO" name="txtPESO" class="form-control"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtTEMP">TEMPERATURA C°:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtTEMP" name="txtTEMP" class="form-control" maxlength="3"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtVITAL">PULSOS POR MINUTO:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtVITAL" name="txtVITAL" class="form-control" maxlength="3"/>
		        </div>
	        </div>
	        <div class="form-group">
		        <label class="control-label col-xs-3" for="txtDIAG">DIAGNÓSTICO:</label>
		        <div class="col-xs-5">
		            <select id="txtDIAG" name="txtDIAG" class="form-control">
			            <option value="-1">Seleccione</option>	
		            <c:forEach items="${listaDiagnostico}" var="diag">
			            <option value="${diag.idDIAG}">${diag.descripcion}</option>		            
		            </c:forEach>		            	
		            </select>
		        </div>
		    </div>
	        <div class="form-group">
		        <label class="control-label col-xs-3" for="txtEXAMEN">ORDEN MÉDICA:</label>
		        <div class="col-xs-5">
		            <select id="txtEXAMEN" name="txtEXAMEN" class="form-control">
			            <option value="-1">Seleccione</option>	
		            <c:forEach items="${listaExamenes}" var="exam">
			            <option value="${exam.idEXAM}">${exam.descripcion}</option>		            
		            </c:forEach>		            	
		            </select>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtOBS">OBSERVACIÓN:</label>
		        <div class="col-xs-5">
		        	<textarea class="form-control" id="txtOBS" name="txtOBS" rows="3" cols="100" maxlength="255"></textarea>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtCOMMENT">COMENTARIOS:</label>
		        <div class="col-xs-5">
		        	<textarea class="form-control" id="txtCOMMENT" name="txtCOMMENT" rows="3" cols="100" maxlength="255"></textarea>
		        </div>
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