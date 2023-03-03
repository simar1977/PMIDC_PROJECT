<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setBundle basename="message_pb"/>
<section id="site-content">
<section id="main-content">
			<section class="wrapper">
			<section class="panel" style="background-color: #999">
				<header class="panel-heading"> Pet Registration form</header>
				<div class="panel-body">
					<div class="position-center">
						<form method="POST" action="registration-data" class="cmxform form-horizontal" name="petBean" id="testingDataForm" onsubmit="return validateTestingDataForm()" enctype="multipart/form-data">
<div style="text-align:center">
									<span style="color: green; font-size: 16px; font-weight: 786;"
										id="testingErrorMsg">${testingErrorMsg}</span></div>
										<br>
										<input type="hidden" id="usersType" name="usersType" value="${usersType}">
										<input type="hidden" id="defaultDD" name="defaultDD" value="${district}">
										<input type="hidden" id="defaultULB" name="defaultULB" value="${ulb}">
										
							<div class="panel-body">
								<div class=" form">
								
								<div class="form-group required" id="dd"> 
									 		<label for="curl" class="control-label col-lg-4">District</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='tfdistrict' name="districtBean" onchange="loadUlb()"></select>
									 		</div>
									 	</div>
									 	
								<div class="form-group required" id="ll"> 
									 		<label for="curl" class="control-label col-lg-4">Municipal Corporation/Council/NP</label> 
									 		<div class="col-lg-8">
                                     <select class="form-control" id='tfulb' name="ulbBean" onchange="loadLocality()"></select>
									 		</div>
								</div>
									 	

									<div class="form-group required">
										<label for="cname" class="control-label col-lg-4">Name Of the applicant</label>
										<div class="col-lg-8">
										<input class="form-control" type="text" id="headName" name="headName" id="tfname">
										</div>
									</div>
									
									<div class="form-group required">
										<label for="cname" class="control-label col-lg-4">Father's Name</label>
										<div class="col-lg-8">
										<input class="form-control" type="text" id="fatherName" name="fatherName" id="tffname">
										</div>
									</div>
									
									<div class="form-group required">
										<label for="cname" class="control-label col-lg-4">Residential Address in Municipality</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="resAddress" id="tfraddress">
										</div>
									</div>
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">House No.</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="houseNo" id="tfhouse">
										</div>
									</div>
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">Ward No.</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="wardNo" id="tfward">
										</div>
									</div>
									
									<div class="form-group required"> 
									 		<label for="curl" class="control-label col-lg-4">Locality/Area/Mohalla</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='tflocality' name="localityBean"></select>
									 		</div>
									 	</div>
									<div class="form-group required">
										<label for="cname" class="control-label col-lg-4">Permanent Address</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="perAddress" id="tfpaddress">
										</div>
									</div>
									
									<div class="form-group required">
										<label for="cname" class="control-label col-lg-4">Mobile Number</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="mobileNo" id="tfmobileno">
										</div>
									</div>
									
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">Email Address</label>
										<div class="col-lg-8">
										<input class="form-control" type="text"  name="email" id="tfemail">
										</div>
									</div>
									<div class="form-group required"> 
									 		<label for="curl" class="control-label col-lg-4">Category of Animal</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='tfcategory' name="categoryBean">
									 	   <option value="">Select Category</option>  
 										</select>
										</div>
									</div>
									<div class="form-group required"> 
									 		<label for="curl" class="control-label col-lg-4">Type of Animal</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='tftype' name="typeBean">
									 	   <option value="">Select type</option>  
 										</select>
										</div>
									</div>
									
									<div class="form-group required"> 
									 		<label for="curl" class="control-label col-lg-4">Colour of Animal</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='tfcolour' name="colourBean">
									 	   <option value="">Select Colour</option>  
 										</select>
										</div>
									</div>
									
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Any defect in the animal?</label>
										<div class="col-lg-8">
												<input type="file" id="defectPicPP" name="defectPicPP" onchange="Filevalidation(this.id)">										
												</div>
									</div>
									
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Has the animal been certified by the veterinary Doctor to be free from infectious diseases?</label>
										<div class="col-lg-8">
												<input type="file" id="certificatePicPP" name="certificatePicPP" onchange="Filevalidation(this.id)">										
												</div>
									</div>
																		
										<div class="form-group required"> 
									 		<label for="curl" class="control-label col-lg-4">Has the fee for registration/renewal been paid?</label> 
									 		<div class="col-lg-8">
                                       <select class="form-control" id='tffee' name="fee">
                                       <option value="">Select from below</option>
                                       <option value="Yes">Yes</option>
                                       <option value="No">No</option>
                                       </select>
									 		</div>
									 	</div>
