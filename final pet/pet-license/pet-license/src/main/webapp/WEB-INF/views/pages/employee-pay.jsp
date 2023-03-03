
<%@ taglib prefix="l" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section id="site-content">
<section id="main-content">
			<section class="wrapper">
			<section class="panel" style="background-color: #999">
				<header class="panel-heading"> Collect Fee for Pet Id ${pet.petId}</header><style>.alert{
  width:50%;
  margin:20px auto;
  padding:30px;
  position:relative;
  border-radius:5px;
  box-shadow:0 0 15px 5px #ccc;
}</style>
				<div class="panel-body">
					<div class="position-center">
						<form method="POST" action="collect-feesave" class="cmxform form-horizontal" name="feeBean" id="collectfeeform" onsubmit="return validateFeeForm()">

							<div class="panel-body">
								<div class=" form">
<div style="text-align:center">
									<span style="color: green; font-size: 16px; font-weight: 786;"
										id="testingErrorMsg">${testingErrorMsg}</span></div>
										<input type="hidden" id="petId" name="petId" value="${pet.petId}">

										<input type="hidden" id="userType" name="userType" value="${userType}">
										<input type="hidden" id="fees" name="fees" value="${fee.receiptDate}">
										<input type="hidden" id="orderId" name="orderId" value="0">
										
										
