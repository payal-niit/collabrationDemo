<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/views/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script> 
		var myApp = angular.module('myApp',[]);
	 
		myApp.controller('getData', function($scope)
		 {
			$scope.userId=${userId};
			/* $scope.userProfile=${userProfile};
			$scope.userDetail=${userDetail};
			$scope.friendList=${friendList}; */			
		 }); 
	
  </script> 
</head>
<body>
<div align="right" style="margin-top:0px;text-transform: capitalize;color:white;float:right;">
<c:if test="${pageContext.request.userPrincipal.name != null}">
					Welcome: <b>${pageContext.request.userPrincipal.name}</b>&nbsp&nbsp&nbsp
					<img style="width:50px;height:45px" src="resources/images/${userId}.jpg">&nbsp&nbsp&nbsp
                </c:if>
                </div>
                
                <div class="container" ng-app="">
<form role="form">
<div class="row">
  <div class="form-group">
    
    <div class="col-lg-3 col-sm-3 col-md-3">
    <input type="text" ng-model="name" placeholder="Search Friends" class="form-control" /></div>
    <div class="col-lg-3 col-sm-3 col-md-3">
    <a href="userlist?search={{name}}" class="btn btn-default">Search</a>
    {{name}}
        
  </div>
  </div></div>  
</form>
</div>
</body>
</html>