function mensajeModal(mensaje){
	$('#spnMessage').text(mensaje);
	$('#dialog-message').dialog('open');
}

function isNumeric(event){
	var key = (event.keyCode || event.witch);
	var value = String.fromCharCode(key); 
    var isNumber = false;
    if(!isNaN(value) || key == '8'){
    	isNumber = true;
    }    
    return isNumber;
}