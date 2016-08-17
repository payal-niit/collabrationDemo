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
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/angular-sanitize.js"></script>
<script>
	var myApp = angular.module('myApp', ['ngSanitize']);
	myApp.controller('getData', function($scope, $http, $location) {
		$scope.searchKeyword = location.search.substr(15);
		$scope.productdata = ${blogapp};
		$scope.product = ${blogCommentList};
		
		
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
					<p>{{productdata.blogAppId}}</p>
						<p>
							<span class="h3" ng-bind-html="productdata.blogDescription"></span></p>
					</div>
					</div>
				</div>
			</div>
		</div>
		<p align="right">Created by: {{productdata.username}}</p>
<hr>
<h3>Add Comments</h3>
 <form:form action="viewappblogs/addcomment?blogAppId=${blogapp.blogAppId}" modelAttribute="blogComment" commandName="blogComment">
 <input type="hidden" value="${blogapp.blogAppId}"/>
<form:textarea class="form-control" rows="5" cols="5" path="comment"></form:textarea>
<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
</form:form>
	</div>
<hr>
<div class="container">

<h2>Comments</h2>
<div style="width:500px;" ng-repeat="group in product">
<div>
<b>{{group.username}}</b>
</div>

{{group.comment}}
<hr>
</div>

</div>

</body>
</html>