<%@ taglib prefix="l" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script language="javascript" type="text/javascript">
$(document).ready(function(){

	$('#pblogo').attr('src',"https://lh6.googleusercontent.com/proxy/j27jfHAQHBy9DsVY8ceLuxhLAbOgdfkMHsMILGSHxkjnWDmdAjngM1q-6uzWb-IBUuNXY0uG4CBS");

	
});

//Print function for any div 
function printDiv(divName) {
var printContents = document.getElementById(divName).innerHTML;
var originalContents = document.body.innerHTML;
document.body.innerHTML = printContents;
$("a").removeAttr("href");
window.print();
document.body.innerHTML = originalContents;
}



 </script>
<section id="site-content">
<section id="main-content">
			<section class="wrapper">
			<section class="panel" style="background-color: #fff">
				<l:choose>
					<l:when test="${fee.userBean.userName != null}">
								
							<header class="panel-heading"><p style="color:green"> ${fee.purpose} has been collected successfully.</p></header>
				</l:when>
				<l:otherwise>
								<header class="panel-heading"><p style="color:green"> ${fee.purpose} has been paid successfully.</p></header>
				
				</l:otherwise></l:choose>
				<div class="panel-body" style="backgroundColor:white">
					<div class="position-center">

<div id="main">
<input type="hidden" id="uu" value="${fee.userBean.userName}"/>

<table style="width:100%;font-size:15px">
<tr>
<td width=5%><br></td>
<td width=20%>	<img id="pblogo" style="width:60%;height:80px"></td>
<td width=60% style="text-align:left">
<div>
<h3>                 
<p style="text-transform: uppercase;text-align:center">${pet.ulbBean.ulbType},<span style="font-style:normal">${pet.ulbBean.ulbName} </span></p>
<p style="text-align:center;font-size:20px">Pet Registration Certificate</p>
</h3>
</div>
</td>
<td width=10%><br></td>
</tr></table>
<br>	
<table border="4" width="100%" height="15" style="border-collapse: collapse;padding-left:5px; border: 3px solid #000000" border="2" cellspacing="10" cellpadding="10">
		
<tr>
					<td>	<label class="col-sm-4 control-label">Name of the Applicant</label></td>
						<td>  
						<label id="psv-name" class="form-control1" maxlength="55" style="width:100%">${pet.headName}</label></td>
			
					<td>
						<label  class="col-sm-4 control-label">Father's Name</td>
					<td>  
						<label id="psv-guardian-name" class="form-control1" maxlength="55" style="width:100%">${pet.fatherName}</label></td>
					</tr>
