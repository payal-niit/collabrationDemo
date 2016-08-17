<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/views/header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Forum page</title>
</head>
<body>
<div class="container">

		<form:form class="form-signin" action="addingforum" commandName="forum" method="POST" enctype="multipart/form-data">
			<h2 class="form-signin-heading">Create Your Own Forum</h2>
			<spring:bind path="forumName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="forumName" class="form-control"
						placeholder="Add a Forum Title" autofocus="true"></form:input>
					<form:errors path="forumName"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="forumCategory">
			<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:select path="forumCategory">
				 	
				 <form:option value="Study Group" label="Study Group" />
				 <form:option value="Chit Chat" label="Chit Chat" />				
				       </form:select>
                                
					<form:errors path="forumCategory"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="forumDescription">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:textarea rows="3" cols="10" path="forumDescription" class="form-control"
						placeholder="What is your Forum all about?"></form:textarea>
					<form:errors path="forumDescription"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="forumImage">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="file" path="forumImage" />
				</div>
			</spring:bind>
			<%-- <spring:bind path="dateOfCreation">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="date" path="dateOfCreation" class="form-control"></form:input>
					<form:errors path="dateOfCreation"></form:errors>
				</div>
			</spring:bind> --%>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form:form>

	</div>
</body>
</html>