<br>
<div class="form-group "> 
									 		<label for="curl" class="control-label col-lg-4">District</label> 
									 		<div class="col-lg-8">
                                       <span class="form-control" id='tfdistrict' name="districtBean" >${pet.districtBean.districtName}</span>
									 		</div>
									 	</div>
									 	<div class="form-group "> 
									 		<label for="curl" class="control-label col-lg-4">Municipal Corporation/Council/NP</label> 
									 		<div class="col-lg-8">
                                       <span class="form-control" id='tfdistrict' name="ulbBean" >${pet.ulbBean.ulbName}</span>
									 		</div>
									 	</div>
									 	
									 	<div class="form-group ">
										<label for="cname" class="control-label col-lg-4">Pet Id
										</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="petId" id="petId">${pet.petId}</span>
										</div>
									</div>
									
									 	
									<div class="form-group ">
										<label for="cname" class="control-label col-lg-4">Name of the Applicant
										</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="headName" id="tfname">${pet.headName}</span>
										</div>
									</div>

								<div class="form-group ">
										<label for="cname" class="control-label col-lg-4">Father/Spouse Name</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="fatherName" id="tffname">${pet.fatherName}</span>
										</div>
									</div>
									
									<div class="form-group ">
										<label for="cname" class="control-label col-lg-4">Residential Address in Municipality</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="resAddress" id="tfraddress">${pet.resAddress}</span>
										</div>
									</div>
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">House No.</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="houseNo" id="tfhouse">${pet.houseNo}</span>
										</div>
									</div>
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">Ward No.</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="wardNo" id="tfward">${pet.wardNo}</span>
										</div>
									</div>
									
									<div class="form-group "> 
									 		<label for="curl" class="control-label col-lg-4">Phase/Area/Mohalla/Sector</label> 
									 		<div class="col-lg-8">
                                       <span class="form-control" id='tflocality' name="localityBean">${pet.localityBean.localityName}</span>
									 		</div>
									 	</div>
									<div class="form-group ">
										<label for="cname" class="control-label col-lg-4">Permanent Address</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="perAddress" id="tfpaddress">${pet.perAddress}</span>
										</div>
									</div>
									
									<div class="form-group ">
										<label for="cname" class="control-label col-lg-4">Mobile Number</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="mobileNo" id="tfmobileno">${pet.mobileNo}</span>
										</div>
									</div>
									
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">Email Address</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="email" id="tfemail">${pet.email}</span>
										</div>
									</div>
							<div class="form-group">
										<label for="cname" class="control-label col-lg-4">Email Address</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="email" id="tfemail">${pet.email}</span>
										</div>
									</div>
									
									
									<div class="form-group"> 
									 		<label for="cname" class="control-label col-lg-4">Id/Address proof of owner(Front Page)</label>
										<div class="col-lg-8">
										<img id="idproofownerFront" name="idproofownerFront" width="150" height="150">										
										</div>
									</div>
									<div class="form-group"> 
									 		<label for="cname" class="control-label col-lg-4">Id/Address proof of owner(Back Page)</label>
										<div class="col-lg-8">
										<img id="idproofownerBack" name="idproofownerBack" width="150" height="150">										
										</div>
									</div>
										<div class="form-group"> 
									 		<label for="cname" class="control-label col-lg-4">Fitness Certificate</label>
										<div class="col-lg-8">
										<img id="fitnesscertificate" name="fitnesscertificate" width="150" height="150">										
										</div>
									</div>
									
									
									<div class="form-group "> 
									 		<label for="curl" class="control-label col-lg-4">Category of Animal</label> 
									 		<div class="col-lg-8">
                                       <span class="form-control" id='tfcategory' name="categoryBean">${pet.categoryBean.categoryName}</span>
									 	  
										</div>
									</div>
									
									<div class="form-group "> 
									 		<label for="curl" class="control-label col-lg-4">Breed of Animal</label> 
									 		<div class="col-lg-8">
                                       <span class="form-control" id='tftype' name="typeBean">${pet.typeBean.typeName}</span>
										</div>
									</div>
									
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">Name of Animal</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="email" id="tfemail">${pet.nameofdog}</span>
										</div>
									</div>
									<div class="form-group"> 
									 		<label for="curl" class="control-label col-lg-4">Gender of Animal</label> 
									 		<div class="col-lg-8">
                                       		<span class="form-control" type="text" name="doggender" id="doggender">${pet.doggender}</span>
										</div>
									</div>
									
									<div class="form-group"> 
									 		<label for="curl" class="control-label col-lg-4">Vaccination?</label> 
									 		<div class="col-lg-8">
                                       		<span class="form-control" type="text" name="vacc" id="vacc">${pet.vacc}</span>
 										</select>
										</div>
									</div>
									
									
									
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">Identification Mark of Animal</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="petmark" id="petmark"> ${pet.petmark}</span>
										</div>
									</div>
									
									<div class="form-group">
										<label for="cname" class="control-label col-lg-4">Age of Animal</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="ageofdog" id="ageofdog">${pet.ageofdog}</span>
										</div>
									</div>			
									
									
									
									
									
									
									<div class="form-group "> 
									 		<label for="curl" class="control-label col-lg-4">Colour of Animal</label> 
									 		<div class="col-lg-8">
                                       <span class="form-control" id='tfcolour' name="colourBean">${pet.colourBean.colourName}</span>
										</div>
									</div>
									
									<div class="form-group "> 
									 		<label for="cname" class="control-label col-lg-4">Any defect in the animal?</label>
										<div class="col-lg-8">
												<img id="defect" name="defect" width="150" height="150">										
												</div>
									</div>
									
									<div class="form-group "> 
									 		<label for="cname" class="control-label col-lg-4">Has the animal been certified by the veterinary Doctor to be free from infectious diseases?(Front Page)</label>
										<div class="col-lg-8">
												<span><img id="certificate" alt="No Pic Uploaded"  width="150" height="150"></span>									
												</div><br><br><br>
												<div class="form-group "> 
									 		<label for="cname" class="control-label col-lg-4">Has the animal been certified by the veterinary Doctor to be free from infectious diseases?(Back Page)</label>
										<div class="col-lg-8">
												<span><img id="certificateBack" alt="No Pic Uploaded"  width="150" height="150"></span>									
												</div>
									</div>
									
																		
									<!-- 									 	<div id="picsection" style="display:none"> -->
									 	
									 	<div class="form-group "> 
									 		<label for="cname" class="control-label col-lg-4">Animal Photograph</label>
										<div class="col-lg-8">
												<img id="front" name="front" width="150" height="150">										
												</div>
									</div>
									<div class="form-group "> 
									 		<label for="cname" class="control-label col-lg-4">Photograph of the owner</label>
										<div class="col-lg-8">
												<img id="owner" name="owner" width="150" height="150">										
												</div>
									</div>
									
									<l:choose>
									<l:when test="${pet.apptype == 'New' && pet.fee=='No' }">
									
									<div class="form-group required"> 
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Registration Fee to Collect</label>
										<div class="col-lg-8">
												<input type="text" id="amount" name="amount" value="${pet.ulbBean.regFee}">										
												</div>
									</div>
									 		<label for="cname" class="control-label col-lg-4">Purpose</label>
										<div class="col-lg-8">
												<select name="purpose" class="form-control">
												<option value="Registration Fee">Registration Fee</option>
												</select>									
												</div>
									</div>
										<div style="float: right;">
									 <button type="submit" id="collectfee" class="btn btn-info" onclick="return confirm('Have You Collected Cash From Applicant?')"  >Collect Fee</button>
									
									</div>
									</l:when>
									
									
									
										<l:when test="${pet.apptype=='Renew' && pet.fee=='No'}">
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Renewal Fee to Collect</label>
										<div class="col-lg-8">
												<input type="text" id="amount" name="amount" value="${pet.ulbBean.renew}">										
												</div>
									</div>
									
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Purpose</label>
										<div class="col-lg-8">
												<select name="purpose" class="form-control" style="pointer-events: none;">
												<option value="Renewal" style="pointer-events: none;">Renewal</option>
												</select>									
												</div>
									</div>
										<div style="float: right;">
									 <button type="submit" id="collectfee" class="btn btn-info" onclick="return confirm('Have You Collected Cash From Applicant?')"  >Collect Fee</button>
									
									</div>
									</l:when>
											<l:otherwise>
									<div> 
									 	<span style="text-align:center;color: green; font-size: 16px; font-weight: 786;"> Registration Fee has already been collected.</span>
									</div>
									
									</l:otherwise>
									
									
									</l:choose>
																 	
																		 	</div>
									

								
								
							
						</form>
					</div>
				</div>
			</section>
			</section>
			</section>
			</section>
			
			<script>
			$(document).ready(function(){
				
				var petid=$('#petId').val();
				var userType=$('#userType').val();
				n =  new Date();
				debugger;
				
				
				if(userType>2)
					{
					document.getElementById('amount').disabled=true;
					document.getElementById('payfee').style.display='block';

					document.getElementById('collectfee').style.display='none';

					
					}
				debugger;
			  	var petid=$('#petId').val();
				$('#defect').attr('src',"/pet-license/getAttachedDocuments/DEFECT?pet_id="+petid);
	       		$('#certificate').attr('src',"/pet-license/getAttachedDocuments/CERTIFICATE?pet_id="+petid);
	       		$('#certificateBack').attr('src',"/pet-license/getAttachedDocuments/CERTIFICATEBACK?pet_id="+petid);

	       		$('#front').attr('src',"/pet-license/getAttachedDocuments/FRONT?pet_id="+petid);
	       		$('#owner').attr('src',"/pet-license/getAttachedDocuments/OWNER?pet_id="+petid);
	       		$('#idproofownerFront').attr('src',"/pet-license/getAttachedDocuments/ID?pet_id="+petid);
	       		$('#idproofownerBack').attr('src',"/pet-license/getAttachedDocuments/IDBACK?pet_id="+petid);
	       		$('#fitnesscertificate').attr('src',"/pet-license/getAttachedDocuments/FITNESS?pet_id="+petid);
	       					
			});
			
			function validateFeeForm()
			{
				var fee=$('#amount').val();
				if(fee=="")
					{
					alert("Please enter registration fee to collect");
					return false;}
				return true;
			}
			
			
			</script>
				<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
			<!-- <script src="https://axis.razorpay.com/#/access/signin"></script> -->
			<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
			<script type="text/javascript">
			

			// firrst request to server to create order
			const paymentStart = () => {
				console.log("payment started..");
				var amount = $("#payment_field").val();
				var ulbcode=$("#ulbcode").val();
				var paymentpetid=$("#payment_pet_id").val();
				console.log(amount);
				if(amount == '' || amount==null)
					{
					//alert("amount is required !!");
					swal("Opps!", "Amount is required !!", "error");
					return;
					}
				
				//request server for create order
				$.ajax({
					url:"create_order",
					data:JSON.stringify({amount:amount,info:'order_request',paymentpetid:paymentpetid,ulbcode:ulbcode}),
					contentType:'application/json',
					type:'POST',
					dataType:'json',
					success:function(response){
						//involved when success
						console.log(response);
						if(response.status == "created"){
							let options={
									key:'rzp_live_H2n9kGeN5lFKnU',
									amount:response.amount,
									currency:'INR',
									name:'Citizen Pet License Fee',
									description:'Description about pet Fee',
									image:"https://lh6.googleusercontent.com/proxy/j27jfHAQHBy9DsVY8ceLuxhLAbOgdfkMHsMILGSHxkjnWDmdAjngM1q-6uzWb-IBUuNXY0uG4CBS",
									order_id:response.id,
									"handler": function (response){
									    console.log(response.razorpay_payment_id);
									    console.log(response.razorpay_order_id);
									    console.log(response.razorpay_signature);
									    console.log("congrates !! Payment successfull");
									    console.log(response);
								       // alert(response.amount_paid);
								       debugger;
									    updatePaymentOnServer(response.razorpay_payment_id,response.razorpay_order_id,response.status);
									    
									    swal("Good job!", "Congrates !! Payment successfull ", "success");
										window.location="/pet-license/payment-success-online?order="+response.razorpay_order_id;
									    
									},
										
									
									prefill:{
									name:"",
									email:"",
									contact:"",
									},
									notes:{
										payment:"pet license fee",
										address:"sector thirtyfive",
									},
									theme:{
										color:"#3399cc",
									},
							};
							var Rzoper
							let rzp = new Razorpay(options);
							
							rzp.on("payment.failed", function(response){
							    console.log(response.error.code);
							    console.log(response.error.description);
							    console.log(response.error.source);
							    console.log(response.error.step);
							    console.log(response.error.reason);
							    console.log(response.error.metadata.order_id);
							    console.log(response.error.metadata.payment_id);
							    //alert("Opps payment failed !!");
							  
							    swal("Failed!", "Opps payment failed", "error");
							});
							
							rzp.open();
							
						} 
					},
					error: function (error){
						//invoked when error
						console.log(error);
						//alert("somthing went wrong");
						swal("Opps!", "Somthing went wrong", "error");
					}
				});
			
			};
			
			function updatePaymentOnServer(payment_id,order_id,status)
			{
				$.ajax({
					url:"update_order",
					data:JSON.stringify({payment_id:payment_id,order_id:order_id,status:status,}),
					contentType:'application/json',
					type:'POST',
					dataType:'json',
				});   
			};
			
		
		
				
			</script>
			
				
<script type="text/javascript">
    $(document).ready(function() {
    	//var amount=$("#amount1").val();
    	let amount =document.querySelector('.searchField').value;
    
    	amount=amount*10;
    	alert("Penalty of amount "+amount+"  has To be Paid By The Citizen");
            $("#amount").val(amount);
            });
</script>
            	
          