<tr>
					<td>	<label  class="col-sm-4 control-label">Mobile Number</label></td>
						<td>  
						<label id="psv-mobile" class="form-control1" maxlength="55">${pet.mobileNo}</label></td>
			
					<td>
						<label  class="col-sm-4 control-label">Residential Address</td>
					<td>  
						<label id="psv-dob" class="form-control1" maxlength="55">${pet.resAddress}</td>
					</tr>
					
					<tr>
					<td>	<label  class="col-sm-4 control-label">House No</label></td>
						<td>  
						<label id="psv-gender" class="form-control1" maxlength="55">${pet.houseNo}</label></td>
			
					<td>
						<label  class="col-sm-4 control-label">Ward No</td>
					<td>  
						<label id="psv-reg" class="form-control1" maxlength="55">${pet.wardNo}</td>
					</tr>
					
					<tr>
					<td>	<label  class="col-sm-4 control-label">Permanent Address</label></td>
						<td>  
						<label id="psv-category" class="form-control1" maxlength="55">${pet.perAddress}</label></td>
			
					<td width=30%>
						<label  class="col-sm-4 control-label">Locality</label></td>
					<td width=20%>  
						<label id="psv-guardian-name" class="form-control1" maxlength="55" style="width:100%">${pet.localityBean.localityName}</label></td>
					</tr>
					
					<tr>
					<td>	<label  class="col-sm-4 control-label">Category of Pet</label></td>
						<td>  
						<label id="psv-vending-type" class="form-control1" maxlength="55">${pet.categoryBean.categoryName}</label></td>
			
					<td>
						<label  class="col-sm-4 control-label">Type of Pet</td>
					<td>  
						<label id="psv-vending-time" class="form-control1" maxlength="55">${pet.typeBean.typeName}</td>
					</tr>
					
					<tr>
					<td>	<label  class="col-sm-4 control-label">Colour of Pet</label></td>
						<td>  
						<label id="psv-market-type" class="form-control1" maxlength="55">${pet.colourBean.colourName }</label></td>
			
					<td>
						<label  class="col-sm-4 control-label">Purpose</td>
					<td>  
						<label id="psv-opted-zone" class="form-control1" maxlength="55">${fee.purpose}</td>
					</tr>
					<tr>
					<td>	<label  class="col-sm-4 control-label">Receipt Number</label></td>
						<td>  
						<label id="psv-opted-vending-category" class="form-control1" maxlength="55">${fee.receiptNumber}</label></td>
			
					<td>
						<label  class="col-sm-4 control-label">Receipt Date</td>
					<td>  
						<label id="psv-fee" class="form-control1" maxlength="55">${fee.receiptDate}</td>
					</tr>
						<l:choose>
					<l:when test="${fee.userBean.userName != null}">
								
					<tr>
					<td>	<label  class="col-sm-4 control-label">Collected By</label></td>
						<td>  
						<label id="psv-receipt" class="form-control1" maxlength="55">${fee.userBean.userName}</label></td>
						<td>
						<label  class="col-sm-4 control-label">Amount</td>
					<td>  
						<label id="psv-opted-zone" class="form-control1" maxlength="55">${fee.amount}</label></td>
			
					</tr>
					<tr>
					<td>	<label  class="col-sm-4 control-label">Pet Id</label></td>
						<td>  
						<label id="psv-receipt" class="form-control1" maxlength="55">${fee.headBean.petId}</label></td>
						<td>
						<label  class="col-sm-4 control-label">Status Message</td>
					<td>  
						<label id="psv-opted-zone" class="form-control1" maxlength="55">Success</label></td>
			
					</tr>
					</l:when>
					<l:otherwise>
					<tr>
					<td>	<label  class="col-sm-4 control-label">Pet Id</label></td>
						<td>  
						<label id="psv-receipt" class="form-control1" maxlength="55">${fee.headBean.petId}</label></td>
						<td>
						<label  class="col-sm-4 control-label">Tracking Id</td>
					<td>  
						<label id="psv-opted-zone" class="form-control1" maxlength="55">${fee.trackingId}</label></td>
			
					</tr>
					<tr>
					<td>	<label  class="col-sm-4 control-label">Paid By</label></td>
						<td>  
						<label id="psv-receipt" class="form-control1" maxlength="55">${fee.cardName}</label></td>
						<td>
						<label  class="col-sm-4 control-label">Amount</td>
					<td>  
						<label id="psv-opted-zone" class="form-control1" maxlength="55">${fee.amount}</label></td>
			
					</tr>
					<tr>
					<td>	<label  class="col-sm-4 control-label">Order Id</label></td>
						<td>  
						<label id="psv-receipt" class="form-control1" maxlength="55">${fee.orderId}</label></td>
						<td>
						<label  class="col-sm-4 control-label">Order Status</td>
					<td>  
						<label id="psv-opted-zone" class="form-control1" maxlength="55">${fee.orderStatus}</label></td>
			
					</tr>
					
					</l:otherwise></l:choose>
	
	
	</table>
	<br>
	<br>
	<l:choose>
					<l:when test="${fee.userBean.userName != null}">
	<div align="right"> Signature of Authorized Signatory </div>
	</l:when><l:otherwise>
	
	<p style="font-size:10px">*This is a computer generated receipt and dont require any stamp/signature</p>
	</l:otherwise></l:choose>
	
		
	<br>
	<div></div>
	
		</div>					
<div align="center">					
<button class="btn-primary btn sucPage" style="align:center" id="downloadReceipt" onclick="printDiv('main')" type="button">Print Receipt</button>
					<button class="btn-default btn" type="button" onclick="homePage()">Cancel</button>
<br><div></div>
				</div>	</section></section></section></section>
