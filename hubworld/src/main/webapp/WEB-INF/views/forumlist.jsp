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
<script src="resources/js/angular.min.js"></script>

<script>
		var myApp = angular.module('myApp',[]);
		myApp.controller('getData', function($scope,$http,$location)
		 { 
			$scope.searchKeyword=location.search.substr(8);
			$scope.productdata = ${forumList};
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
									Blogs</label>
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
				<h1 class="title">All the Available Forums</h1>
				<hr />
			</div>
		</div>
		<div class="row text-center">
			<!-- products grid -->

			<div class="container col-lg-12" align="center">
				<table
					class="table-responsive table table-bordered table-condensed table table-hover">
					<tr>
						<th>Forum ID</th>
						<th>Admin</th>
						<!-- 	<th>Product Price (Rs.)</th> -->
						<th>Forum Name</th>
						<th>Forum Category</th>
						<th>Image</th>
						<th>View Details</th>
						
							<th>Edit</th>
							<th>Delete</th>
						
					</tr>
					<tr ng-repeat="group in productdata | filter:searchKeyword	">

						<td>{{group.forumId}}</td>
						<td>{{group.username}}</td>
						<td>{{group.forumName}}</td>
						<td>{{group.forumCategory}}</td>
						<td><img src="{{group.forumImage}}"></td>
						
						

						<td><a href="viewblogdetail--{{group.forumId}}--blog"><mark>View
									Details</mark></a></td>
						
							<td><a href="editproduct--{{group.productID}}--product"><mark>Edit</mark></a>
							</td>
							<td><a href="forum/remove/{{group.forumId}}"><mark>Delete</mark></a></td>
						
					</tr>
				</table>
			</div>
		</div>
	</div>
	<hr />
</body>
</html>