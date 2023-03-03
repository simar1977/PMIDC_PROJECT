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
									<input type="hidden" id="userType" value="${userType}">
									<input type="hidden" id="district" value="${district}">
									<input type="hidden" id="ulb" value="${ulb}">
					
					<div id="adminDiv" style="display:none">
					<label for="curl" style="text-align:center;">District</label> 
					 <select class="control-label col-lg-4" style="width:100%;height:40px" id='tfdistrict' name="districtBean" onchange="loadUlb();"><option value="">Select Town/ULB</option></select>
             <br><br>
             <label for="curl" style="text-align:center;">Municipal Corporation/Council/NP</label> 
					 <select class="control-label col-lg-4" style="width:100%;height:40px" id='tfulb' name="ulbBean" onchange="loadlocality();"><option value="">Select District</option></select>
           <br><br>  <label for="curl"  style="text-align:center;">Select Locality</label> 
             <select class="control-label col-lg-4"  style="width:100%;height:40px" id='tflocality' name="tflocality"><option value="">Select Locality</option></select>
				</div>
								
								<div id="userDiv" style="display:none;"><label for="curl"  style="text-align:center;">Select Locality</label> 
             <select class="control-label col-lg-4"  style="width:100%;height:40px" id='tflocality1' name="tflocality1"><option value="">Select Locality</option></select>
					
					
					</div>
					 <br><br>
					<label for="curl"  style="text-align:center;">Search by Status</label> 
             <select class="control-label col-lg-4"  style="width:100%;height:40px" id='status' name="status"><option value="">Select Status</option>
             <option value="Applied">Applied</option>
             <option value="Rejected">Rejected</option>
             <option value="Send back with Objections">Send back with Objections</option>
             <option value="Fee Received.Pending for Approval.">Fee Received.Pending for Approval.</option>
             <option value="Approved">Approved</option></select>
					
					<div style="float:right">
					<button  type="button" id="search" onclick="selectPerson()" class="btn btn-info">Fetch Report</button></div>
					<!-- <div>
					<label for="curl" class="control-label col-lg-4" style="text-align:center;">From</label> 
					<input class="control-label col-lg-6" type="date" id="from"></div>
					<div>
					<label for="curl" class="control-label col-lg-4" style="text-align:center;">To</label> 
					<input class="control-label col-lg-6" type="date" id="to"></div> -->
					
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
							<th>Town/ULB </th>
							<th>Locality </th>
							<th>Mobile Number</th>
							<th>Permanent Address</th>
							<th>Application Status</th>
							<th width="15%">Action</th>
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
	            	var userType=$('#userType').val();
	            	var ulb=$('#ulb').val();
	            	if(userType=='0')
	            		{
	            		document.getElementById('userDiv').style.display='none';

	                	document.getElementById('adminDiv').style.display='block';
	            		
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
            	             $('#tfdistrict').html(htm);  
            	             }      
            	});
	            	
	            		}
	            	
	            	else
	            		{
	            		
	            		document.getElementById('userDiv').style.display='block';

	                	document.getElementById('adminDiv').style.display='none';
	            			  var district= $('#districtId').val();
	       	                $.ajax({
	       	            	    url: "get-locality",
	       	            	    type: 'GET',
	       	            	    data:{"ulb":ulb},
	       	            	    datatype:"json",
	       	            	    async:false,
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
	       	            	           
	       	            	             $('#tflocality1').html(htm);  
	       	            	             }      
	       	            	});
	       	            
	       	               	
	       	       
	       	    	
	            		
	            		}
});
          
	            function loadUlb()
	            {
	            	  var district= $('#tfdistrict').val();
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
	            	             $('#tfulb').html(htm);  
	            	             }      
	            	});
	       	
	            	
	            }
	                         
	            function loadLocality()
	            {
	            	  var ulb= $('#tfulb').val();
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
	            	             $('#tflocality').html(htm);  
	            	             }      
	            	});
	            }
	            
	         
	    		//Fetch sorting vendor record according to Search by status 
	    		function selectPerson()
	    		{
                	document.getElementById('tableDiv').style.display='block';
                	var status1=$('#status').val();
	    			var userType=$('#userType').val();
	    			if(userType=='0')
	    				{
	    				var selectedDistrict=$('#tfdistrict').val();
	      				var selectedULB=$('#tfulb').val();
	      				var selectedLocality=$('#tflocality').val();
	    				var status=status1;
	    				}
	    			
	    			else
	    				{
		    			var district=$('#district').val();
						var ulb=$('#ulb').val();
	    			var selectedDistrict=district;
	    			var selectedULB=ulb;
	    			var selectedLocality=$('#tflocality').val();
	    			var status=status1;
	    				}
	    		
	    			$.ajax({  
	    		    url: 'get-head-data',  
	    		    data:{"selectedDistrict":selectedDistrict,"selectedULB":selectedULB,"selectedLocality":selectedLocality,"status":status},
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
		    		if(item.applicationStatus!='Approved' && item.applicationStatus!='Rejected' )
		    			{htm=htm+"<td> <select id=\"actionDD"+item.petId+"\" name=\"actionDD"+item.petId+"\" onChange=\"getaction("+item.petId+")\"><option value=\"\">Select from below</option><option value=\"Edit Details\"><button style=\"color:teal; background-color: #FFFFC0; border: 3pt ridge lightgrey\">Edit Details</button></option>";
		    			}
		    		else if(item.applicationStatus=='Approved')
		    		{htm=htm+"<td> <select id=\"actionDD"+item.petId+"\" name=\"actionDD"+item.petId+"\" onChange=\"getaction("+item.petId+")\"><option value=\"\">Select from below</option><option value=\"Print Pet License\"><button style=\"color:teal; background-color: #FFFFC0; border: 3pt ridge lightgrey\">Print Pet License</button></option>";
	    			}
		    		
		    		else if(item.applicationStatus=='Rejected')
		    		{htm=htm+"<td> <select id=\"actionDD"+item.petId+"\" name=\"actionDD"+item.petId+"\" onChange=\"getaction("+item.petId+")\"><option value=\"\">Select from below</option><option value=\"View Application\"><button style=\"color:teal; background-color: #FFFFC0; border: 3pt ridge lightgrey\">View Application</button></option>";
	    			}
		    		
					htm=htm+"</select></td>"+		    		
					"</tr>";
				count=count+1;
	    				    });

	    		$('#elist-body').html(htm);
	    		$('#elist').DataTable();	
	    		$('#exportButton').show();
	    		
	    		    },
	    		    error: function(xhr, textStatus, errorThrown) {  
	    		    }
	    		    });
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
    			if(userType=='0')
    			{
    				var selectedDistrict=$('#tfdistrict').val();
    				var selectedLocality=$('#tflocality').val();
    			}
    			else
    			{
    				var selectedDistrict="";
	    			var selectedLocality=$('#tflocality').val();
    			}
    		
	    		//alert(action);
	    		if(action=='Edit Details')
	    		{
	    			
	    			window.location="/pet-license/edit-details?petId="+id;
	    		}
	    		else if(action=='Print Pet License')
	    		{
	    			
	    			window.location="/pet-license/pet-license?petId="+id;
	    		}
	    		else if(action="View Application")
	    			{
	    			
	    			window.location="/pet-license/view-details?petId="+id;
	    			}
	    		}
	    		
        </script>
