<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

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
    <script src="resources/js/angular.min.js"></script>
       <style>
       body{}
* {
	margin: 0; 
	padding: 0;
}


/*Time to apply widths for accordian to work
Width of image = 640px
total images = 5
so width of hovered image = 640px
width of un-hovered image = 40px - you can set this to anything
so total container width = 640 + 40*4 = 800px;
default width = 800/5 = 160px;
*/

.accordian {
	/*width: 913px; 
    height: 320px;*/
    width:100%;
    height:100%;
	overflow: hidden;
	/*Time for some styling*/
	/*margin: 100px auto 100px 0px;*/
	box-shadow: 0 0 10px 1px rgba(0, 0, 0, 0.35);
	-webkit-box-shadow: 0 0 10px 1px rgba(0, 0, 0, 0.35);
	-moz-box-shadow: 0 0 10px 1px rgba(0, 0, 0, 0.35);
}

/*A small hack to prevent flickering on some browsers*/
.accordian ul {
	width: 2000px;
	/*This will give ample space to the last item to move
	instead of falling down/flickering during hovers.*/
}

.accordian li {
	position: relative;
	display: block;
	width: 160px;
	float: left;
	
	border-left: 1px solid #888;
	
	box-shadow: 0 0 25px 10px rgba(0, 0, 0, 0.5);
	-webkit-box-shadow: 0 0 25px 10px rgba(0, 0, 0, 0.5);
	-moz-box-shadow: 0 0 25px 10px rgba(0, 0, 0, 0.5);
	
	/*Transitions to give animation effect*/
	transition: all 0.5s;
	-webkit-transition: all 0.5s;
	-moz-transition: all 0.5s;
	/*If you hover on the images now you should be able to 
	see the basic accordian*/
}

/*Reduce with of un-hovered elements*/
.accordian ul:hover li {width: 40px;}
/*Lets apply hover effects now*/
/*The LI hover style should override the UL hover style*/
.accordian ul li:hover {width: 850px;}


.accordian li img {
	display: block;
    width:900px;
    height:450px;

}

/*Image title styles*/
.image_title {
	background: rgba(0, 0, 0, 0.5);
	position: absolute;
	left: 0; bottom: 0;	
    width: 640px;	

}
.image_title a {
	display: block;
	color: #fff;
	text-decoration: none;
	padding: 20px;
	font-size: 16px;
}
       </style>
