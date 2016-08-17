<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/common.css" rel="stylesheet">

<script>
		var myApp = angular.module('myApp',[]);
		myApp.controller('getData', function($scope,$http,$location)
		 { 
			$scope.searchKeyword=location.search.substr(9);
			$scope.userdata = ${userList};
			//alert($scope.productdata);
		 
		 });
	
</script>

</head>
<body text="white" np-app="myApp" ng-controller="getData">
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
				<h1 class="title">User List</h1>
				<hr />
			</div>
		</div>
		<table
			class="table table-striped table-inverse table-bordered table-hover table-sm"
			style="text-align: center;">
			<tr scope="row" align="center">
				<th>UserId</th>
				<th>User Name</th>
				<th>Gender</th>
				<th>Enabled</th>
				<th>Edit</th>
				<th>Delete</th>
				<th>View Details</th>

			</tr>
			<c:forEach items="${userList}" var="user">

				<tr scope="row">
					<td>${user.userId}</td>
					<td>${user.username}</td>

					<td>${user.gender}</td>
					<td>${user.enabled}</td>

					<td><a href="<c:url value='product/edit/${user.userId}' />">Edit</a></td>
					<td><a href="<c:url value='deleteuser--{userId}--user"' />">Delete</a></td>
					<td><a href="<c:url value='product/get/${user.userId}' />">View
							details</a></td>

				</tr>
			</c:forEach>
		</table>


	</div>


	<script src="resources/js/jquery-1.12.3.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>

</body>
</html>