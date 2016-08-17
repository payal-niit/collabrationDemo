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

<script>
var myApp = angular.module('myApp',[]);
myApp.controller('getData', function($scope,$http,$location)
 { 
	$scope.searchKeyword=location.search.substr(8);
	$scope.productdata = ${userList};
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
									Users</label>
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
				<h1 class="title">User List</h1>
				<hr />
			</div>
		</div>
		<div class="row text-center">
			<!-- products grid -->

			<div class="container col-lg-12" align="center">
				<table
					class="table-responsive table table-bordered table-condensed table table-hover">
					<tr>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<th>User ID</th>
						</sec:authorize>
						<th>User Name</th>
						<th>Gender</th>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
						<th>Enabled</th>						
						<th>Role</th>
						</sec:authorize>
						<th>Email</th>
						<th>User Picture</th>
						<th>Check out</th>
						<!-- <th>Add friend</th> -->
					<sec:authorize access="hasRole('ROLE_ADMIN')">						
							<th>Delete</th>
					</sec:authorize>
					</tr>
					<tr ng-repeat="group in productdata | filter:searchKeyword	">

					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<td>{{group.userId}}</td>
						</sec:authorize>
						<td>{{group.username}}</td>
						<td>{{group.gender}}</td>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
						<td>{{group.enabled}}</td>
						<td>{{group.role}}</td>
						</sec:authorize>
						<td>{{group.email}}</td>
						<td><img style="width:75px;height:75px" src="{{group.image}}"></td>
						<td><a href="viewprofile--{{group.userId}}--user">Profile</a></td>
						<%-- <td> <form:form action="addfriend?userId=${userProfile.userId}" modelAttribute="userFriendTemp" commandName="userFriendTemp">
		<input type="hidden" value="${userProfile.userId}"/>
                  <Button class="btn btn-primary">Add Friend</Button></form:form></td> --%>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<td><a href="deleteuser--{{group.userId}}--user"><mark>Delete</mark></a></td>
						</sec:authorize>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<hr />
</body>
</html>