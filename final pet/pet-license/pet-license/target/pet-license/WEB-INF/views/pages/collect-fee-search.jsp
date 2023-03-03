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
									<input type="hidden" id="districtId" name="district" value="${district}">

									<input type="hidden" id="ulbId" name="ulb" value="${ulb}">

									<input type="hidden" id="userType" name="userType" value="${userType}">
									
		<form method="POST" class="cmxform form-horizontal" name="petSearchBean" id="petsearchform">
		
		
		<div class="form-group">
										<label for="cname" style="text-align:left" class="control-label col-lg-4">Name Of the applicant</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="name" id="name">
										</div>
		</div>
		
		<div class="form-group">
										<label for="cname" style="text-align:left" class="control-label col-lg-4">Father/Spouse Name</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="fatherName" id="fatherName">
										</div>
		</div>
		
		<div class="form-group"> 
									 		<label for="curl" style="text-align:left" class="control-label col-lg-4">Phase/Area/Mohalla/Sector</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='locality' name="locality"></select>
									 		</div>
									 	</div>
									 	<l:choose>
									 	<l:when test="${userType == '1'}">
									 	
									 	<div class="form-group"> 
									 		<label for="curl" style="text-align:left" class="control-label col-lg-4">Application Status</label> 
									 		<div class="col-lg-8">
  <select class="form-control"  style="width:100%;height:40px" id='status' name="status"><option value="">Select Status</option>
             <option value="Applied">Applied</option>
             <option value="Send back with Objections">Send back with Objections</option>
             <option value="Fee Received.Pending for Inspection.">Fee Received.Pending for Inspection.</option>
             <option value="Inspection Done.Pending for Approval.">Inspection Done.Pending for Approval.</option>
             <option value="Applied For Renewal">Applied For Renewal.</option>
             
             <option value="Approved">Approved</option></select>									 		</div>
									 	</div>
									 	</l:when></l:choose>
		
		
