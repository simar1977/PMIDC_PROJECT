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
						  	<th>Receipt Number </th>
						  	<th>Receipt Date </th>
							<th>Name </th>
							<th>Father Name </th>
							<th>Mobile No </th>
							<th>Residential Address</th>
							<th>Mode</th>
							<th>Purpose </th>
							<th>Amount Collected</th>
						
						  </tr>
						</thead>
						<tbody id="vlist-body">
						  
						</tbody>
						<tfoot>
						 <tr>
						 	<th colspan=9 style="align:right">Total</th>
						  	<th> <label id="totalSum"></label></th>
						
						  </tr></tfoot>
					  </table>
					</div>
				  

			

			</div>
			</section></section></section></section>
			
<link rel="stylesheet" type="text/css" href="/pet-license/resources/css/table-style.css" />
<link rel="stylesheet" type="text/css" href="/pet-license/resources/css/dataTable.css" />
<script src="/pet-license/resources/js/data.table.js"></script>
		
	
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
				    	debugger;
				    	$(data).each(function (index, item) {
				    			htm = htm+"<tr>" +
				    			"<td>"+(index+1)+"</td>" +
				    			"<td>"+item.receiptNumber+"</td>" +
				    			"<td>"+item.receiptDate+"</td>" +
				    			"<td>"+item.headBean.headName+"</td>" +
				    			"<td>"+item.headBean.fatherName+"</td>" +
				    			"<td>"+item.headBean.mobileNo+"</td>" +
								"<td>"+item.headBean.resAddress+"</td>" +
								"<td>"+item.mode+"</td>" +
								"<td>"+item.purpose+"</td>" +
								"<td>"+item.amount+"</td>";
								debugger;
								total=(+total)+ item.amount;
										       
							
				    	});
				$('#vlist-body').html(htm);
				$('#vendorlist').DataTable();
				$('#totalSum').text('Rs.'+total);
				    }, 
				    error: function(xhr, textStatus, errorThrown) {  
				    }  
				});
				
				
		}
		});	

</script>



			