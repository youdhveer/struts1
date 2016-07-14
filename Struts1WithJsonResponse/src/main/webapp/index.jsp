<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <script	src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script> -->
<script	src="js/jquery-1.11.1.min.js"></script>
<style>
  .dropdown{
     width:200px;height:35px; font-size: 15px;
  }
</style>	  
</head>
<body>
	<h2>Struts 1 : Ajax JSON response Example</h2>	 
	<br/>
	<h3>Countries</h3>
	<div>
		<select id="countryListDD" onchange="loadStates()" class="dropdown">
		  <option value="-1">Please select a country</option>
		</select>
	
	</div>
	<br/>
	<h3>States</h3>
	<div>
		<select id="stateListDD" class="dropdown">
		  <option value="-1">Please select a state</option>
		</select>
	
	</div>
	

	
  <script>	
  
  $(document).ready(function(){
	  loadCountry();
  });
		  
	function loadCountry(){		
		try{
			$.ajax({
				url:"jsonData.do?method=countries",
				method :'GET',
				data:{},
				success:function(response) {	             	             
	              var countryListDD = $('#countryListDD');	           
	              $.each(response, function(index, countryObj) {	            	 
	            	  countryListDD.append(
	                      $('<option></option>').val(countryObj.id).html(countryObj.countryName)
	                  );
	              });
	              
			    },
			    error:function(jqXHR,textStatus,errorThrown){
			    	alert(errorThrown);
			    }				
			});
		}catch(err){
			console.log(err);
		}
		
	}
	
    function loadStates(){
    	
    	
    	var countryId=$('#countryListDD').val();
    	console.log(countryId);
    	//$('#dropDownId :selected').text();
		if(countryId ==-1 || countryId == '-1'){
			alert('Please select a country first!');
			return;
		}
		
		$('#stateListDD option[value!="-1"]').remove();
		
		$.ajax({
			url:"jsonData.do?method=states",
			method :'GET',
			data:{countryId : countryId},
			success:function(response) {              
                var stateListDD = $('#stateListDD');
                $.each(response, function(index, stateObj) {
                	stateListDD.append(
                        $('<option></option>').val(stateObj.stateId).html(stateObj.name)
                    );
                });
                
		    },
		    error:function(jqXHR,textStatus,errorThrown){
		    	alert(errorThrown);
		    }				
		});
	}
	
	</script>
	
</body>
</html>