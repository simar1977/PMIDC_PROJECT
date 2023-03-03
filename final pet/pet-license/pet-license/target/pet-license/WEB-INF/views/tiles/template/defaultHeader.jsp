<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="l"%>
<header class="header fixed-top clearfix">
<!--logo start-->
<div class="brand">
    <a href="dashboard" class="logo" style="font-size:21px">
Pet-Registration
    </a>
    <div class="sidebar-toggle-box">
        <div class="fa fa-bars"></div>
    </div>
</div>

<div class="top-nav clearfix">
    <!--search & user info start-->
    <ul class="nav pull-right top-menu">
        
        <!-- user login dropdown start-->
        
               <l:set var="val" value="${userType}" />
				<l:choose>
					<l:when test="${val != null}">
					<li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                <img alt="avtar" src="${pageContext.request.contextPath}/resources/images/user-icon.png">
                <span class="username"><%= session.getAttribute("userName") %></span>
                 <b class="caret"></b>
            </a>
            <ul class="dropdown-menu extended logout">
                <li><a href="editProfile"><i class=" fa fa-suitcase"></i>Edit Profile</a></li>
                <li  data-toggle="modal" data-target="#modal-success"><a href="#"><i class="fa fa-key"></i> Log Out</a></li>
              
            </ul>
            </li>
                </l:when>
						<l:otherwise>
						<li class="dropdown">
            <a href="http://localhost:8080/pet-license/login">
                <img alt="avtar" src="${pageContext.request.contextPath}/resources/images/user-icon.png">
						<span class="username">CITIZEN</span>
						</a>
						</li>
						
						</l:otherwise>
						</l:choose>
						
                                    
			
               
        
        <!-- user login dropdown end -->
       
    </ul>
    <!--search & user info end-->
</div>
</header>
