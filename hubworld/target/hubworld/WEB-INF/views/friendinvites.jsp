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
						
			$scope.friend=${friendList};			
		 }); 
	
  </script> 
</head>
<body>
<div class="container">
<table><tr>
<th>Friend invites</th></tr>
<tr ng-repeat="group in friend">
<td>
{{group.username}}</td>
<td>{{group.userId}}</td>
<td><td><a href="viewprofile--{{group.userId}}--user">Profile</a></td></td>

</tr>
</table>
 <%-- <form:form action="confirmfriend?userId=${friendList.userId}" modelAttribute="userFriend" commandName="userFriend">
		<input type="hidden" value="${friendList.userId}"/>
                  <Button class="btn btn-primary">Add Friend</Button>
                </form:form> --%>
</div>
</body>
</html>