<%@ taglib prefix="l" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section id="site-content">
<section id="main-content">
			<section>
			<section class="panel" style="background-color: #999">
				<header class="panel-heading">Registration Report</header>
				<div class="panel-body">
				<br><br>
					<div class="position-center" style="width:97%">
					<div> 
					<div  style="float: left;width:100%">
																	
		<form method="POST" class="cmxform form-horizontal" name="petSearchBean" id="petsearchform">
		
		<div class="form-group">
										<label for="cname" style="text-align:left" class="control-label col-lg-4">Name Of the applicant</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="name" id="name">
										</div>
		</div>
		
		<div class="form-group">
										<label for="cname" style="text-align:left" class="control-label col-lg-4">Father's Name Of the applicant</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="fatherName" id="fatherName">
										</div>
		</div>
		<div class="form-group"> 
									 		<label for="curl" style="text-align:left" class="control-label col-lg-4">District</label>
									 		<div class="col-lg-8">
                                       <select class="form-control" id='district' name="district" onchange="loadUlb();"></select>
									 		</div>
									 	</div>
		<div class="form-group"> 
									 		<label for="curl" style="text-align:left" class="control-label col-lg-4">Municipal Corporation/Council/NP</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='ulb' name="ulb" onchange="loadLocality()"></select>
									 		</div>
									 	</div>
		
		<div class="form-group"> 
									 		<label for="curl" style="text-align:left" class="control-label col-lg-4">Phase/Area/Mohalla/Sector</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='locality' name="locality"></select>
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
							<th>Name of Head </th>
							<th>Father's Name</th>
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
					
					<input style="float:right;display:none" type=button id="exportButton" value="Export Data to Excel" ></div>
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
	          	    			
	          	    			
	          	    			var name=$('#name').val();
	          	    			var fatherName=$('#fatherName').val();
	          	    			var locality=$('#locality').val();
	          	    			var ulb=$('#ulb').val();
	          	    			var district=$('#district').val();
	          	    		
	          	    			
	          	    			
	          	    if(name=="" && fatherName=="" && district=="" && ulb==null && locality==null)
	          	    	alert("Select at least one criteria");
	          	    else
	          	    	{
	          	 var userType=8; 
	          	 var status='';
	    			$.ajax({  
	    		    url: 'get-pet-data',  
	    		    data:{"name":name,"fatherName":fatherName,"locality":locality,"ulb":ulb,"district":district,"userType":userType,"status":status},
	    		    type: 'GET',
	    		   success: function(data, textStatus, xhr) {  
	    		    var htm = "";
	    		    var count=1;
	    		    $(data).each(function (index, item) {
	    		    htm = htm+"<tr>" +
	    		    "<td>"+count+"</td>" +
	    		    "<td>"+item.headName+"</td>" +
		    		"<td>"+item.fatherName+"</td>" +
		    		"<td>"+item.districtBean.districtName+"</td>" +
		    		"<td>"+item.ulbBean.ulbName+"</td>" +
		    		"<td>"+item.localityBean.localityName+"</td>"+
		    		"<td>"+item.mobileNo+"</td>"+
		    		"<td>"+item.perAddress+"</td>"+
		    		"<td>"+item.applicationStatus+"</td>";
		    		htm=htm+"<td> <select id=\"actionDD"+item.petId+"\" name=\"actionDD"+item.petId+"\" onChange=\"getaction("+item.petId+")\"><option value=\"\">Select from below</option><option value=\"Collect Registration Fee\"><button style=\"color:teal; background-color: #FFFFC0; border: 3pt ridge lightgrey\">Pay Registration Fee</button></option>";
						
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
	    		}
	    		
        </script>
