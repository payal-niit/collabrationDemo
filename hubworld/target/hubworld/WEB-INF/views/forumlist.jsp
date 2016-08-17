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
img:hover {width:200px;height:175px;}
</style>
</head>
<body ng-app="TestApp" ng-controller="testController">
<%@ include file="/WEB-INF/views/header.jsp"%>
<div class="container">
<h1 align="center">All the forums Available</h1>
<hr>
  <table class="table table-hover table-condensed table-bordered" datatable="ng" dt-options="vm.dtOptions">
    <thead>
      <tr><th>Sr</th><th>Forum ID</th>
						<th>Admin</th>
						<th>Forum Name</th>
						<th>Forum Category</th>
						<th>Image</th>
						<th>Date of Creation</th>
						<th>Operations</th>
						
						</tr>
    </thead>
    <tbody>
      <tr ng-repeat="group in userList">
        <td>{{$index + 1}}</td>
        <td>{{group.forumId}}</td>
						<td>{{group.username}}</td>
						<td>{{group.forumName}}</td>
						<td>{{group.forumCategory}}</td>
						<td><img style="width:50px;height:50px;" src="{{group.forumImage}}"></td>
						<td>{{group.dateOfCreation}}</td>
						<td><button class="btn btn-info glyphicon glyphicon-info-sign"></button>
						<button class="btn btn-warning glyphicon glyphicon-edit"></button>
						<button class="btn btn-danger glyphicon glyphicon-remove-sign"></button></td>
      </tr>
    </tbody>
  </table>
  </div>
</body>
</html>
<script>
angular.module('TestApp', ['TestApp.controllers','datatables']);
	
	angular.module('TestApp.controllers', []).controller('testController', function($scope,DTOptionsBuilder, DTColumnBuilder) {
		$scope.userList = ${forumList}
		  
		$scope.vm = {};

		$scope.vm.dtOptions = DTOptionsBuilder.newOptions()
		  .withOption('order', [0, 'asc']);
		 });

</script>
