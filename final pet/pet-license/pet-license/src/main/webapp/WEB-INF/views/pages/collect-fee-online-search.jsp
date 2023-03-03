<%@ taglib prefix="l" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section id="site-content">
<section id="main-content">
			<section>
			<section class="panel" style="background-color: #999">
				<header class="panel-heading">Registration Report</header>
				<style>
            input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
        </style>
				<div class="panel-body">
				<br><br>
					<div class="position-center" style="width:97%">
					<div> 
					<div  style="float: left;width:100%">
																	
		<form method="POST" class="cmxform form-horizontal" name="petSearchBean" id="petsearchform">
		
		
		
		<div class="form-group ">
										<label for="cname" style="text-align:left" class="control-label col-lg-4">Pet Id   &nbsp;&nbsp;&nbsp;   (Only Enter Pet Id if know it)</label>
										<div class="col-lg-8">
										<input class="form-control" type="number"  style="border:1px solid red; font-family:Times New Roman, Serif;   font-size: 16px;" name="petId" id="petId" maxlength = "8" pattern="[0-9]+" title="only numbers are allowed">
										</div>
		</div>
		<div class="form-group required ">
										<label for="cname" style="text-align:left" class="control-label col-lg-4">Name Of the applicant</label>
										<div class="col-lg-8">
										<input class="form-control" type="text" style="border:1px solid red; font-family:Times New Roman, Serif;   font-size: 16px;"  name="name" id="name">
										</div>
		</div>
		<div class="form-group required ">
										<label for="cname" style="text-align:left" class="control-label col-lg-4">PHONE NUMBER</label>
										<div class="col-lg-8">
									<input class="form-control" type="number"  name="mobileNo" style="border:1px solid red; font-family:Times New Roman, Serif;   font-size: 16px;" id="mobileNo" maxlength = "10" pattern="[0-9]+" title="only numbers are allowed">
										</div>
		</div>
		
									 			
</form>
					<div style="float:right">
					<button  type="button" id="search" onclick="selectPerson()" class="btn btn-info">Fetch Report</button></div>
			
					</div>
					<br>
					<br>
					<br><br>
					
					<div class="agile-tables">
					<div class="w3l-table-info" id="tableDiv" style="display:none">
					<table class="position-center" id="elist" style="table-layout: fixed;width:100%;word-wrap:break-word;border: 1px solid black;">
						<thead>
						  <tr style="font-size:11px">
						 	<th width=5%>SrNo</th>
						 	<th>Pet ID </th>
							<th>Name of Applicant </th>
							<th>Father/Spouse Name</th>
							<th>District </th>
							<th>ULB</th>
							<th>Locality </th>
							<th width="10%">Mobile Number</th>
							<th>Permanent Address</th>
							<th>Application Status</th>
							<th width=15%>Action</th>
						</tr>
						</thead>
						<tbody id="elist-body">
						  
						</tbody>
					  </table>
					</div></div><br></div></div>
					
					
			</section>
			</section>
			</section>
			</section>
			