</form>
					<div style="float:right">
					<button  type="button" id="search" onclick="selectPerson()">Fetch Report</button></div>
			
					</div>
					<br>
					<br>
					<br><br>
					
					<div class="agile-tables">
					<div class="w3l-table-info" id="tableDiv" style="display:none">
					<table class="position-center" id="elist" style="table-layout: fixed;width:100%;word-wrap:break-word;border: 1px solid black;">
						<thead>
						  <tr style="font-size:11px">
						 	
						 	<th>Pet ID</th>
							<th>Name of Head </th>
							<th>Father/Spouse Name</th>
							<th>District </th>
							<th>Town/ULB </th>
							<th>Locality </th>
							<th width="5%">Mobile Number</th>
							<th>Permanent Address</th>
							<th>Application Type</th>
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
	            	  var ulb= $('#ulbId').val();
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
	       	            	           
	       	            	             $('#locality').html(htm);  
	       	            	             }      
	       	            	});
	       	            
	       	               	
	       	       
	       	    	
	            		
	          
});
          
	          	    		//Fetch sorting vendor record according to Search by status 
	    		function selectPerson()
	          	    		
	    		{
	          	    			
	          	    			debugger;
	          	    			var name=$('#name').val();
	          	    			var fatherName=$('#fatherName').val();
	          	    			var locality=$('#locality').val();
	          	    			var district=$('#districtId').val();
	          	    			var ulb=$('#ulbId').val();
	          	    			var userType=$('#userType').val();
	          	    			var status=$('#status').val();
	          	    			
	          	    			
	          	    if(name==null && fatherName==null && locality=="" && status=="")
	          	    	alert("Select at least one criteria");
	          	    else
	          	    	{
	          	    	
	          	    if(userType==2)
	          	    	{
	          	    	status='Approved';
	          	    	}
	          	  if(userType==3)
        	    	{
        	    	status='Inspection Done.Pending for Approval.';
        	    	}		
                	    		
	    			$.ajax({  
	    		    url: 'get-pet-data',  
	    		    data:{"name":name,"fatherName":fatherName,"locality":locality,"ulb":ulb,"district":district,"userType":userType,"status":status},
	    		    type: 'GET',
	    		   success: function(data, textStatus, xhr) {  
	    		    var htm = "";
	    		    var count=1;
	    		    $(data).each(function (index, item) {
	    		    htm = htm+"<tr>" +
	    		    
	    		    "<td style=\"font-size:14px\">"+item.petId+"</td>" +
	    		    "<td style=\"font-size:14px\">"+item.headName+"</td>" +
		    		"<td style=\"font-size:14px\">"+item.fatherName+"</td>" +
		    		"<td style=\"font-size:14px\">"+item.districtBean.districtName+"</td>" +
		    		"<td style=\"font-size:14px\">"+item.ulbBean.ulbName+"</td>" +
		    		"<td style=\"font-size:14px\">"+item.localityBean.localityName+"</td>"+
		    		"<td style=\"font-size:14px\">"+item.mobileNo+"</td>"+
		    		"<td style=\"font-size:14px\">"+item.perAddress+"</td>"+
		    		"<td style=\"font-size:14px\">"+item.apptype+"</td>"+
		    		"<td style=\"font-size:14px\">"+item.applicationStatus+"</td>";
		    		var a=item.applicationStatus;
		    		
		    		if(userType == 2 && a=='Inspection Done.Pending for Approval.')
						htm = htm+"<td> <select id=\"actionDD"+item.petId+"\" name=\"actionDD"+item.petId+"\" onChange=\"getaction("+item.petId+")\"><option value=\"\">Select from below</option><option value=\"Approve Pet\"><button style=\"color:teal; background-color: #FFFFC0; border: 3pt ridge lightgrey\">Approve Pet</button></option>";
					if(userType == 3 && item.fee=='Yes')
						htm = htm+"<td> <select id=\"actionDD"+item.petId+"\" name=\"actionDD"+item.petId+"\" onChange=\"getaction("+item.petId+")\"><option value=\"\">Select from below</option><option value=\"Forward Application\"><button style=\"color:teal; background-color: #FFFFC0; border: 3pt ridge lightgrey\">Forward Application</button></option>";
			    		else if(userType == 1 && item.fee=='No' && a!='Applied For Renewal')
		    			htm=htm+"<td> <select id=\"actionDD"+item.petId+"\" name=\"actionDD"+item.petId+"\" onChange=\"getaction("+item.petId+")\"><option value=\"\">Select from below</option><option value=\"Collect Registration Fee\"><button style=\"color:teal; background-color: #FFFFC0; border: 3pt ridge lightgrey\">Collect Registration Fee</button></option>";
		    			
		    			
		    			else if(a=='Approved')
		    				htm=htm+"<td> <select id=\"actionDD"+item.petId+"\" name=\"actionDD"+item.petId+"\" onChange=\"getaction("+item.petId+")\"><option value=\"End\"><button style=\"color:teal; background-color: #FFFFC0; border: 3pt ridge lightgrey\">FEE HAS BEEN ALREADY PAID </button></option>";
		    			else if(userType == 1 && item.fee=='Yes' && a!='Applied For Renewal' && a!='Fee Received.Pending for Inspection.' && a!='Approved')
			    			htm=htm+"<td> <select id=\"actionDD"+item.petId+"\" name=\"actionDD"+item.petId+"\" onChange=\"getaction("+item.petId+")\"><option value=\"\">Select from below</option><option value=\"Collect Fee\"><button style=\"color:teal; background-color: #FFFFC0; border: 3pt ridge lightgrey\">Collect Fee</button></option>";
			    		else if(a=='Applied For Renewal' && item.fee=='No')
			    			htm=htm+"<td> <select id=\"actionDD"+item.petId+"\" name=\"actionDD"+item.petId+"\" onChange=\"getaction("+item.petId+")\"><option value=\"\">Select from below</option><option value=\"Renewal\"><button style=\"color:teal; background-color: #FFFFC0; border: 3pt ridge lightgrey\">Collect Renewal Fee</button></option>";
			    		else if(a='Fee Received.Pending for Inspection.'&& item.fee=='Yes' && userType!= 2)
			    			htm=htm+"<td> <select id=\"actionDD"+item.petId+"\" name=\"actionDD"+item.petId+"\" onChange=\"getaction("+item.petId+")\"><option value=\"End\"><button style=\"color:teal; background-color: #FFFFC0; border: 3pt ridge lightgrey\">FEE HAS BEEN ALREADY PAID </button></option>";
				 	    		
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
	    			window.location="/pet-license/employee-pay?petId="+id;
	    		}
	    		if(action=='Renewal' )
	    		{
	    			window.location="/pet-license/collect-renew?petId="+id;
	    		}
	    		if(action=='End' )
	    		{
	    			alert('You had already paid fee for this Pet Id')+id;
	    			window.location="/pet-license/collect-fee-search";
	    		}
	    		
	    		
	    		
	    		
	    		if(action=='Approve Pet')
	    		{
	    			window.location="/pet-license/approve-pet?petId="+id;
	    		}
	    		if(action=='Forward Application')
	    		{
	    			window.location="/pet-license/forward-application?petId="+id;
	    		}
	    		
	    		}
	    		
        </script>
