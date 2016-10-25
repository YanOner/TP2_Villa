<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

$(function() {
    $('#dialog-confirm').dialog({
      autoOpen: false,
      resizable: false,
      height: "auto",
      width: 400,
      modal: true,
      buttons: {
        "Cancelar": function() {
          $( this ).dialog( "close" );
        },
        "Eliminar": function() {
        	$('#formAM').attr('action',"/TP2_Villa/AM/eliminar");
        	$('#formAM').submit();
        }
      }
    });
    
 });

function registrar(){
	$('#formAM').attr('action',"/TP2_Villa/AM/cargarRegistrar");
	$('#formAM').submit();
}

function limpiar(){
	$('#formAM').attr('action',"/TP2_Villa/AM/limpiar");
	$('#formAM').submit();
}

function detalle(id){
	$('#idAM').val(id);
	$('#formAM').attr('action',"/TP2_Villa/AM/detalle");
	$('#formAM').submit();
}

function eliminar(id){
	$('#idAM').val(id);
	$('#spnAM').text(id);
	$('#dialog-confirm').dialog('open');
}

function buscar(){
	$('#formAM').attr('action',"/TP2_Villa/AM/cargarBuscar");
	$('#formAM').submit();
}

</script>


<div class="container">
	<div class="page-header">
       <h1>Gestionar Atención Médica</h1>
    </div>

	<form class="form-horizontal" action="" id="formAM" method="POST">
	<input type="hidden" id="idAM" name="idAM" value="" />

    <div class="form-group">
        <input type="button" class="btn btn-default" value="BUSCAR" onclick="buscar();"/>
        <input type="button" class="btn btn-success" value="REGISTRAR" onclick="registrar();"/>
    </div>
    
    <br>
    <div class="form-group">
		<table class="table table-hover table-bordered" border="1">
        	<thead style="background-color: #bce8f1;">
            	<tr>
                	<th style="text-align: center;">CÓDIGO AM</th>
                	<th style="text-align: center;">CLIENTE</th>
                	<th style="text-align: center;">MASCOTA</th>
                	<th style="text-align: center;">REGISTRADO</th>
                	<th style="text-align: center;">ACTUALIZADO</th>
                	<th style="text-align: center;" colspan="4">ACCIÓN</th>
                </tr>
            </thead>
            <tbody>
            	<c:forEach var="AM" items="${listaAM}">
	            	<tr>
	            		<td style="text-align: center;">${AM.idAM}</td>
	            		<td style="text-align: center;">${AM.datosCliente}</td>
	            		<td style="text-align: center;">${AM.datosMascota}</td>
	            		<td style="text-align: center;">${AM.registrado}</td>
	            		<td style="text-align: center;">${AM.actualizado}</td>
	            		<td style="text-align: center;">
	            			<a href="#" onclick="">Medicación</a>
	            		</td>
	            		<td style="text-align: center;">
	            			<a href="#" onclick="">Resultado Orden Médica</a>
	            		</td>
	            		<td style="text-align: center;">
	            			<a href="#" onclick="">Ver Detalle</a>
	            		</td>
	            		<td style="text-align: center;">
	            			<a href="javascript:void(0);" onclick="eliminar(${AM.idAM});">Eliminar</a>
	            		</td>
	            	</tr>
            	</c:forEach>
            	<c:if test="${empty listaAM}">
            		<tr><td colspan="9" style="text-align: center;">
            			No hay datos para mostrar.
            		</td></tr>
            	</c:if>
            </tbody>
        </table>
    </div>

    <br>
    <div class="form-group">
        <div class="col-sm-12" align="left">
        	<input type="button" class="btn btn-info" value="LIMPIAR" onclick="limpiar();"/>
	    </div>
    </div>
</form>

<div id="dialog-confirm" title="Mensaje" style="display: none;">
  <p><span class="ui-icon ui-icon-alert" style="float:left; margin:12px 12px 20px 0;"></span>¿Está seguro de eliminar la Atención Médica con código <span id="spnAM">999</span>?</p>
</div>

</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>