<!-- Template created and distributed by Colorlib -->		
<link rel="stylesheet" type="text/css" href="/pet-license/resources/css/table-style.css" />
<script src="/pet-license/resources/js/data.table.js"></script>
<script src="/pet-license/resources/js/table2excel.js"></script>
			
			 <script type="text/javascript">
	            
	            $(document).ready(function () {
	            	$.ajax({
	            	    url: "get-district",
	            	    type: 'GET',
	            	    datatype:"json",
	            	    contentType: "application/json; charset=utf-8",
	            	    success: function (responce)
	            	    {
	            	    	var htm = "<option value=''> Select District</option>";
	            	    	 var data = JSON.stringify(responce);
	            	         	var obj = JSON.parse(data);
	            	             $.each(obj, function(index,item) {        
	            	htm = htm +' <option value='+item.districtCode+'>'+item.districtName+'</option>';
	            	             });
	            	             htm = htm;
	            	             $('#district').html(htm);  
	            	             }      
	            	});
	            });
	            	 function loadUlb()
	 	            {
	 	            	  var district= $('#district').val();
	 	                $.ajax({
	 	            	    url: "get-ulb",
	 	            	    type: 'GET',
	 	            	    data:{"district":district},
	 	            	    datatype:"json",
	 	            	    contentType: "application/json; charset=utf-8",
	 	            	    success: function (responce)
	 	            	    {
	 	            	    	var htm = "<option value=''> Select from below</option>";
	 	            	    	 var data = JSON.stringify(responce);
	 	            	         	var obj = JSON.parse(data);
	 	            	             $.each(obj, function(index,item) {        
	 	            	htm = htm +' <option value='+item.ulbCode+'>'+item.ulbName+'</option>';
	 	            	             });
	 	            	             htm = htm;
	 	            	             $('#ulb').html(htm);  
	 	            	             }      
	 	            	});
	 	       	
	 	            	
	 	            }
	 	                         
	 	            function loadLocality()
	 	            {
	 	            	  var ulb= $('#ulb').val();
	 	                $.ajax({
	 	            	    url: "get-locality",
	 	            	    type: 'GET',
	 	            	    data:{"ulb":ulb},
	 	            	    datatype:"json",
	 	            	    contentType: "application/json; charset=utf-8",
	 	            	    success: function (responce)
	 	            	    {
	 	            	    	            	    	var htm = "<option value=''> Select Locality</option>";
	 	            	    	 var data = JSON.stringify(responce);
	 	            	         	var obj = JSON.parse(data);
	 	            	             $.each(obj, function(index,item) {        
	 	            	htm = htm +' <option value='+item.localityCode+'>'+item.localityName+'</option>';
	 	            	             });
	 	            	             htm = htm;
	 	            	             $('#locality').html(htm);  
	 	            	             }      
	 	            	});
	 	            }
	       	               	
	       	       
	          	    		//Fetch sorting vendor record according to Search by status 
	    		function selectPerson()
	          	    		
	    		{
	          	    			
	    		            	var petId=$('#petId').val();
	          	    			var name=$('#name').val();
	          	    			var mobileNo=$('#mobileNo').val();
	          	    			
	          	    			var locality=$('#locality').val();
	          	    			var ulb=$('#ulb').val();
	          	    			var district=$('#district').val();
	          	    		
	          	    			
	          	   // if(petId==0)
	        	     //   alert("Enter Pet Id");
	          	   if(name=="")
	          	    	alert("Enter Name of applicant ");
	          	          	  
	          	 else if(mobileNo==0)
	          		 alert("Enter Phone number Of Applicant");
	          	 else if(locality=="")
	          		 alert("Select Locality");
	          	 else if(ulb=="")
	          		 alert("Select Your ULB");
	          	 else if(district=="")
	          		 alert("Select  Your District");
	          	   
	          	   
	          	   
	          	   
	          	    else
	          	    	{
	          	 var userType=8; 
	          	 var status='';
	    			$.ajax({  
	    		    url: 'get-pet-datas',  
	    		    data:{"name":name,"mobileNo":mobileNo,"petId":petId},
	    		    type: 'GET',
	    		   success: function(data, textStatus, xhr) {  
	    		    var htm = "";
	    		    var count=1;
	    		    $(data).each(function (index, item) {
	    		    htm = htm+"<tr>" +
	    		    "<td style=\"font-size:14px\">"+count+"</td>" +
	    		    "<td style=\"font-size:14px\">"+item.petId+"</td>" +
	    		    "<td style=\"font-size:14px\">"+item.headName+"</td>" +
		    		"<td style=\"font-size:14px\">"+item.fatherName+"</td>" +
		    		"<td style=\"font-size:14px\">"+item.districtBean.districtName+"</td>" +
		    		"<td style=\"font-size:14px\">"+item.ulbBean.ulbName+"</td>" +
		    		"<td style=\"font-size:14px\">"+item.localityBean.localityName+"</td>"+
		    		"<td style=\"font-size:14px\">"+item.mobileNo+"</td>"+
		    		"<td style=\"font-size:14px\">"+item.perAddress+"</td>"+
		    		"<td style=\"font-size:14px\">"+item.applicationStatus+"</td>";
		    		var a=item.applicationStatus;
		    		
		    		
		    		if(a!='Applied For Renewal' && item.fee=='No')
		    			htm=htm+"<td> <select id=\"actionDD"+item.petId+"\" name=\"actionDD"+item.petId+"\" onChange=\"getaction("+item.petId+")\"><option value=\"\">Select from below</option><option value=\"Collect Registration Fee\"><button style=\"color:teal; background-color: #FFFFC0; border: 3pt ridge lightgrey\">Pay Registration Fee</button></option>";
		    			
		    		else if(a=='Applied For Renewal' && item.fee=='No')
			    		htm=htm+"<td> <select id=\"actionDD"+item.petId+"\" name=\"actionDD"+item.petId+"\" onChange=\"getaction("+item.petId+")\"><option value=\"\">Select from below</option><option value=\"Renewal\"><button style=\"color:teal; background-color: #FFFFC0; border: 3pt ridge lightgrey\">Pay Renewal Fee</button></option>";	
		    	
			    	htm=htm+"</select></td>"+		    		
					"</tr>";
				count=count+1;
	    				    });
				$('#tableDiv').show();
	    		$('#elist-body').html(htm);
	    		$('#elist').DataTable();	
	    		$('#exportButton').show();
	    		
	    		    },
	    		    error: function(xhr, textStatus, errorThrown) {  
	    		    }
	    		    });
	          	    	}
	    		}
	    		
	    		$(function () {    
	    		            $("#exportButton").click(function () {    
	    		            	    $("#elist").table2excel({    
	    		                    filename: "pet_data.xls"    
	    		                });    
	    		            });    
	    		        }); 
	    		
	    		function getaction(id)
	    		{
	    			
	    		var s='actionDD'+id;
	    		//alert(s);
	    		var action=document.getElementById(s).value;
	    		var userType=$('#userType').val();
    			//alert(action);
	    		if(action=='Collect Fee' || action=='Collect Registration Fee')
	    		{
	    			window.location="/pet-license/collect-fee-online?petId="+id;
	    		}
	    		
	    		if(action=='Approve Pet')
	    		{
	    			window.location="/pet-license/approve-pet?petId="+id;
	    		}
	    		if(action=='Renewal' )
	    		{
	    			window.location="/pet-license/citizen-renew?petId="+id;
	    		}
	    		}
	    		
        </script>
