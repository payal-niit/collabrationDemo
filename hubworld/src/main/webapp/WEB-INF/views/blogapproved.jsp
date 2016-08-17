<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page isELIgnored="false"%>
<html>
<head>
<script src="resources/js/jquery-1.12.3.min.js"></script>
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/angular-datatables.min.js"></script>
<script src="resources/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">

<link rel="stylesheet" href="resources/css/datatables.bootstrap.css">
<style>
/* .table-nonfluid {
   width: auto !important;
} */
</style>
</head>
<body ng-app="TestApp" ng-controller="testController">
<%@ include file="/WEB-INF/views/header.jsp"%>
<div class="container" style="width:65%">
<h1 align="center">Available blogs</h1>
  <table class="table table-hover table-condensed table-bordered table-nonfluid" datatable="ng" dt-options="vm.dtOptions">
    <thead>
      <tr><th>Sr</th><th>Blog ID</th>
						<th>USer Name</th>
						<th>Blog Name</th>
						<th>Blog Category</th>
						<th>View</th>
						
						</tr>
    </thead>
    <tbody>
      <tr ng-repeat="group in userList">
        <td>{{$index + 1}}</td>
        <td>{{group.blogAppId}}</td>
						<td>{{group.username}}</td>
						<td>{{group.blogName}}</td>
						<td>{{group.blogCategory}}</td>
						
						<td style="text-align:center"><a href="viewappblogdetail--{{group.blogAppId}}--blogApproved" class="glyphicon glyphicon-info-sign"></a>
						 <!-- <a class="glyphicon glyphicon-edit"></a> -->
						 <sec:authorize access="hasRole('ROLE_ADMIN')">
						<a href="blog/remove/{{group.blogAppId}}" class="glyphicon glyphicon-remove-sign"></a>
						</sec:authorize></td>
						
      </tr>
    </tbody>
  </table>
  </div>
</body>
</html>
<script>
angular.module('TestApp', ['TestApp.controllers','datatables']);
	
	angular.module('TestApp.controllers', []).controller('testController', function($scope,DTOptionsBuilder, DTColumnBuilder) {
		$scope.userList = ${blogAppList}
		  
		$scope.vm = {};

		$scope.vm.dtOptions = DTOptionsBuilder.newOptions()
		  .withOption('order', [0, 'asc']);
		 });

</script>
