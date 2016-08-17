<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ include file="/WEB-INF/views/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container" style="width:600px">
<form:form class="form-horizontal" method="post"
                modelAttribute="userProfile" action="addprofile">

		
		<spring:bind path="aboutUrself">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-4 control-label">Who are You?</label>
			<div class="col-sm-6">
				<form:input path="aboutUrself" class="form-control"
                                id="aboutUrself" placeholder="Say something about yourself" />
				<form:errors path="aboutUrself" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="relationsipStatus">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-4 control-label">RelationShip Status</label>
			<div class="col-sm-6">
					<form:radiobutton path="relationsipStatus" value="Single" name="gen" />
					Single
					<form:radiobutton path="relationsipStatus" value="Married" name="gen" />
					Married
					<form:radiobutton path="relationsipStatus" value="Relationship" name="gen" />
					In Relationship
					<form:radiobutton path="relationsipStatus" value="Complicated" name="gen" />
					Complicated
				</div>
				</div>
			</spring:bind>

		

		<spring:bind path="wallMessage">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-4 control-label">Wall Message</label>
			<div class="col-sm-6">
				<form:textarea path="wallMessage" rows="5" class="form-control"
                                id="wallMessage" placeholder="wallMessage" />
				<form:errors path="wallMessage" class="control-label" />
			</div>
		  </div>
		</spring:bind>

		<spring:bind path="age">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-4 control-label">Age</label>
			<div class="col-sm-6">
				<form:input path="age" class="form-control"
                                id="age" placeholder="age" />
				<form:errors path="age" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		
		<spring:bind path="interests">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-4 control-label">Interests</label>
			<div class="col-sm-6">
			<form:select path="interests">
				 	
				<form:options items="${interestOptions}" />
			
				       </form:select>
                                
					<form:errors path="interests"></form:errors>
				</div>
				</div>
			</spring:bind>

		<spring:bind path="info">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-4 control-label">Info</label>
			<div class="col-sm-6">
				<form:input path="info" class="form-control"
                                id="info" placeholder="Info" />
				<form:errors path="info" class="control-label" />
			</div>
		  </div>
		</spring:bind>

		<spring:bind path="qualification">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-4 control-label">Qualification</label>
			<div class="col-sm-6">
				<form:input path="qualification" class="form-control"
                                id="qualification" placeholder="Info" />
				<form:errors path="qualification" class="control-label" />
			</div>
		  </div>
		</spring:bind>

		<spring:bind path="reasonOfJoining">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-4 control-label">Reason for Joining</label>
			<div class="col-sm-6">
			<form:select path="reasonOfJoining">
				 	
				<form:options items="${joinOptions}" />
			
				       </form:select>
                                
					<form:errors path="reasonOfJoining"></form:errors>
				</div>
				</div>
			</spring:bind>

		

		<spring:bind path="dob">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-4 control-label">Age</label>
			<div class="col-sm-6">
				<form:input type="text" path="dob" class="form-control"
                                id="dob" />
				<form:errors path="dob" class="control-label" />
			</div>
		  </div>
		</spring:bind>
		<div class="col-sm-10" style="align:center;">
		<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</div>
	</form:form>
	</div>
</body>
</html>