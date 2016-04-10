<%@ page import="com.softdev.core.bean.User" %>
<%@ page import="com.softdev.core.bean.FarmStatus" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%FarmStatus status = (FarmStatus) request.getAttribute("latestStatus");%>

<!DOCTYPE HTML>
<html>
<head>
<title>SPRNKLR Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- font CSS -->
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
 <!-- js-->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/modernizr.custom.js"></script>
<!--webfonts-->
<link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
<!--//webfonts--> 
<!--animate-->
<link href="css/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="js/wow.min.js"></script>
    <script>
         new WOW().init();
    </script>
<!--//end-animate-->
<!-- chart -->
<script src="js/Chart.js"></script>
<!-- //chart -->
<!--Calender-->
<link rel="stylesheet" href="css/clndr.css" type="text/css" />
<script src="js/underscore-min.js" type="text/javascript"></script>
<script src= "js/moment-2.2.1.js" type="text/javascript"></script>
<script src="js/clndr.js" type="text/javascript"></script>
<script src="js/site.js" type="text/javascript"></script>
<!--End Calender-->
<!-- Metis Menu -->
<script src="js/metisMenu.min.js"></script>
<script src="js/custom.js"></script>
<link href="css/custom.css" rel="stylesheet">
<!--//Metis Menu -->
</head> 
<body class="cbp-spmenu-push">
    <div class="main-content">
        <!--left-fixed -navigation-->
        <div class=" sidebar" role="navigation">
            <div class="navbar-collapse">
                <nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="controller?rh=access&cmd=displayMain"><i class="fa fa-home nav_icon"></i>Dashboard</a>
                        </li>
                        <li>
                            <a href="controller?rh=access&cmd=displayControl"><i class="fa fa-cogs nav_icon"></i>Control Sprinkler</a>
                        </li>
                        <li>
                            <a href="controller?rh=access&cmd=displayInfo"><i class="fa fa-pagelines nav_icon"></i>Irrigation Info</a>
                        </li>
                         <li>
                            <a href="controller?rh=access&cmd=displayHelp"><i class="fa fa-info-circle nav_icon"></i>Help</a>
                        </li>
                       
                        <li>
                            <a href="controller?rh=access&cmd=displayAbout"><i class="fa fa-th-large nav_icon"></i>About</a>
                        </li>
                    </ul>
                    <!-- //sidebar-collapse -->
                </nav>
            </div>
        </div>
        <!--left-fixed -navigation-->
        <!-- header-starts -->
        <div class="sticky-header header-section ">
            <div class="header-left">
                <!--toggle button start-->
                <button id="showLeftPush"><i class="fa fa-bars"></i></button>
                <!--toggle button end-->
                <!--logo -->
                <div class="logo">
                    <a href="index.html">
                        <h1>SPRNKLR</h1>
                        <span>Water Plan</span>
                    </a>
                </div>
                <!--//logo-->
               
                <div class="clearfix"> </div>
            </div>

                <div class="profile_details">       
                    <ul>
                        <li class="dropdown profile_details_drop">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                <div class="profile_img">   
                                    <span class="prfil-img"><img src="images/a.png" alt=""> </span> 
                                    <div class="user-name">
                                        <p>
                                        <% 
			                             User user = (User) session.getAttribute("user");
			                             out.println(user.getFname().toUpperCase());
			                             out.println(user.getLname().toUpperCase());
			                            %></p>
                                        <span>
                                        <%
                                        if (user.getType().equals("U")){
                                            out.println("User");
                                        }else{
                                            out.println("Admin");
                                        }
                                        %>
                                        </span>
                                    </div>
                                    <i class="fa fa-angle-down lnr"></i>
                                    <i class="fa fa-angle-up lnr"></i>
                                    <div class="clearfix"></div>    
                                </div>  
                            </a>
                            <ul class="dropdown-menu drp-mnu">
                                <li> <a href="controller?rh=access&cmd=getProfile"><i class="fa fa-user"></i> Profile</a> </li> 
                                <li> <a href="controller?rh=access&cmd=doLogout"><i class="fa fa-sign-out"></i> Logout</a> </li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div class="clearfix"> </div>               
            <div class="clearfix"> </div>   
        </div>
        <!-- //header-ends -->
        <!-- main content start-->
        <div id="page-wrapper">
            <div class="main-page">
                <div class="row-one">
                    <div class="col-md-4 widget">
                        <div class="stats-left ">
                            <h5>As of: <%
                            SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
                            String strDate = sdfDate.format(status.getCreateDate());
                            out.println(strDate);
                           %></h5>
                            <h4>Soil Moisture</h4>
                        </div>
                        <div class="stats-right">
                            <label><%=status.getSmlvl()%></label>
                        </div>
                        <div class="clearfix"> </div>   
                    </div>
                    <div class="col-md-4 widget states-mdl">
                        <div class="stats-left">
                            <h5>As of: <%= strDate%></h5>
                            <h4>Water Level</h4>
                        </div>
                        <div class="stats-right">
                            <label><%= status.getWlvl()%></label>
                        </div>
                        <div class="clearfix"> </div>   
                    </div>
                    <div class="col-md-4 widget states-last">
                        <div class="stats-left">
                            <h5>As of: <%= strDate%></h5>
                            <h4>Temperature</h4>
                        </div>
                        <div class="stats-right">
                            <label><%= status.getTemp()%></label>
                        </div>
                        <div class="clearfix"> </div>   
                    </div>
                    <div class="clearfix"> </div>   
                </div>
		<!-- main content start-->
		<div id="page-wrapper" style="padding-top: 0px;">
			<div class="main-page charts-page">
				<h2 class="title1">LEGEND:</h2>
				<h3 class="title1" style="color: #4F52BA">Soil Moisture Level</h3>
				<h3 class="title1" style="color: #F2B33F">Water Level</h3>
				<h3 class="title1" style="color: ##e94e02">Temperature</h3>
				<div class="charts">
					<div class="col-md-6 chrt-page-grids">
						<h4 class="title">Line Chart</h4>
						<canvas id="line" height="500" width="100%" style="width: 100%; height: 300px;"></canvas>
					</div>
					
					<div class="clearfix"> </div>
						<script>
						var lineChartData = {
							labels : ["Sun","Mon","Tue","Wed","Thr","Fri","Sat"],
							datasets : [
								{
									fillColor : "rgba(51, 51, 51, 0)",
									strokeColor : "#4F52BA",
									pointColor : "#4F52BA",
									pointStrokeColor : "#fff",
									data : [50,65,68,71,67,70,65]
								},
								{
									fillColor : "rgba(51, 51, 51, 0)",
									strokeColor : "#F2B33F",
									pointColor : "#F2B33F",
									pointStrokeColor : "#fff",
									data : [55,60,54,58,62,55,58]
								},
								{
									fillColor : "rgba(51, 51, 51, 0)",
									strokeColor : "#e94e02",
									pointColor : "#e94e02",
									pointStrokeColor : "#fff",
									data : [50,55,52,45,46,49,52]
								}
							]
							
						};

						new Chart(document.getElementById("line").getContext("2d")).Line(lineChartData);
					</script>	
				</div>
			</div>
		</div>
		<!--footer-->
		<div class="footer">
		   <p><center> &copy; 2016 SPRNKLR: Water Plan System. All Rights Reserved | Pasay x Laguna </center></p>
		</div>
        <!--//footer-->
	</div>
	<!-- Classie -->
		<script src="js/classie.js"></script>
		<script>
			var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
				showLeftPush = document.getElementById( 'showLeftPush' ),
				body = document.body;
				
			showLeftPush.onclick = function() {
				classie.toggle( this, 'active' );
				classie.toggle( body, 'cbp-spmenu-push-toright' );
				classie.toggle( menuLeft, 'cbp-spmenu-open' );
				disableOther( 'showLeftPush' );
			};
			
			function disableOther( button ) {
				if( button !== 'showLeftPush' ) {
					classie.toggle( showLeftPush, 'disabled' );
				}
			}
		</script>
	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
	<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.js"> </script>
</body>
</html>