<%@ taglib prefix="l" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="main-content">
	<section class="wrapper">

		<div id="dsboard">
			<!-- //market-->
			<div class="market-updates">
				<l:choose>
					<l:when test="${userType == '0'}">
						<div class="col-md-4 market-update-gd">
							<div class="market-update-block clr-block-2">
								<div class="col-md-4 market-update-right">
									<i class="fa fa-clipboard" aria-hidden="true"></i>
								</div>
								<div class="col-md-8 market-update-left">
									<h4>
										Registration data
									</h4>
									<h3>${totalHeadRecords}</h3>

								</div>
								<div class="clearfix"></div>
							</div>
						</div>
						
					</l:when>
					
					<l:otherwise>

		<h1 style="text-align:center;color:black">Welcome to Pet Registration Portal</h1>
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
					</l:otherwise>
				</l:choose>
				<div class="clearfix"></div>
			</div>
		</div>
	</section>
</section>


