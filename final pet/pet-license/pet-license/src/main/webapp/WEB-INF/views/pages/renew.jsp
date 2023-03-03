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
			<input type="hidden" id="last1" name="last1" value="${last1}">
			<input type="hidden" id="userType" name="userType" value="${userType}">
				<br><br>
				<br>
					<div class="position-center" style="width:97%">
					<div> 
					<div  style="float: left;width:100%">
																	
		<form method="POST" class="cmxform form-horizontal" name="petSearchBean" id="petsearchform">
		
		
		<div class="form-group  required " id="dd"> 
									 		<label for="curl" style="text-align:left" class="control-label col-lg-4">District</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='district' name="districtBean" style="border:1px solid red; font-family:Times New Roman, Serif;   font-size: 16px;" onchange="loadUlb()"></select>
									 		</div>
									 	</div>
	
		<div class="form-group required">
										<label for="cname"  style="text-align:left" class="control-label col-lg-4">Registration Number/ Token Number (As per Pet License)</label>
										<div class="col-lg-8">
										<input class="form-control" type="number" name="tokenNo" style="border:1px solid red; font-family:Times New Roman, Serif;   font-size: 16px;" id="tokenNo"   pattern="[a-zA-Z0-9/-]+" title="only numbers are allowed">
										</div>
									</div>
									
									 			
</form>
					<div style="float:right">
					<button  type="button" id="search" onclick="selectPerson()" class="btn btn-info">Search Pet</button></div>
			
					</div>
					<br>
					<br>
					<br><br>
					
					<div class="agile-tables">
					<div class="w3l-table-info" id="tableDiv" style="display:none">
					<table class="position-center" id="elist" style="table-layout: fixed;width:100%;word-wrap:break-word;border: 1px solid black;">
						<thead>
						  <tr style="font-size:13px">
						 	
						 	<th width="4%">Pet ID </th>
						 	<th width="4%" >Name Of Pet </th>
						 	<th width="6%" >Name of Applicant </th>
						 	
							
							<th width="4%">Father/Spouse Name</th>
							<th width="5%">District </th>
							
							<th width="5%">Locality </th>
							<th width="6%">Mobile Number</th>
							<th width="6%">Permanent Address</th>
							<th width=7%>Date Of Application</th>
							<th width=6%>Valid Upto</th>
							<th width=5%>Application Status </th>
							<th width=13%>Action</th>
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.14.1/moment.min.js"></script>
			
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
	    			var a="";
	    			var q="";
	    			const count=0;
		    		var CurrentDate=  moment().format("DD-MM-YYYY");
		    		
		    		CurrentDate=CurrentDate.split('-');
		    		const s1=CurrentDate[2];
		    		const s2=CurrentDate[1];
		    		const s3=CurrentDate[0];
		    		var s=s2+"-"+s3+"-"+s1;	  
		    			    	
		    		
		    		
	          	    var tokenNo=$('#tokenNo').val();
	          	  var district=$('#district').val();
	          	var CurrentYear = new Date().getFullYear();
	          	if(district=="" )
          	    	alert("Please! Select Your District");
	          	    if(tokenNo=="" )
	          	    	alert("Please Enter Your Pet's Registration Number/ Pet License Number ");
	          	 	
	          	    else
	          	    	{
	          	 var userType=8; 
	          	 var status='';
	    			$.ajax({  
	    		    url: 'get-pet-Id',  
	    		    data:{"tokenNo":tokenNo,"district":district},
	    		    type: 'GET',
	    		   success: function(data, textStatus, xhr) {  
	    		    var htm = "";
	    		    var count=1;
	    		    $(data).each(function (index, item) {
	    		    htm = htm+"<tr>" +
	    		    
	    		    "<td style=\"font-size:14px\">"+item.petId+"</td>" +
	    		    "<td style=\"font-size:14px\">"+item.nameofdog+"</td>" +
	    		    "<td style=\"font-size:14px\">"+item.headName+"</td>" +
	    		  
	    		 
		    		"<td style=\"font-size:14px\">"+item.fatherName+"</td>" +
		    		"<td style=\"font-size:14px\">"+item.districtBean.districtName+"</td>" +
		    		
		    		"<td style=\"font-size:14px\">"+item.localityBean.localityName+"</td>"+
		    		"<td style=\"font-size:14px\">"+item.mobileNo+"</td>"+
		    		"<td style=\"font-size:14px\">"+item.perAddress+"</td>"+
		    		"<td style=\"font-size:14px\">"+item.dateOfApplication+"</td>" +
		    		"<td style=\"font-size:14px\">"+item.validUpto+"</td>" +
		    		"<td style=\"font-size:14px\">"+item.status+"</td>";
				
		   if(item.status=="Active")
		    	{
		    		a=item.validUpto.split('-');
		    		const p1=a[2];
		    		const p2=a[1];
		    		const p3=a[0];
		    		var p=p2+"-"+p3+"-"+p1;	
		    		//alert(p);
		    		if(p1==s1-1 && item.status=="Active")
		    		{
		    		let d1 = new Date(s);
		    		let d2 = new Date(p);    		
		    		htm=htm+"<td> <select id=\"actionDD"+item.petId+"\" name=\"actionDD"+item.petId+"\" onChange=\"getaction("+item.petId+")\"><option value=\"\">Select from below</option><option value=\"Renew Pet\"><button style=\"color:teal; background-color: #FFFFC0; border: 10px ridge lightgrey\">RENEW PET LICENSE</button></option>";
		    		
		    		}
		    		else
		    			htm=htm+"<td> <select id=\"actionDD"+item.petId+"\" name=\"actionDD"+item.petId+"\" onChange=\"getaction("+item.petId+")\"><option value=\"\" >Not Appliable For Renewal !</option>";
		    		}
		  
		   if(item.status=="ACTIVE" && item.status!="Active")
			   htm=htm+"<td> <select id=\"actionDD"+item.petId+"\" name=\"actionDD"+item.petId+"\" onChange=\"getaction("+item.petId+")\"><option value=\"\">Select from below</option><option value=\"Pay\"><button style=\"color:teal; background-color: #FFFFC0; border: 10px ridge lightgrey\">Pay License Renewal Fee </button></option>";
   		if(item.status=="Inactive")
   			htm=htm+"<td> <select id=\"actionDD"+item.petId+"\" name=\"actionDD"+item.petId+"\" onChange=\"getaction("+item.petId+")\"><option value=\"\" >Not Appliable For Renewal !</option>";
		    	htm=htm+"</select></td>"+		    		
    		 	"</tr>";
				
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
	    		
	    		
	          	    		
	    		function getaction(id)
	    		{
	    			
	    		var s='actionDD'+id;
	    		//alert(s);
	    		var action=document.getElementById(s).value;
	    		var userType=$('#userType').val();
    			//alert(action);
	    		if(action=="Renew Pet" || action=="RENEW PET")
	    		{
	    			window.location="/pet-license/renew-form?petId="+id;
	    		}
	    		if(action=="Pay" || action=="RENEW PET")
	    		{
	    			//alert(userType);
	    			if(userType==1)
	    				window.location="/pet-license/employee-pay?petId="+id;
	    			else
	    				window.location="/pet-license/citizen-renew?petId="+id;
	    		}
	    		
	    		
	    		
	    	
	    		}
	    		
	    		
        </script>
       