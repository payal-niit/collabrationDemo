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
<title>Add blog page</title>
<link rel="stylesheet" type="text/css" href="resources/lib/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="resources/src/bootstrap-wysihtml5.css" />
<script src="resources/lib/js/wysihtml5-0.3.0.js"></script>
    <script src="resources/lib/js/jquery-1.7.2.min.js"></script>
    <script src="resources/lib/js/bootstrap.min.js"></script>
    <script src="resources/src/bootstrap3-wysihtml5.js"></script>

    <style type="text/css" media="screen">
        .btn.jumbo {
            font-size: 20px;
            font-weight: normal;
            padding: 14px 24px;
            margin-right: 10px;
            -webkit-border-radius: 6px;
            -moz-border-radius: 6px;
            border-radius: 6px;
        }
    </style>

</head>
<body>
<div class="container">

		<form:form action="addblog" method="POST" commandName="blog"
			class="form-signin">
			<h2 class="form-signin-heading">Create Your Own Blog</h2>
			<spring:bind path="blogName">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="blogName" class="form-control"
						placeholder="Add a blog Title" autofocus="true"></form:input>
					<form:errors path="blogName"></form:errors>
				</div>
			</spring:bind>

			<%-- <spring:bind path="blogCategory">
			<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:select path="blogCategory">
				 	
				 <form:option value="Core JAVA" label="Core JAVA" />
				 <form:option value="Advance JAVA" label="Advance JAVA-" />				
				       </form:select>
                                
					<form:errors path="blogCategory"></form:errors>
				</div>
			</spring:bind> --%>
			
			<spring:bind path="blogCategory">
			<div class="form-group ${status.error ? 'has-error' : ''}">
			<form:select path="blogCategory">
				 	
				<form:options items="${blogOptions}" />
			
				       </form:select>
                                
					<form:errors path="blogCategory"></form:errors>
				</div>
			</spring:bind>

			<spring:bind path="blogDescription">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:textarea rows="5" cols="8" path="blogDescription" class="textarea form-control"
						placeholder="Write something"></form:textarea>
					<form:errors path="blogDescription"></form:errors>
				</div>
			</spring:bind>
			
			<%-- <spring:bind path="image">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<input type="file" path="image">
				</div>
			</spring:bind> --%> 

			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form:form>

	</div>
	<script>
    $('.textarea').wysihtml5();
</script>

<script type="text/javascript" charset="utf-8">
    $(prettyPrint);
</script>
	
</body>
</html>