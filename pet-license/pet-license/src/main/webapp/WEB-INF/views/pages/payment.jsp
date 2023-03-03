
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
				<header class="panel-heading"><p style="color:green"> Pet Registration fee has failed for Pet/Order Id ${pet.petId}.</p></header>
				<div class="panel-body" style="backgroundColor:white">
					<div class="position-center">

<div id="main">
<label  class="col-sm-4 control-label">Failure message :</label></td>
<span>${feeBean.orderStatus} </span>				
<div align="center">					
					<button class="btn-default btn" type="button" onclick="goback()">Try again</button>
<br><div></div>
				</div></div></div>	</section></section></section></section>
				
				<script>
				
				$(document).ready(function(){
					
					var petid=${pet.petId};
					debugger;
					$('#frontPic').attr('src',"/getAttachedDocuments/FRONT?pet_id="+petid);
				});
				 function goback()
				   {
					  	 window.location="/pet-license/collect-fee-online?petId="+${pet.petId};
				   }</script>
