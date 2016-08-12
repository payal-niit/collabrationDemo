<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/header.jsp"%>
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
<script src="<u:url value="resources/js/angular.min.js" />"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.5/angular.min.js"></script>
<script>
	var myApp = angular.module('myApp', []);
	myApp.controller('getData', function($scope, $http, $location) {
		$scope.searchKeyword = location.search.substr(15);
		$scope.productdata = ${blog};

		//alert($scope.productdata);

	});
</script>
</head>
<body ng-app="myApp" ng-controller="getData">
	<div class="container">

		<div class="panel-heading">
			<div class="panel-title text-center">
				<h1 class="title">{{productdata.blogName}}</h1>
				<hr />
			</div>
		</div>
		<div class="container">
			<div class="row">
				<!-- products grid -->
				<div class="col-lg-3"></div>
				<div class="col-lg-9">
					<p>
						<span class="h3 text-uppercase">Category:
							{{productdata.blogCategory}}</span>
					</p>
					<div class="panel panel-danger">
					<div class="panel-body">
						<p>
							<span class="h3"> {{productdata.blogDescription}}</span></p>
					</div>
					</div>
				</div>
			</div>
		</div>
		<p align="right">Created by: {{productdata.username}}</p>


	</div>

</body>
</html>