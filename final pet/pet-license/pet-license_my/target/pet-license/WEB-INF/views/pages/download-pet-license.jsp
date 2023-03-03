
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



 </script>
<section id="site-content">
<section id="main-content">
			<section class="wrapper">
			<section class="panel" style="background-color: #fff">
				<header class="panel-heading"></header>
				<div class="panel-body" style="backgroundColor:white">
					<div class="position-center">

<div id="main">

<div style="width:100%;border:solid">
  
<div style="width:100%">
<br>
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
</div>
<div style="width:100%;align:center">
<h4>
<table style="align:center;width:100%;text-align:center;font-size:80%" cellspacing="5" cellpadding="5">

<tr>
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Owner Name</th>
<td id="lvname">${pet.headName}</td>
<td rowspan=5><span><img style="width:180px;height:120px" id="frontPic" alt=""> </span></td>
</tr>

<tr>
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Father's Name of the Owner</th>
<td id="lvfname">${pet.fatherName}</td>
</tr>

<tr>
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Address</th>
<td id="lvdob">${pet.resAddress}</td>
</tr>

<tr>
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Registration Number of the Animal</th>
<td id="lvgender">${pet.registrationNumber}</td>
</tr>

<tr>
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Registration Valid Upto</th>
<td id="lavzone">${pet.validUpto}</td>
</tr>


<tr>
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Type of Animal</th>
<td id="lvtype">${pet.typeBean.typeName}</td>
</tr>

<tr>
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Breed of Animal</th>
<td id="lvtime">${pet.categoryBean.categoryName}</td>
</tr>

<tr>
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>Colour of Animal</th>
<td id="lvmobileno">${pet.colourBean.colourName}</td>
<td><br></td>
</tr>

<tr><td><br></td><th><br></th><td><br></td><td><br></td></tr>
<tr>
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th>
Date:.....................</th>
<td><br></td>
<td style="text-align:right;width=30%">
&nbsp;&nbsp; &nbsp;Approved by</td><td><br></td></tr>
<tr>
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th> Place:.................</th>
<td><br></td>
<td style="text-align:right;width=30%">
&nbsp;&nbsp; &nbsp;${pet.ulbBean.eoName}</td><br><td></td>
</tr>
<tr>
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th><br>
</th>
<td><br></td>
<td style="text-align:right;width=30%">
&nbsp;&nbsp; &nbsp;${pet.ulbBean.officerName}</td><td><br></td>
</tr>
<tr>
<td style="width=30%">&nbsp;&nbsp;&nbsp;</td>
<th> <br></th>
<td><br></td>
<td style="text-align:right;width=30%">
&nbsp;&nbsp; &nbsp;${pet.ulbBean.ulbName}</td><td><br></td>
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
					$('#pblogo').attr('src',"https://lh6.googleusercontent.com/proxy/j27jfHAQHBy9DsVY8ceLuxhLAbOgdfkMHsMILGSHxkjnWDmdAjngM1q-6uzWb-IBUuNXY0uG4CBS");

				});
				 function homePage()
				   {
					  	 window.location="/pet-license/dashboard";
				   }</script>
