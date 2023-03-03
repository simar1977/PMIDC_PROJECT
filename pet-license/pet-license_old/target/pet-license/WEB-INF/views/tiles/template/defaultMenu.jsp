<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<aside>
	<div id="sidebar" class="nav-collapse">
		<!-- sidebar menu start-->
		<div class="leftside-navigation">
			<ul class="sidebar-menu" id="nav-accordion">
				
				
				<c:set var="val" value="${userType}" />
				<c:choose>
					<c:when test="${val == 1}">
				
						<li><a href="registration-form" style="cursor: pointer;"> <i
								class="fa fa-pencil-square-o"></i> <span>Pet Registration</span>
						</a></li>
							<li><a class="active" href="collect-fee-search"> <i
						class="fa fa-dashboard"></i> <span>Collect Fee</span>
				</a></li>
						<li id="menu-report"><a href="report"><i class="fa fa-table"
					aria-hidden="true"></i><span>Pet Registrations Report</span><div class="clearfix"></div></a>
					
					</li>
					<li id="menu-report"><a href="report-fee"><i class="fa fa-table"
					aria-hidden="true"></i><span>Fee Collection Report</span><div class="clearfix"></div></a>
					</li>
					
					
					
					<li data-toggle="modal" data-target="#modal-success"><a
					href="#"> <i class="fa fa-key"></i> <span>Logout</span>
				</a></li>
				
				
				
						</c:when>
						<c:when test="${val == 0}">
						<li id="menu-report"><a href="report"><i class="fa fa-table"
					aria-hidden="true"></i><span>Report</span><div class="clearfix"></div></a>
					
					</li>
					
					<li data-toggle="modal" data-target="#modal-success"><a
					href="#"> <i class="fa fa-key"></i> <span>Logout</span>
				</a></li>
						</c:when>
						<c:when test="${val == 2}">
						<li id="menu-report"><a href="collect-fee-search"><i class="fa fa-table"
					aria-hidden="true"></i><span>Approve Pet</span><div class="clearfix"></div></a>
					
					</li>
					<li id="menu-report"><a href="report"><i class="fa fa-table"
					aria-hidden="true"></i><span>Report</span><div class="clearfix"></div></a>
					
					</li>
					
					<li data-toggle="modal" data-target="#modal-success"><a
					href="#"> <i class="fa fa-key"></i> <span>Logout</span>
				</a></li>
						</c:when>
						<c:otherwise>
						<li id="menu-report"><a href="citizen-form"><i class="fa fa-pencil-square-o"
					aria-hidden="true"></i><span>Citizen-Form</span><div class="clearfix"></div></a>
					
					</li>
					
					<li id="menu-report"><a href="collect-fee-online-search"><i class="fa fa-pencil-square-o"
					aria-hidden="true"></i><span>Pay Pet Registration Fee</span><div class="clearfix"></div></a>
					
					</li>
						</c:otherwise>
                                    
				</c:choose>


				
			</ul>
		</div>
		<!-- sidebar menu end-->
	</div>
</aside>
