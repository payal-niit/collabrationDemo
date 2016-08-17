<!DOCTYPE HTML>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html lang="en">

  <head>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700" rel="stylesheet" type="text/css" />
    <link href="resources/css/demo.css" rel="stylesheet" type="text/css" />
        <link href="resources/css/common.css" rel="stylesheet">
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/sidebar.css" rel="stylesheet">
    <link href="resources/font-awesome-4.6.3/css/font-awesome.min.css" rel="stylesheet">
  </head>
  <body background="resources/images/background.jpg" ng-app="chatApp">
   <nav class="navbar navbar-inverse no-margin">
    <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header fixed-brand">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"  id="menu-toggle">
                      <span class="glyphicon glyphicon-th-large" aria-hidden="true"></span>
                    </button>
                    <a class="navbar-brand" href="index"><i class="fa fa-rocket fa-4"></i> ANYWHERE CONNECT</a>
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
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="fa fa-weixin fa-stack-1x "></i></span>Chat</a>
               
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
                    <h2>Start a Group Chat Here</h2>
                    <div ng-controller="ChatCtrl" class="container">
      <form ng-submit="addMessage()" name="messageForm">
        <input type="text" placeholder="Compose a new message..." ng-model="message" />
        <div class="info">
          <span class="count" ng-bind="max - message.length" ng-class="{danger: message.length > max}">140</span>
          <button ng-disabled="message.length > max || message.length === 0">Send</button>
        </div>
      </form>
      <hr />
      <p ng-repeat="message in messages | orderBy:'time':true" class="message">
      	<span>{{message.username}}</span>
        <time>{{message.time | date:'HH:mm'}}</time>
        <span ng-class="{self: message.self}">{{message.message}}</span>
        
      </p>
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
    
    
    <script src="resources/sockjs/sockjs.min.js" type="text/javascript"></script>
    <script src="resources/stomp-websocket/lib/stomp.min.js" type="text/javascript"></script>
    <script src="resources/angular/angular.min.js"></script>
    <script src="resources/lodash/dist/lodash.min.js"></script>
    <script src="resources/js/app.js" type="text/javascript"></script>
    <script src="resources/js/controllers.js" type="text/javascript"></script>
    <script src="resources/js/services.js" type="text/javascript"></script>
  </body>
</html>