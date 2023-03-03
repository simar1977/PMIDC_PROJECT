<section id="site-content">
<section id="main-content">
			<section class="wrapper">
			<section class="panel" style="background-color: #fff">
<div class="form-group col-sm-8">
<label for="focusedinput"><b>From Date</b></label>

<input id="fromDate" type="date" required/>

<label for="focusedinput"><b>To Date</b></label>
<input id="toDate" type="date" required/>
<button  type="button" id="searchMonFee">Search</button>
</div>
<div class="agile-tables">
					<div class="w3l-table-info">
					    <table id="feelist" style="display:none;table-layout: fixed;word-wrap:break-word;">
						<thead>
						  <tr>
						 	<th>Sr No. </th>
						 	<th> Pet Id</th>
						  	<th>Receipt Number </th>
						  	<th>Receipt Date </th>
							<th>Name </th>
							<th>Father/Spouse Name </th>
							<th>Mobile No </th>
							<th>Residential Address</th>
							<th>Pet Name</th>
							<th>Mode</th>
							<th>Purpose </th>
							<th>Amount Collected</th>
							<th>Action</th>
						
						  </tr>
						</thead>
						<tbody id="vlist-body">
						  
						</tbody>
						<tfoot>
						 <tr>
						 	<th colspan=10 style="align:right">Total</th>
						  	<th> <label id="totalSum"></label></th>
						
						  </tr></tfoot>
					  </table>
					</div>
				 
			

			</div>
			<input style="display:none;float:right;" type=button id="exportButton" value="Export Data to Excel" ></div>
			</section></section></section></section>
			
<link rel="stylesheet" type="text/css" href="/pet-license/resources/css/table-style.css" />
<link rel="stylesheet" type="text/css" href="/pet-license/resources/css/dataTable.css" />
<script src="/pet-license/resources/js/data.table.js"></script>
	<script src="/pet-license/resources/js/table2excel.js"></script>	
	
<script>
$(document).on('click', '#searchMonFee', function() {
	
	var total=0;
	
	var fromDate = $('#fromDate').val();
	var toDate = $('#toDate').val();
		
	if((fromDate.length==0)||(toDate.length==0))
	{
		alert("Please select from and to date");
	}
	else
	
	{
		$('#feelist').show();
		
			$.ajax({  
				    url: 'search_fee',  
				    type: 'GET',
				    data:{"fromDate":fromDate,"toDate":toDate},
				    headers: {"auth_token":localStorage.getItem('authToken')},
				    dataType: 'json',
				    success: function(data, textStatus, xhr) { 
				    	var htm = "";
				    	$(data).each(function (index, item) {
				    			htm = htm+"<tr>" +
				    			"<td style=\"font-size:14px\">"+(index+1)+"</td>" +
				    			"<td style=\"font-size:14px\">"+item.headBean.petId+"</td>" +
				    			"<td style=\"font-size:14px\">"+item.receiptNumber+"</td>" +
				    			"<td style=\"font-size:14px\">"+item.receiptDate+"</td>" +
				    			"<td style=\"font-size:14px\">"+item.headBean.headName+"</td>" +
				    			"<td style=\"font-size:14px\">"+item.headBean.fatherName+"</td>" +
				    			"<td style=\"font-size:14px\">"+item.headBean.mobileNo+"</td>" +
								"<td style=\"font-size:14px\">"+item.headBean.resAddress+"</td>" +
								"<td style=\"font-size:14px\">"+item.headBean.nameofdog+"</td>" +
								"<td style=\"font-size:14px\">"+item.mode+"</td>" +
								"<td style=\"font-size:14px\">"+item.purpose+"</td>" +
								"<td style=\"font-size:14px\">"+item.amount+"</td>" +
								"<td style=\"font-size:14px\"><button  onClick=\"getaction("+item.headBean.petId+")\" style=\"color:teal; background-color: #FFFFC0; border: 3pt ridge lightgrey\">Download Receipt</button></td>";
								total=(+total)+ item.amount;
										       
							
				    	});
				$('#vlist-body').html(htm);
				$('#vendorlist').DataTable();
				$('#totalSum').text('Rs.'+total);
				$('#exportButton').show();
				    }, 
				    error: function(xhr, textStatus, errorThrown) {  
				    }  
				});
				
				
		}
		});
		
$(function () {    
    $("#exportButton").click(function () {    
    	    $("#feelist").table2excel({    
            filename: "feelist_data.xls"    
        });    
    });    
}); 

function getaction(id)
{
	window.location="/pet-license/download-receipt?petId="+id;
	}

</script>