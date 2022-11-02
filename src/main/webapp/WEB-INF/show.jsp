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
		<h1>New Ninja</h1>
		<a href="/">Add New Dojo</a>
		<div class="section">
			<form:form action="/create/ninja" method="post"
				modelAttribute="ninja">

				<form:select path="dojo">
					<c:forEach items="${allDaDojos }" var="dojo">
						<form:option value="${dojo.id }">${dojo.name }</form:option>
					</c:forEach>
				</form:select>
				
				<p>
					<form:label path="firstName">First Name:</form:label>
					<form:errors path="firstName" />
					<form:input path="firstName" />
				</p>

				<p>
					<form:label path="lastName">Last Name:</form:label>
					<form:errors path="lastName" />
					<form:input path="lastName" />
				</p>

				<p>
					<form:label path="age">Age:</form:label>
					<form:errors path="age" />
					<form:input type="number" path="age" />
				</p>


				<input type="submit" value="Submit" />
			</form:form>
		</div>
	</div> 





</body>
</html>

