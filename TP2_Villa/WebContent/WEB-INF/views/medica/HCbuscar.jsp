<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf"%>

<%--content--%>

<script type="text/javascript">

function buscar(){
	$('#formBHC').attr('action',"/TP2_Villa/HC/buscar");
	$('#formBHC').submit();
}

function regresar(){
	$('#formBHC').attr('action',"/TP2_Villa/HC/listar");
	$('#formBHC').submit();
}

</script>


<div class="container">
	<div class="page-header" align="center">
       <h1>Buscar Historia Clínica</h1>
    </div>

	<form class="form-horizontal" action="" id="formBHC" method="POST">

    <div class="row">
   		<div class="form-group">
	        <label class="control-label col-sm-3 col-xs-3" for="txtHC">CÓDIGO HC:</label>
	        <div class="col-sm-3 col-xs-3">
	        	<input type="text" id="txtHC" name="txtHC" onkeydown="return isNumeric(event);" value="" class="form-control" maxlength="5"/>
	        </div>
	    </div>
    	<div class="form-group">
	        <label class="control-label col-sm-3 col-xs-3" for="txtNUMDOC">NÚMERO DOCUMENTO:</label>
	        <div class="col-sm-3 col-xs-3">
	            <input type="text" id="txtNUMDOC" name="txtNUMDOC" onkeydown="return isNumeric(event);" value="" maxlength="25" class="form-control"/>
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