<!-- 									 	<div id="picsection" style="display:none"> -->
									 	
									 	<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Animal Photograph(Front View)</label>
										<div class="col-lg-8">
												<input type="file" id="frontPicPP" name="frontPicPP" onchange="Filevalidation(this.id)">										
												</div>
									</div>
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Animal Photograph(Back View)</label>
										<div class="col-lg-8">
												<input type="file" id="backPicPP" name="backPicPP" onchange="Filevalidation(this.id)">										
												</div>
									</div>
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Animal Photograph(Left View)</label>
										<div class="col-lg-8">
												<input type="file" id="leftPicPP" name="leftPicPP" onchange="Filevalidation(this.id)">										
												</div>
									</div>
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Animal Photograph(Right View)</label>
										<div class="col-lg-8">
												<input type="file" id="rightPicPP" name="rightPicPP" onchange="Filevalidation(this.id)">										
												</div>
									</div>
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Photograph of the owner</label>
										<div class="col-lg-8">
												<input type="file" id="ownerPicPP" name="ownerPicPP" onchange="Filevalidation(this.id)">										
												</div>
									</div>
								
									 	
											
									
										<div style="float: right;">
									 <button type="submit" class="btn btn-info">Submit</button>
                                <button class="btn btn-danger" type="reset" id="resetFormDataBtn">Cancel</button>
                                </div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</section>
			</section>
			</section>
			</section>
			
			 <script type="text/javascript">
            $(".myselect").select2();
            $(document).ready(function () {
            	debugger;
            	var userType= $('#usersType').val();
            	var ddd=$('#defaultDD').val();
            	var lll=$('#defaultULB').val();
            	if(userType == "STAFF"){ document.getElementById('dd').style.display='none';
            	document.getElementById('ll').style.display='none';
            	$('#tfdistrict').val(ddd);
            	$('#tfulb').val(lll);
            	loadLocality();}
            	else
            		{
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
            			
            			$.ajax({
                    	    url: "get-category",
                    	    type: 'GET',
                    	    datatype:"json",
                    	    contentType: "application/json; charset=utf-8",
                    	    success: function (responce)
                    	    {
                    	    	var htm = "<option value=''> Select Category</option>";
                    	    	 var data = JSON.stringify(responce);
                    	         	var obj = JSON.parse(data);
                    	             $.each(obj, function(index,item) {        
                    	htm = htm +' <option value='+item.categoryCode+'>'+item.categoryName+'</option>';
                    	             });
                    	             htm = htm;
                    	             $('#tfcategory').html(htm);  
                    	             }      
                    	});		
            			
            			
            			
            			
            			$.ajax({
                    	    url: "get-type",
                    	    type: 'GET',
                    	    datatype:"json",
                    	    contentType: "application/json; charset=utf-8",
                    	    success: function (responce)
                    	    {
                    	    	var htm = "<option value=''> Select type</option>";
                    	    	 var data = JSON.stringify(responce);
                    	         	var obj = JSON.parse(data);
                    	             $.each(obj, function(index,item) {        
                    	htm = htm +' <option value='+item.typeCode+'>'+item.typeName+'</option>';
                    	             });
                    	             htm = htm;
                    	             $('#tftype').html(htm);  
                    	             }      
                    	});
            			
            			
            			$.ajax({
                    	    url: "get-colour",
                    	    type: 'GET',
                    	    datatype:"json",
                    	    contentType: "application/json; charset=utf-8",
                    	    success: function (responce)
                    	    {
                    	    	var htm = "<option value=''> Select colour</option>";
                    	    	 var data = JSON.stringify(responce);
                    	         	var obj = JSON.parse(data);
                    	             $.each(obj, function(index,item) {        
                    	htm = htm +' <option value='+item.colourCode+'>'+item.colourName+'</option>';
                    	             });
                    	             htm = htm;
                    	             $('#tfcolour').html(htm);  
                    	             }      
                    	});
            			
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
            {var userType= $('#usersType').val();
        	if(userType == "STAFF"){ 
            	var ulb=$('#defaultULB').val();
        	}
        	else{
        
            	  var ulb= $('#tfulb').val();}
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
               	
         
            function Filevalidation(id){
            	debugger;
                var fi = document.getElementById(id); 
                // Check if any file is selected. 
                if (fi.files.length > 0) { 
                    for (var i = 0; i <= fi.files.length - 1; i++) { 
          
                        const fsize = fi.files.item(i).size; 
                        const file = Math.round((fsize / 1024)); 
                        // The size of the file. 
                        if (file >= 1024) { 
                            alert( 
                              "File too Big, please select a file less than 1mb"); 
                            document.getElementById(id).value="";
                        } 
                        else {
                        } 
                    } 
                } 
            } 
        

//             	function checkfee()
//             	{
//             		debugger;
//             		var feepaid=$('#tffee').val();
            		
//             		if(feepaid=='Yes')
//             			{
//             			document.getElementById('picsection').style.display='block';
//             			}
//             		else{
//         			document.getElementById('picsection').style.display='none';
//         			}
            		
//             	}
           
        </script>
