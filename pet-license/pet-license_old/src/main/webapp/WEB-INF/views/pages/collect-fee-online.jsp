
<%@ taglib prefix="l" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="site-content">
<section id="main-content">
		<section class="wrapper">
			<section class="panel" style="background-color: #999">
				<head>
				<header class="panel-heading"> Collect Fee for Pet Id ${pet.petId}</header>
					<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
				</head>
				<div class="panel-body">
					<div class="position-center">
						<div class="cmxform form-horizontal" name="feeBean" id="collectfeeform" onsubmit="return validateFeeForm()">


							<div class="panel-body">
								<div class=" form">
						<div style="text-align:center">
										<span style="color: green; font-size: 16px; font-weight: 786;"
										id="testingErrorMsg">${testingErrorMsg}</span></div>
										<input type="hidden" id="petId" name="petId" value="${pet.petId}">

										<input type="hidden" id="userType" name="userType" value="${userType}">
										<input type="hidden" name="redirect_url"
					value="http://petlicense.punjab.gov.in/pet-license/ccavResponseHandler"/>
					<input type="hidden" name="cancel_url"
					value="http://petlicense.punjab.gov.in/pet-license/collect-fee-online?petId=${pet.petId}"/>
			<input type="hidden" name="language" id="language" value="EN" />
			<input type="hidden" name="merchant_id" id="merchant_id" value="266201" />
			<input type="hidden" name="tid" id="tid" value="76040933" readonly />
			<input type="hidden" name="currency" value="INR" />
			<input type="hidden" name="amount" value="<%= session.getAttribute("amount")%>" />
			<input type="hidden" name="order_id" value="<%= session.getAttribute("s_order_id") %>" />
			
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
										<label for="cname" class="control-label col-lg-4">Name of the Applicant
										</label>
										<div class="col-lg-8">
										<span class="form-control" type="text"  name="headName" id="tfname">${pet.headName}</span>
										</div>
									</div>

								<div class="form-group ">
										<label for="cname" class="control-label col-lg-4">Father's Name</label>
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
									 		<label for="curl" class="control-label col-lg-4">Locality/Area/Mohalla</label> 
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
									<div class="form-group "> 
									 		<label for="curl" class="control-label col-lg-4">Category of Animal</label> 
									 		<div class="col-lg-8">
                                       <span class="form-control" id='tfcategory' name="categoryBean">${pet.categoryBean.categoryName}</span>
									 	  
										</div>
									</div>
									<div class="form-group "> 
									 		<label for="curl" class="control-label col-lg-4">Type of Animal</label> 
									 		<div class="col-lg-8">
                                       <span class="form-control" id='tftype' name="typeBean">${pet.typeBean.typeName}</span>
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
												<img id="defectPicPP" name="defectPicPP" width="100" height="100">										
												</div>
									</div>
									
									<div class="form-group "> 
									 		<label for="cname" class="control-label col-lg-4">Has the animal been certified by the veterinary Doctor to be free from infectious diseases?</label>
										<div class="col-lg-8">
												<span><img id="certificatePicPP" alt="No Pic Uploaded"  width="100" height="100"></span>									
												</div>
									</div>
																		
										<div class="form-group "> 
									 		<label for="curl" class="control-label col-lg-4">Has the fee for registration/renewal been paid?</label> 
									 		<div class="col-lg-8">
                                       <span class="form-control" id='tffee' name="fee">${pet.fee}</span>
 									 		</div>
									 	</div>