</head>
<body background="resources/images/background.jpg" ng-app="myApp" ng-controller="getData">
    <nav class="navbar navbar-inverse no-margin">
    <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header fixed-brand">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"  id="menu-toggle">
                      <span class="glyphicon glyphicon-th-large" aria-hidden="true"></span>
                    </button>
                    <a class="navbar-brand" href="indexOfUser"><i class="fa fa-rocket fa-4"></i> ANYWHERE CONNECT</a>
                </div><!-- navbar-header-->
 
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li class="active" ><button class="navbar-toggle collapse in" data-toggle="collapse" id="menu-toggle-2" style="background-color: grey;
    border: 1px;;"> <span class="glyphicon glyphicon-th-large" aria-hidden="true"></span></button></li>
                            </ul>
                           <ul class="nav navbar-right" style="margin:auto;margin-top:12px;"><li style="text-transform: capitalize;color:white;">
                <c:if test="${pageContext.request.userPrincipal.name != null}">
					Welcome: <b>${pageContext.request.userPrincipal.name}</b>&nbsp&nbsp&nbsp
					<%-- <img style="width:50px;height:45px" src="resources/images/${userId}.jpg"> --%>
                </c:if>
                
                </li>
                </ul>
                </div><!-- bs-example-navbar-collapse-1 -->
                
                
    </nav>
    <div id="wrapper">
        <!-- Sidebar -->
        <div id="sidebar-wrapper" aria-hidden="true">
            <ul class="sidebar-nav nav-pills nav-stacked" id="menu" aria-hidden="true">
 <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li class="active">
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-dashboard fa-stack-1x "></i></span> Connect</a>
                       <ul class="nav-pills nav-stacked" style="list-style-type:none;">
                        <li><a href="loginpage">Sign In</a></li>
                        <li><a href="register">Sign Up</a></li>
                    </ul>
                </li>
                </c:if>
                
					<sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
                
                <li class="active">
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-dashboard fa-stack-1x "></i></span> Connect</a>
                       <ul class="nav-pills nav-stacked" style="list-style-type:none;">
                        <li><a href="perform_logout">Logout</a></li>
                        
                    </ul>
                </li>
                </sec:authorize>
                <li>
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-flag fa-stack-1x "></i></span>Blogs</a>
                    <ul class="nav-pills nav-stacked" style="list-style-type:none;">
                        <li><a href="approvedblogs"><span class="fa-stack fa-lg pull-left"><i class="fa fa-flag fa-stack-1x "></i></span>Read</a></li>
                        <li><a href="blogpage"><span class="fa-stack fa-lg pull-left"><i class="fa fa-flag fa-stack-1x "></i></span>Add</a></li>
 
                    </ul>
                </li>
                <li>
                    <a href="chatpage"><span class="fa-stack fa-lg pull-left"><i class="fa fa-weixin fa-stack-1x "></i></span>Chat</a>
               
                </li>
                <li>
                    <a href="#"> <span class="fa-stack fa-lg pull-left"><i class="fa fa-forumbee fa-stack-1x "></i></span>Forums</a>
                  <ul class="nav-pills nav-stacked" style="list-style-type:none;">
                        <li><a href="allforums"><span class="fa-stack fa-lg pull-left"><i class="fa fa-forumbee fa-stack-1x "></i></span>Join forums</a></li>
                        <li><a href="forumpage"><span class="fa-stack fa-lg pull-left"><i class="fa fa-forumbee fa-stack-1x"></i></span>Add a New Forum</a></li>
 
                    </ul>
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
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                
                <li>                
                    <a href="#"> <span class="fa-stack fa-lg pull-left"><i class="fa fa-user fa-stack-1x "></i></span>Admin</a>
                  <ul class="nav-pills nav-stacked" style="list-style-type:none;">
                        <li><a href="allblog"><span class="fa-stack fa-lg pull-left"><i class="fa fa-flag fa-stack-1x "></i></span>Blogs for Approval</a></li>
                        <li><a href="userlist"><span class="fa-stack fa-lg pull-left"><i class="fa fa-users fa-stack-1x"></i></span>User list</a></li>
 
                    </ul>
                </li>
                </sec:authorize>
            </ul>
        </div><!-- /#sidebar-wrapper -->
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid xyz">
                <div class="row">
                    <div class="col-lg-12">
                    <div class="accordian">
                <ul style="background-color: #808080">
                    <li>
                        <div class="image_title">
                            <a href="approvedblogs">Read the Blogs Available with Us</a>
                        </div>
                        <a href="#">
                            <img src="resources/images/index01.jpg" />
                        </a>
                    </li>
                    <li>
                        <div class="image_title">
                            <a href="allforums">Join the forums</a>
                        </div>
                        <a href="#">
                            <img src="resources/images/index03.jpg" />
                        </a>
                    </li>
                    <li>
                        <div class="image_title">
                            <a href="addblog">Write a Blog with Us</a>
                        </div>
                        <a href="#">
                            <img src="resources/images/index04.jpg" />
                        </a>
                    </li>
                    <li>
                        <div class="image_title">
                            <a href="#">Dreams Dont Work Unless You Do..</a>
                        </div>
                        <a href="#">
                            <img src="resources/images/index05.jpg" />
                        </a>
                    </li>
                    <li>
                        <div class="image_title">
                            <a href="loginpage">Anywhere Connect - Login Here</a>
                        </div>
                        <a href="#">
                            <img src="resources/images/index07.jpg" />
                        </a>
                    </li>
                </ul>
            </div>
                        
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