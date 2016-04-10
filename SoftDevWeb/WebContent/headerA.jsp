<%@ page import="com.softdev.core.bean.User" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Profile</title>
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
<!--skycons-icons-->
<script src="js/skycons.js"></script>
<!--//skycons-icons-->
<!--circlechart-->
<script src="js/jquery.circlechart.js"></script>
<!--circlechart-->
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
                            <a href="controller?rh=access&cmd=displayLogs"><i class="fa fa-home nav_icon"></i>Logs</a>
                        </li>
                        <li>
                            <a href="controller?rh=access&cmd=displayAnalytic"><i class="fa fa-cogs nav_icon"></i>Analytic Report</a>
                        </li>
                        
                    </ul>
                    <div class="clearfix"> </div>
                    <!-- //sidebar-collapse -->
                </nav>
            </div>
        </div>
        <!--left-fixed -navigation-->
        <!-- header-starts -->
        <div class="sticky-header header-section ">
            <div class="header-left">
                <!--toggle button start-->
                <button id="showLeftPush"><i class="fa fa-bsars"></i></button>
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
            <div class="header-right">
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
                                        %>
                                        </p>
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
                                <li> <a href="controller?rh=access&cmd=doLogout"><i class="fa fa-sign-out"></i> Logout</a> </li>
                            </ul>
                        </li>
                    </ul>
                </div>        
            </div>
            <div class="clearfix"> </div>   
        </div>
        <!-- //header-ends -->