<!-- 									 	<div id="picsection" style="display:none"> -->
									 	
									 	<div class="form-group "> 
									 		<label for="cname" class="control-label col-lg-4">Animal Photograph(Front View)</label>
										<div class="col-lg-8">
												<img id="frontPicPP" name="frontPicPP" width="100" height="100">										
												</div>
									</div>
									<div class="form-group "> 
									 		<label for="cname" class="control-label col-lg-4">Animal Photograph(Back View)</label>
										<div class="col-lg-8">
												<img id="backPicPP" name="backPicPP" width="100" height="100">										
												</div>
									</div>
									<div class="form-group "> 
									 		<label for="cname" class="control-label col-lg-4">Animal Photograph(Left View)</label>
										<div class="col-lg-8">
												<img id="leftPicPP" name="leftPicPP" width="100" height="100">										
												</div>
									</div>
									<div class="form-group "> 
									 		<label for="cname" class="control-label col-lg-4">Animal Photograph(Right View)</label>
										<div class="col-lg-8">
												<img id="rightPicPP" name="rightPicPP" width="100" height="100">										
												</div>
									</div>
									<div class="form-group "> 
									 		<label for="cname" class="control-label col-lg-4">Photograph of the owner</label>
										<div class="col-lg-8">
												<img id="ownerPicPP" name="ownerPicPP" width="100" height="100">										
												</div>
									</div>
									<l:choose>
									<l:when test="${pet.fee == 'No'}">
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Enter Fee to Collect</label>
										<div class="col-lg-8">
												<input type="text" id="payment_field" value="${pet.ulbBean.regFee}">										
												</div>
									</div>
									
									<div class="form-group required"> 
									 		<label for="cname" class="control-label col-lg-4">Purpose</label>
										<div class="col-lg-8">
												<select name="purpose" class="form-control">
												<option value="Registration Fee">Registration Fee</option>
												</select>									
												</div>
									</div>
									</l:when>
									<l:otherwise>
									<div> 
									 	<span style="text-align:center;color: green; font-size: 16px; font-weight: 786;"> Registration Fee has already been collected.</span>
									</div>
									
									</l:otherwise>
									</l:choose>
									
																 	
								</div>
								
								
								<div style="float: right;">
										<l:choose>
									<l:when test="${pet.fee == 'No'}">
									<button class="btn btn-block btn-info" onclick="paymentStart()" value="">Pay Fee For License</button>
									</l:when>
									</l:choose>
									</div>
				
				
				
				
				
				
						
						<!-- <input type="text" id="payment_field" class="form-controll my-2" placeholder="enter amount here"/>
						<div class="container text-center mt-3">
							<button onclick="paymentStart()" class="btn btn-success btn-block">Pay Fee</button>
						</div> -->
					
						</div>
					</div>
				</body>
				</html>
			</section>
		</section>
	</section>
</section>



// This is Razorpay payment gateway web integration 
			<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
			<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
			<script type="text/javascript">
			

			// firrst request to server to create order
			const paymentStart = () => {
				console.log("payment started..");
				var amount = $("#payment_field").val();
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
					data:JSON.stringify({amount:amount,info:'order_request'}),
					contentType:'application/json',
					type:'POST',
					dataType:'json',
					success:function(response){
						//involved when success
						console.log(response);
						if(response.status == "created"){
							let options={
									key:'rzp_test_S4AA2WsFm8nw35',
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
								       
									    updatePaymentOnServer(response.razorpay_payment_id,response.razorpay_order_id,response.status);
									    
									    swal("Good job!", "Congrates !! Payment successfull ", "success");
									    
									},
										
									
									prefill:{
									name:"",
									email:"",
									contact:"",
									},
									notes:{
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
// This is Razorpay payment gateway web integration 
			
			
			<script>
			$(document).ready(function(){
				
				var petid=$('#petId').val();
				var userType=$('#userType').val();
				$('#defectPicPP').attr('src',"/pet-license/getAttachedDocuments/DEFECT?pet_id="+petid);
	       		$('#certificatePicPP').attr('src',"/pet-license/getAttachedDocuments/CERTIFICATE?pet_id="+petid);
	       		$('#frontPicPP').attr('src',"/pet-license/getAttachedDocuments/FRONT?pet_id="+petid);
	       		$('#backPicPP').attr('src',"/pet-license/getAttachedDocuments/BACK?pet_id="+petid);
	       		$('#rightPicPP').attr('src',"/pet-license/getAttachedDocuments/RIGHT?pet_id="+petid);
	       		$('#leftPicPP').attr('src',"/pet-license/getAttachedDocuments/LEFT?pet_id="+petid);
	       		$('#ownerPicPP').attr('src',"/pet-license/getAttachedDocuments/OWNER?pet_id="+petid)
	       		var d = new Date().getTime();
	    		document.getElementById("tid").value = d;
				
				
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
			
			