<script language="javascript" type="text/javascript">

//Print function for any div 
function printDiv(divName) {
var printContents = document.getElementById(divName).innerHTML;
var originalContents = document.body.innerHTML;
document.body.innerHTML = printContents;
$("a").removeAttr("href");
window.print();
document.body.innerHTML = originalContents;
}


$('#pblogo').attr('src',"https://lh6.googleusercontent.com/proxy/j27jfHAQHBy9DsVY8ceLuxhLAbOgdfkMHsMILGSHxkjnWDmdAjngM1q-6uzWb-IBUuNXY0uG4CBS");



 </script>
<section id="site-content">
<section id="main-content">
			<section class="wrapper">
			<section class="panel" style="background-color: #fff">
				<header class="panel-heading"><p style="color:green"> ${fee.purpose} has been collected successfully.</p></header>
				<div class="panel-body" style="backgroundColor:white">
					<div class="position-center">

<div id="main">

<div style="width:100%;border:solid">
  
<div style="width:100%">
<br>
</div>



<table style="width:100%;font-size:15px">
<tr>
<td width=5%><br></td>
<td width=20%>	<img id="" src="https://lh6.googleusercontent.com/proxy/j27jfHAQHBy9DsVY8ceLuxhLAbOgdfkMHsMILGSHxkjnWDmdAjngM1q-6uzWb-IBUuNXY0uG4CBS" style="width:60%;height:80px"></td>
<td width=60% style="text-align:left">
<div>
<h3>                 
<p style="text-transform: uppercase;text-align:center">${pet.ulbBean.ulbType},<span style="font-style:normal">${pet.ulbBean.ulbName} </span></p>
<p style="text-align:center;font-size:20px">Pet Registration Certificate</p>
</h3>
</div>
</td>
<td width=10%><br></td>
</tr></table><br>




<div style="width:100%;align:center">
<h4>
<table style="align:center;width:100%;text-align:center;font-size:80%" cellspacing="5" cellpadding="5">

<tr style="border:1px solid black;">
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Owner Name</th>
<td id="lvname">${pet.headName}</td>
<td rowspan=5><span><img style="width:180px;height:120px" id="frontPic" alt=""> </span></td>
</tr>

<tr style="border:1px solid black;">
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Father's Name of the Owner</th>
<td id="lvfname">${pet.fatherName}</td>
</tr>

<tr style="border:1px solid black;">
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Mobile Number</th>
<td id="lvfname">${pet.mobileNo}</td>
</tr>

<tr style="border:1px solid black;">
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Residential Address</th>
<td id="lvdob">${pet.resAddress}</td>
</tr>

<tr style="border:1px solid black;">
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Permanent Address</th>
<td id="lvfname">${pet.perAddress}</td>
</tr>


<tr style="border:1px solid black;">
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>House No.</th>
<td id="lvfname">${pet.houseNo}</td>
</tr>

<tr style="border:1px solid black;">
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Ward No.</th>
<td id="lvfname">${pet.wardNo}</td>
</tr>

<tr style="border:1px solid black;">
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Locality</th>
<td id="lvfname">${pet.localityBean.localityName}</td>
</tr>

<tr style="border:1px solid black;">
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Category of Animal</th>
<td id="lvfname">${pet.categoryBean.categoryName}</td>
</tr>


<tr style="border:1px solid black;">
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Breed of animal</th>
<td id="lavzone">${pet.typeBean.typeName}</td>
</tr>


<tr style="border:1px solid black;">
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Colour of Animal</th>
<td id="lvtype">${pet.colourBean.colourName}</td>
</tr>

<tr style="border:1px solid black;">
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Purpose</th>
<td id="lvtime">${fee.purpose}</td>
</tr>

<tr style="border:1px solid black;">
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Receipt Number</th>
<td id="lvmobileno">${fee.receiptNumber}</td>
<td><br></td>
</tr>


<tr style="border:1px solid black;">
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Receipt Date</th>
<td id="lvmobileno">${fee.receiptDate}</td>
<td><br></td>
</tr>


<tr style="border:1px solid black;">
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Collected By</th>
<td id="lvmobileno">${fee.userBean.userName}</td>
<td><br></td>
</tr>

<tr style="border:1px solid black;">
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Amount</th>
<td id="lvmobileno">${fee.amount}</td>
<td><br></td>
</tr>

<tr style="border:1px solid black;">
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Pet Id</th>
<td id="lvmobileno">${fee.headBean.petId}</td>
<td><br></td>
</tr>

<tr style="border:1px solid black;">
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Status Message</th>
<td id="lvmobileno">Success</td>
<td><br></td>
</tr>






<tr><td><br></td><th><br></th><td><br></td><td><br></td></tr>
<tr>
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>
Date:.....................</th></tr>
<tr>
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th> Place:.................</th>
<td><br></td>
<td style="text-align:right;width=30%">
&nbsp;&nbsp; &nbspSignature of Authorized signatory</td><td></td>
</tr>
</table></h4>

		
	<br>
	<div></div></div></div>
	
		</div>					
<div align="center">					
<button class="btn-primary btn sucPage" style="align:center" id="downloadReceipt" onclick="printDiv('main')" type="button">Print License</button>
					<button class="btn-default btn" type="button" onclick="homePage()">Cancel</button>
<br><div></div>
				</div></div></div>	</section></section></section></section>
				
				<script>
				
				$(document).ready(function(){
					
					var petid=${pet.petId};
					debugger;
					$('#frontPic').attr('src',"/pet-license/getAttachedDocuments/FRONT?pet_id="+petid);
				});
				 function homePage()
				   {
					  	 window.location="/pet-license/dashboard";
				   }</script>
