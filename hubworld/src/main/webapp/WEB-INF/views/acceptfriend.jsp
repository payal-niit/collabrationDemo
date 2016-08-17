<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/views/header.jsp"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script> 
		var myApp = angular.module('myApp',[]);
	 
		myApp.controller('getData', function($scope)
		 {
			$scope.userId=${userId};
			$scope.userProfile=${userProfile};
			$scope.userDetail=${userDetail};
			
			
		 }); 
	
  </script> 
  <script>
  $(document).ready(function() {
	    var panels = $('.user-infos');
	    var panelsButton = $('.dropdown-user');
	    panels.hide();

	    //Click dropdown
	    panelsButton.click(function() {
	        //get data-for attribute
	        var dataFor = $(this).attr('data-for');
	        var idFor = $(dataFor);

	        //current button
	        var currentButton = $(this);
	        idFor.slideToggle(400, function() {
	            //Completed slidetoggle
	            if(idFor.is(':visible'))
	            {
	                currentButton.html('<i class="glyphicon glyphicon-chevron-up text-muted"></i>');
	            }
	            else
	            {
	                currentButton.html('<i class="glyphicon glyphicon-chevron-down text-muted"></i>');
	            }
	        })
	    });


	    $('[data-toggle="tooltip"]').tooltip();

	    
	});
  </script>
  <style>
  .user-row {
    margin-bottom: 14px;
}

.user-row:last-child {
    margin-bottom: 0;
}

.dropdown-user {
    margin: 13px 0;
    padding: 5px;
    height: 100%;
}

.dropdown-user:hover {
    cursor: pointer;
}

.table-user-information > tbody > tr {
    border-top: 1px solid rgb(221, 221, 221);
}

.table-user-information > tbody > tr:first-child {
    border-top: 0;
}

.table-user-information > tbody > tr > td {
    border-top: 0;
}
.toppad
{margin-top:20px;
}
  
  </style>
</head>
<body>
      <div class="row">
      <div class="col-md-5  toppad  pull-right col-md-offset-3 ">
           <A href="edit.html" >Edit Profile</A>

        <A href="perform_logout" >Logout</A>
       <br>
       <%
   Date date = new Date();
   out.print( "<p class=\"text-info\">" +date.toString()+"</p>");
%>

      </div>
        <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
   
   
          <div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">{{userProfile.username}}</h3>
              <h3 class="panel-title">Thought for the Day: {{userProfile.wallMessage}}</h3>
              
            </div>
            <div class="panel-body">
              <div class="row">
                <div class="col-md-3 col-lg-3 " align="center"> <img alt="User Pic" src="resources/images/${userId}.jpg" class="img-circle img-responsive"> </div>
                
                <!--<div class="col-xs-10 col-sm-10 hidden-md hidden-lg"> <br>
                  <dl>
                    <dt>DEPARTMENT:</dt>
                    <dd>Administrator</dd>
                    <dt>HIRE DATE</dt>
                    <dd>11/12/2013</dd>
                    <dt>DATE OF BIRTH</dt>
                       <dd>11/12/2013</dd>
                    <dt>GENDER</dt>
                    <dd>Male</dd>
                  </dl>
                </div>-->
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>User Name:</td>
                        <td>{{userProfile.username}}</td>
                      </tr>
                      <tr>
                        <td>Age:</td>
                        <td>{{userProfile.age}}</td>
                      </tr>
                      <tr>
                        <td>Date of Birth</td>
                        <td>{{userProfile.dob}}</td>
                      </tr>
                   
                         <tr>
                             <tr>
                        <td>Gender</td>
                        <td>{{userDetail.gender}}</td>
                      </tr>
                      <tr>
                        <td>Relationship Status</td>
                        <td>{{userProfile.relationsipStatus}}
                        </td>
                           
                      </tr>
                        <tr>
                        <td>Few words</td>
                        <td>{{userProfile.aboutUrself}}</td>
                      </tr>
                      <tr>
                        <td>Email</td>
                        <td><a href="mailto:{{userDetail.email}}">{{userDetail.email}}</a></td>
                      </tr>
                      <tr>
                        <td>Date of Birth</td>
                        <td>{{userProfile.dob}}
                        </td>                           
                      </tr>
                     <tr>
                        <td>Interests</td>
                        <td>{{userProfile.interests}}
                        </td>                           
                      </tr>
                      <tr>
                        <td>Qualification</td>
                        <td>{{userProfile.qualification}}
                        </td>                           
                      </tr>
                      <tr>
                        <td>Why you Joined?</td>
                        <td>{{userProfile.reasonOfJoining}} ---- {{friendList.id}}
                        </td>
                           
                      </tr>
                    </tbody>
                  </table>
                  <form:form action="confirmfriend?userId=${userProfile.userId}" modelAttribute="userFriend" commandName="userFriend">
		<input type="hidden" value="${userProfile.userId}"/>
                  <Button class="btn btn-primary">Accept request</Button>
                </form:form>
                </div>
              </div>
            </div>
                 <div class="panel-footer">
                 
                        <a data-original-title="Broadcast Message" data-toggle="tooltip" type="button" class="btn btn-sm btn-primary"><i class="glyphicon glyphicon-envelope"></i></a>
                        <span class="pull-right">
                            <a href="edit.html" data-original-title="Edit this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-warning"><i class="glyphicon glyphicon-edit"></i></a>
                            <a data-original-title="Remove this user" data-toggle="tooltip" type="button" class="btn btn-sm btn-danger"><i class="glyphicon glyphicon-remove"></i></a>
                        </span>
                    </div>
            
          </div>
        </div>
      </div>
    </div>
</body>
</html>