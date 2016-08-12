<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="addCategory" commandName="category">
<form:label path="categoryId">category id: </form:label><form:input path="categoryId"/>
<br>
<form:label path="categoryName">category name: </form:label><form:input path="categoryName"/>
<br>
<form:label path="description">category description: </form:label><form:input path="description"/>
<br>
<input type="submit" value="add category" />
</form:form>

<h1>category list</h1>
<table>
<tr><th>category id</th>
<th>category name</th>
<th>category desc</th>
</tr>
<c:forEach items="${categoryList}" var="a">
<tr>
<td>${a.categoryId}</td>
<td>${a.categoryName}</td>
<td>${a.description}</td>
</tr>
</c:forEach>
<tr>
</table>
</body>
</html>