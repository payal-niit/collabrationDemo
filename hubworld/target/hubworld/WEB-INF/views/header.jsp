<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Anytime Connect</title>
    <link href="resources/css/common.css" rel="stylesheet">
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/sidebar.css" rel="stylesheet">
    <link href="resources/font-awesome-4.6.3/css/font-awesome.min.css" rel="stylesheet">
</head>
<body background="resources/images/background.jpg">
    <nav class="navbar navbar-inverse no-margin">
    <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header fixed-brand">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"  id="menu-toggle">
                      <span class="glyphicon glyphicon-th-large" aria-hidden="true"></span>
                    </button>
                    <a class="navbar-brand" href="#"><i class="fa fa-rocket fa-4"></i> ANYTIME CONNECT</a>
                </div><!-- navbar-header-->
 
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li class="active" ><button class="navbar-toggle collapse in" data-toggle="collapse" id="menu-toggle-2"> <span class="glyphicon glyphicon-th-large" aria-hidden="true"></span></button></li>
                            </ul>
                </div><!-- bs-example-navbar-collapse-1 -->
                <%-- <nav class="navbar navbar-right ">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
					Welcome: ${pageContext.request.userPrincipal.name}
                </c:if>
                </nav> --%>
                
    </nav>
    <div id="wrapper">
        <!-- Sidebar -->
        <div id="sidebar-wrapper" aria-hidden="true">
            <ul class="sidebar-nav nav-pills nav-stacked" id="menu" aria-hidden="true">
 
                <li class="active">
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-dashboard fa-stack-1x "></i></span> Connect</a>
                       <ul class="nav-pills nav-stacked" style="list-style-type:none;">
                        <li><a href="loginpage">Sign In</a></li>
                        <li><a href="register">Sign Up</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-flag fa-stack-1x "></i></span>Blogs</a>
                    <ul class="nav-pills nav-stacked" style="list-style-type:none;">
                        <li><a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-flag fa-stack-1x "></i></span>Read</a></li>
                        <li><a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-flag fa-stack-1x "></i></span>Add</a></li>
 
                    </ul>
                </li>
                <li>
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-cloud-download fa-stack-1x "></i></span>Chat</a>
                </li>
                <li>
                    <a href="#"> <span class="fa-stack fa-lg pull-left"><i class="fa fa-cart-plus fa-stack-1x "></i></span>Forums</a>
                </li>
                <li>
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-youtube-play fa-stack-1x "></i></span>Know About Us</a>
                </li>
                <li>
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-wrench fa-stack-1x "></i></span>Testimonials</a>
                </li>
                <li>
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-server fa-stack-1x "></i></span>Contact Us</a>
                </li>
            </ul>
        </div><!-- /#sidebar-wrapper -->
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid xyz">
                <div class="row">
                    <div class="col-lg-12">
                       <h3 align="right" class="">Welcome: ${pageContext.request.userPrincipal.name}</h3>
                        
                    </div>
                </div>
            </div>
        </div>
       
    </div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="resources/js/jquery-1.12.3.min.js"></script>
    <script src="resources/js/jquery-ui.min.js"></script>
    
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/sidebar_menu.js"></script>
</body>
</html>