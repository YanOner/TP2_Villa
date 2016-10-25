<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="es">
<script src="/TP2_Villa/static/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">

function cargar(evt){
	var file = document.getElementById("txtFILE").files[0];
// 	var files = evt.target.files; // FileList object
// 	console.log(files);
//     // Loop through the FileList and render image files as thumbnails.
//     for (var i = 0, f; f = files[i]; i++) {
//     	file = files[i];
//     }
	
	var url = "/TP2_Villa/prueba/ajax";

	var formData; 
	if(typeof FormData == "undefined"){
		formData = [];
		formData.push("txtFILE", file);
	}else{
		formData = new FormData();
		formData.append("txtFILE", file);
	}
    
	$.ajax({
		url: url,
		type: 'POST',
		data: formData,
		processData: false,
		contentType: false,	
		success: function(result) {
			console.log(result);
		},
		error: function(e) {     
			alert("error: "+ e);
		}
	});	
}

function load() {
	alert("load iframe");
}

</script>
<body>
<div class="container">
	<h1 id="resultado"></h1>
    <div class="row" >
    
    	<form target="ifra" action="/TP2_Villa/prueba/ajax" method="post" enctype="multipart/form-data">
	
				<input />
	        
	        	<input type="file" name="txtFILE" id="txtFILE">
	        	
	        	<input type="submit" value="GO!"/>
	        	
	    </form>
    	
    	<iframe id="ifra" name="ifra">
	        
	    </iframe>
	    
	    <img alt="img" src="/TP2_Villa/Penguins.jpg">
	    
    </div>
</div>
</body>
</html>