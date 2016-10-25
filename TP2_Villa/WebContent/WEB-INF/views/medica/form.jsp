<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="es">
<script src="/TP2_Villa/static/js/jquery-1.10.2.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script type="text/javascript">

//wait for the DOM to be loaded 
$(document).ready(function() { 
    // bind 'myForm' and provide a simple callback function 
    $('#myForm').ajaxForm(function(data) { 
//         alert("Thank you for your comment! "+data); 
// 		$('#divFile').html(data);
        document.getElementById("imageid").src="/TP2_Villa/prueba/photo3?nombre="+data;
    }); 

    $('#myForm2').ajaxForm(function(data) { 
		alert(data);
    }); 

    
    if (window.File && window.FileReader && window.FileList && window.Blob) 
    	document.getElementById("test").value = "File API supported.";
    else
    	document.getElementById("test").value = "File API not supported by this browser.";
    
    jQuery('#image').on('change', function () {
        ext = jQuery(this).val().split('.').pop().toLowerCase();
        if (jQuery.inArray(ext, ['gif', 'png', 'jpg', 'jpeg']) == -1) {
            resetFormElement(jQuery(this));
            window.alert('Not an image!');
        } else {
            file = jQuery('#image').prop("files")[0];
            blobURL = window.URL.createObjectURL(file);
            jQuery('#image_preview img').attr('src', blobURL);
            jQuery('#image_preview').slideDown();
            jQuery(this).slideUp();
        }
    });

    /**
    onclick event handler for the delete button.
    It removes the image, clears and unhides the file input field.
    */
    jQuery('#image_preview a').bind('click', function () {
        resetFormElement(jQuery('#image'));
        jQuery('#image').slideDown();
        jQuery(this).parent().slideUp();
        return false;
    });

    /** 
     * Reset form element
     * 
     * @param e jQuery object
     */
    function resetFormElement(e) {
        e.wrap('<form>').closest('form').get(0).reset();
        e.unwrap();
    }
    
}); 

function loadname(img, previewName){  

	var isIE = (navigator.appName=="Microsoft Internet Explorer");  
	var path = img.value;  
	var ext = path.substring(path.lastIndexOf('.') + 1).toLowerCase();  

	 if(ext == "gif" || ext == "jpeg" || ext == "jpg" ||  ext == "png" )  
	 {       
	    if(isIE) {  
	       $('#'+ previewName).attr('src', path);  
	    }else{  
	       if (img.files[0]) 
	        {  
	            var reader = new FileReader();  
	            reader.onload = function (e) {  
	                $('#'+ previewName).attr('src', e.target.result);  
	            }
	            reader.readAsDataURL(img.files[0]);  
	        }  
	    }  

	 }else{  
	  alert("incorrect file type");  
	 }   
	} 

</script>
<body>
<div class="container">
	<h1 id="resultado"><input id="test" readonly="readonly"/></h1>
    <div class="row" >
    
	    <form id="myForm" action="/TP2_Villa/prueba/ajax" method="post"> 
		    <input type="file" id="myImage" name="txtFILE" />
		    <input type="submit" value="Submit Comment" /> 
		</form>
	    
	    <div id="divFile">
	    	
	    </div>
	    
		<img id="imageid" src="/TP2_Villa/prueba/photo?nombre=Desert.jpg" alt="img">
	    
    </div>
    
    <div class="row">
    
    	<input type="file" name="image" onchange="loadname(this,'previewimg');" >
		<img src="about:blank" name="previewimg" id="previewimg" alt="">
    	
    </div>
    
    <div class="row">
    
	    <form>
		    <p>
		        <label for="image">Image:</label>
		        <br />
		        <input type="file" name="image" id="image" />
		    </p>
		</form>
		<div id="image_preview">
		    <img src="#" />
		    <br />
		    <a href="#">Remove</a>
		</div>
    
    </div>
    
    <div class="row" >
	    <form id="myForm2" action="/TP2_Villa/prueba/ajax2" method="post"> 
		    <input type="file" name="txtFILES" />
		    <input type="file" name="txtFILES" />
		    <input type="submit" value="Submit Comment2" /> 
		</form>
	</div>
</div>
</body>
</html>