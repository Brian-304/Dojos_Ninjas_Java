<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tacos</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h1>${thisDojo.name } Location Ninjas</h1>
		<a href="/new/ninja">Add Ninja</a>
		<div class="section">
			<table class="table">
				<thead>
					<tr>
						<th><h1>First Name</h1></th>
						<th><h1>Last Name</h1></th>
						<th><h1>Age</h1></th>
					</tr>
				</thead>
				<c:forEach items="${thisDojo.ninjas }" var="ninjas">
					<tr>
						<td>${ninjas.firstName }</td>
						<td>${ninjas.lastName }</td>
						<td>${ninjas.age }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>



</body>
</html>

