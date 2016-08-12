<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet href=" <spring:url value="resources/css/bootstrap.min.css" />" />


<link rel="stylesheet"
	href="<spring:url value="resources/css/bootstrap.min.css" />" />
<link rel="stylesheet"
	href="<spring:url value="resources/css/style.css" />" />
<script src="<u:url value="resources/js/jquery-1.12.3.min.js" />"></script>
<script src="<u:url value="resources/js/bootstrap.min.js" />"></script>

<script src="<u:url value="resources/js/controller.js" />"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
<script>
	var myApp = angular.module('myApp', []);
	myApp.controller('getData', function($scope, $http, $location) {
		$scope.searchKeyword = location.search.substr(15);
		$scope.productdata = $
		{
			blog
		}
		;

		//alert($scope.productdata);

	});
</script>
</head>
<body ng-app="myApp" ng-controller="getData">
	<div class="container">
		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>

				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">

						<li><a href="home">Home</a></li>
						<li><a href="aboutus">About Us</a></li>
						<li><a href="addproduct">Products</a></li>
						<li><a href="allproducts">All Products</a></li>


					</ul>

					<ul class="nav navbar-nav navbar-right">

						<li><a href="login.html">Login</a></li>
						<li><a href="signup.html">Sign Up</a></li>
						<li><a href="feedback.html">Feedback</a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</div>

	<div class="container">

		<div class="panel-heading">
			<div class="panel-title text-center">
				<h1 class="title">Product Details</h1>
				<hr />
			</div>
		</div>
		<div class="container">
			<div class="row">
				<!-- products grid -->
				<div class="col-lg-6"></div>
				<div class="col-lg-6">
					<p>
						<span class="h3 text-uppercase">{{productdata.blogName}}</span>
					</p>
					<p>
						<span class="h3">Description
							{{productdata.blogDescription}}</span>
					</p>
				</div>
			</div>
		</div>


	</div>

</body>
</html>