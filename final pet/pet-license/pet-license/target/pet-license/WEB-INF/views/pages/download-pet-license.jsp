
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
 <style type="text/css">
 table,tr,th {padding-left: 2%;
 font-weight : normal !important;}
 </style>
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
<td style="width:5%"><br></td>
<td style="width:20%">	<img id="pblogo" style="width:60%;height:80px"></td>
<td style="text-align:left;width:60%">
<div>
<h3>                 
<p style="text-transform: uppercase;text-align:center">${pet.ulbBean.ulbType},<span style="font-style:normal">${pet.ulbBean.ulbName} </span></p>
<p style="text-align:center;font-size:20px">Pet Registration Certificate</p>
</h3>
</div>
</td>
</tr></table>

</div>
<div style="width:100%;align:center">
<h4>
<table style="align:center;width:100%;text-align:center;font-size:80%;padding:5px" cellspacing="5" cellpadding="5">

<tr style="border:1px solid black;">
<th style="padding-left:2%;"><b>Category</b></th>
<td id="lvname">${pet.categoryBean.categoryName}</td>
<td rowspan=5><span><img style="width:180px;height:120px" id="frontPic" alt=""> </span></td>
</tr>
<tr style="border:1px solid black;">
<th padding-left:2%;">Breed of Animal</th>
<td id="lvtime">${pet.typeBean.typeName}</td>
</tr>
<tr style="border:1px solid black;">
<th style="font-weight : normal !important;padding-left:2%;">Name of Animal</th>
<td id="lvtype">${pet.nameofdog}</td>
</tr>
<tr style="border:1px solid black;">
<th style="font-weight : normal !important;padding-left:2%;">Gender of Animal</th>
<td id="lvtype">${pet.doggender}</td>
</tr>
<tr style="border:1px solid black;">
<th style="font-weight : normal !important;padding-left:2%;">Date Of Birth Of Animal</th>
<td id="lvtime">${pet.ageofdog}</td>
</tr>

<tr style="border:1px solid black;">
<th style="font-weight : normal !important;padding-left:2%;">Colour of Animal</th>
<td id="lvmobileno">${pet.colourBean.colourName}</td>
<td><br></td>
</tr>
<tr style="border:1px solid black;">

<th style="font-weight : normal !important;padding-left:2%;">License Number</th>
<td id="lvgender">${pet.registrationNumber}</td>
</tr>
<tr style="border:1px solid black;">

<th style="font-weight : normal !important;padding-left:2%;">Registration Number/Token No</th>
<td id="lvdob"><b>${pet.tokenNo}</b></td>
</tr>


<tr style="border:1px solid black;">

<th style="font-weight : normal !important;padding-left:2%;">License Issued date</th>
<td id="lavzone">${pet.dateOfApproval}</td>
</tr>
<tr>

<tr style="border:1px solid black;">

<th style="font-weight : normal !important;padding-left:2%;">License Valid Upto</th>
<td id="lavzone">${pet.validUpto}</td>
</tr>
<tr style="border:1px solid black;">

<th style="font-weight : normal !important;padding-left:2%;">Owner Name</th>
<td id="lvname">${pet.headName}</td>
</tr>


<tr style="border:1px solid black;">

<th style="font-weight : normal !important;padding-left:2%;">Father/Spouse Name</th>
<td id="lvfname">${pet.fatherName}</td>
</tr>

<tr style="border:1px solid black;">

<th style="font-weight : normal !important;padding-left:2%;">Address of Owner</th>
<td id="lvdob">${pet.resAddress}</td>
</tr>
<tr><td><br></td><th><br></th><td><br></td><td><br></td></tr>
<tr>

<th style="padding-left:2%;">
Date:.....................</th>
<td><br></td>
<td style="width:30%;text-align:left;">
&nbsp;&nbsp; &nbsp;Approved by</td><td><br></td></tr>
<tr>

<th style="padding-left:2%;"> Place:.................</th>
<td><br></td>
<td style="width:30%;text-align:left;">
&nbsp;&nbsp; &nbsp;${pet.ulbBean.eoName}</td><br><td></td>
</tr>
<tr>

<th><br>
</th>
<td><br></td>
<td style="width:30%;text-align:left;">
&nbsp;&nbsp; &nbsp;${pet.ulbBean.officerName}</td><td><br></td>
</tr>
<tr>

<th> <br></th>
<td><br></td>
<td style="width:30%;text-align:left;">
&nbsp;&nbsp; &nbsp;${pet.ulbBean.ulbName}</td><td><br></td>
</tr>
</table></h4>
<div></div></div>
<div style="display:true;font-size:14px;background-color:white;border:1px;padding:5px;border:1px solid black;margin-bottom:15px;">
											     <p><b>Note:- The license is being issued on the following conditions:-</b></p>
														 	<p>1. The owner shall ensure proper space, accommodation, food and medical treatment to the dog.</p>    
											    <p>2. The owner shall keep the dog protected by getting it vaccinated against Rabies from a Govt. Veterinary Practitioner or Veterinary Practitioner duly registered with Indian Veterinary Council( IVC) or State Veterinary Council (SVC).</p>
												<p>3. The owner shall keep the dog chained/ leashed while taking it outside. All ferocious dogs shall be duly muzzled and a stick shall be carried by the escort accompanying the dog while taking it out.</p>
												<p>4. The owner shall ensure that the dog will wear a collar affixed with the metal token issued by the Registration Authority at all the times.</p>
												<p>5. The owner shall not indulge in breeding of dogs for commercial purposes and trading of dogs within the area of Municipal Corporation. In case it is found that dog is being kept for breeding or trading /commercial purposes by him/her, the Registration Authority shall impound  dog/s besides imposing a fine as fixed by the ${pet.ulbBean.officerName} , ${pet.ulbBean.ulbName} upon him/her.</p>
												<p>6. The owner shall not allow the dog to defecate in public places such as residential areas, green belts, parks, streets, roads, road berms and other common places etc. In case the dog defecates at the above specified places, he/she shall arrange to get the excreta of the dog removed from the said place at his/her own level. The owner shall take his/her dog to defecate in the isolated areas which are not visited by the residents and other members of the public. The owner shall not allow the dog to defecate near the residences of other neighbours to their annoyance.</p>
												<p>7. The owner shall allow the Registration Authority or a Veterinary Doctor, Chief Sanitary Inspector, Sanitary Inspector or any other officer of the Municipal Corporation authorized by the Registration Authority to inspect the premises of dog and the owner shall allow that person to enter and inspect his/her premises at all reasonable times to ensure that no cruelty is being done to the animal (prevention of cruelty to Animals Act 1960).</p>
												<p>8. The owner shall abide by the provision of Bye Laws notified by Government of Punjab Notification No. 5/13/2020-1LG4/1877 dated 12/10/2020 and adopted by ${pet.ulbBean.officerName} , ${pet.ulbBean.ulbName} vide its resolution ${pet.ulbBean.resolutionDate} .</p>

												</div>
		
	</div>
	
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
					  	 window.location="/login";
				   }</script>
