<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

function buscar(){
	$('#formBAM').attr('action',"/TP2_Villa/AM/buscar");
	$('#formBAM').submit();
}

function regresar(){
	$('#formBAM').attr('action',"/TP2_Villa/AM/inicio");
	$('#formBAM').submit();
}

</script>


<div class="container">
	<div class="page-header" align="center">
       <h1>Buscar Atención Médica</h1>
    </div>

	<form class="form-horizontal" action="" id="formBAM" method="POST">

    <div class="row">
    	<div class="form-group">
	        <label class="control-label col-sm-3 col-xs-3" for="txtAM">CÓDIGO HISTORIA CLÍNICA:</label>
	        <div class="col-sm-3 col-xs-3">
	        	<input type="text" id="txtAM" name="txtHC" class="form-control"/>
	        </div>
	    </div>
   		<div class="form-group">
	        <label class="control-label col-sm-3 col-xs-3" for="txtAM">CÓDIGO ATENCIÓN MÉDICA:</label>
	        <div class="col-sm-3 col-xs-3">
	        	<input type="text" id="txtAM" name="txtAM" class="form-control"/>
	        </div>
	    </div>
    	<div class="form-group">
	        <label class="control-label col-sm-3 col-xs-3" for="txtNUMDOC">NÚMERO DOCUMENTO:</label>
	        <div class="col-sm-3 col-xs-3">
	            <input type="text" id="txtNUMDOC" name="txtNUMDOC" class="form-control"/>
	        </div>
	    </div>
    </div>
    
    <br>
    <div class="form-group">
        <div class="col-sm-3" align="left">
        	<input type="button" class="btn btn-primary" value="REGRESAR" onclick="regresar();"/>
        </div>
        <div class="col-sm-3" align="left">
        	<input type="button" class="btn btn-success" value="BUSCAR" onclick="buscar();"/>
        </div>
    </div>
</form>
</div>

<%--end content--%>
<%@ include file="../common/footer.jspf"%>