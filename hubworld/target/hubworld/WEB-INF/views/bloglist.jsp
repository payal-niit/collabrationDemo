<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/WEB-INF/views/header.jsp"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="<spring:url value="resources/css/bootstrap-theme.css"/>" />
<link rel="stylesheet"
	href="<spring:url value="resources/css/bootstrap-theme.css.map" />" />
<link rel="stylesheet"
	href="<spring:url value="resources/css/bootstrap-theme.min.css" />" />
<link rel="stylesheet"
	href="<spring:url value="resources/css/bootstrap-theme.min.css.map" />
<link rel="stylesheet" href="<spring:url value="resources/css/bootstrap.css" />" />
<link rel="stylesheet" href="<spring:url value="resources/css/bootstrap.css.map" />" />
<link rel="stylesheet href="<spring:url value="resources/css/bootstrap.min.css" />" />
<link rel="stylesheet"
	href="<spring:url value="resources/css/bootstrap.min.css.map" />" />

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
		var myApp = angular.module('myApp',[]);
		myApp.controller('getData', function($scope,$http,$location)
		 { 
			$scope.searchKeyword=location.search.substr(8);
			$scope.productdata = ${blogList};
			//alert($scope.productdata);
		 
		 });
	
</script>
<style>
a:hover {
	color: #546545;
	background-color: hotpink;
}
</style>
</head>

<body ng-app="myApp" ng-controller="getData">


	<div class="container">
		<div class="row">
			<!-- search box row -->
			<div class="container">
				<form role="form" method="post">
					<div class="row">
						<div class="col-xs-10 col-sm-6 col-md-6 col-lg-3 pull-right">
							<div class="form-group ">
								<label for="search" class="cols-sm-12 control-label">Search
									Products</label>
								<div class="input-group ">
									<span class="input-group-addon cols-sm-12"><i
										class="fa fa-user fa" aria-hidden="true"></i></span> <input
										type="text" ng-model="searchKeyword"
										class="form-control cols-sm-12 cols-lg-9" name="searchKeyword"
										id="searchKeyword" />
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="panel-heading">
			<div class="panel-title text-center">
				<h1 class="title">Product List</h1>
				<hr />
			</div>
		</div>
		<div class="row text-center">
			<!-- products grid -->

			<div class="container col-lg-12" align="center">
				<table
					class="table-responsive table table-bordered table-condensed table table-hover">
					<tr>
						<!-- 		<th>Group Name</th> -->
						<th>USer Name</th>
						<!-- 	<th>Product Price (Rs.)</th> -->
						<th>Blog Name</th>
						<th>Blog Category</th>
						<th>Blog description</th>
						<th>View Details</th>
						<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
							<th>Edit</th>
							<th>Delete</th>
						</c:if>
					</tr>
					<tr ng-repeat="group in productdata | filter:searchKeyword	">

						<!-- 	<td>{{group.groupName}}-->
						<td>{{group.username}}</td>
						<!--   	<td>{{group.price}}</td>-->
						<td>{{group.blogName}}</td>
						<td>{{group.blogCategory}}</td>
						<td>{{group.blogDescription}}</td>

						<td><a href="viewblogdetail--{blogId}--blog"><mark>View
									Details</mark></a></td>
						<%-- <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
							<td><a href="editproduct--{{group.productID}}--product"><mark>Edit</mark></a>
							</td>
							<td><a href="deleteproduct--{{group.productID}}--product"><mark>Delete</mark></a></td>
						</c:if> --%>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<hr />
</body>
</html>