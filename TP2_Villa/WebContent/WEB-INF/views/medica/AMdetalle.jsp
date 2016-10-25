<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

function regresar(){
	$('#formDHC').attr('action',"/TP2_Villa/HC/listar");
	$('#formDHC').submit();
}

</script>


<div class="container">
	<div class="page-header" align="center">
       <h1>Detalle Historia Clínica</h1>
    </div>

	<form class="form-horizontal" action="" id="formDHC" method="POST">

    <div class="col-sm-12">
    	<div class="col-sm-8">
    		<div class="form-group">
		        <label class="control-label col-sm-3 col-xs-3" for="txtHC">CÓDIGO HC:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtHC" value="${hc.idHC}" class="form-control" disabled="disabled"></select>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtTIPODOC">TIPO DOCUMENTO:</label>
		        <div class="col-xs-5">
		        	<input type="text" id="txtTIPODOC" value="${hc.descDoc}" class="form-control" disabled="disabled"/>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtNUMDOC">NÚMERO DOCUMENTO:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtNUMDOC" value="${hc.numDoc}" class="form-control" disabled="disabled"/>
		        </div>
		    </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtCLIENTE">CLIENTE:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtCLIENTE" value="${hc.datosCliente}" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtPACIENTE">MASCOTA:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtPACIENTE" value="${hc.datosMascota}" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtESPECIE">ESPECIE:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtESPECIE" value="${hc.descripcionEspecie}" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtRAZA">RAZA:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtRAZA" value="${hc.descripcionRaza}" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
	        <div class="form-group">
		        <label class="control-label col-xs-3" for="txtGENERO">GENERO:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtGENERO" value="${hc.descripcionGenMascota}" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtEDAD">EDAD:</label>
		        <div class="col-xs-5">
		            <input type="text" id="txtEDAD" value="${hc.edad}" class="form-control" disabled="disabled"/>
		        </div>
	        </div>
    		<div class="form-group">
		        <label class="control-label col-xs-3" for="txtOBS">OBSERVACIÓN:</label>
		        <div class="col-xs-5">
		        	<textarea class="form-control" id="txtOBS" rows="3" cols="100" maxlength="255" disabled="disabled">${hc.observaciones}</textarea>
		        </div>
	        </div>
	    </div>
        <div class="col-sm-4" align="left">
        	<img class="thumbnail" alt="IMG" src="/TP2_Villa/static/img/x.png" width="150px" height="150px">
        </div>
    </div>
    
    <br>
    <div class="form-group">
        <div class="col-sm-3" align="center">
        	<input type="button" class="btn btn-primary" value="REGRESAR" onclick="regresar();"/>
        </div>
    </div>
</form>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>