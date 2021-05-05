<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add ninja</title>
		<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container-fluid">
			<a href="/">Menu</a>
			<div class = "options">
				<h1>Add Ninja</h1>
				<form:form method="POST" action="/ninja/new" modelAttribute="ninja">
		    		<div class ="form-group">
				        <form:label path="dojo">Name</form:label>
				        <form:errors path="dojo"/>
				        <form:select  class = "form-control" path="dojo">
				        	<c:forEach items="${dojos}" var="dojo" varStatus="loop">
				        		<form:option value="${dojo}" path="dojo">${dojo.name}</form:option>	
				        	</c:forEach>
				        </form:select>
			   		</div>
			    	<div class = "form-group">
				        <form:label path="firstName" id="creator">First Name:</form:label>
				        <form:errors path="firstName"/>
				        <form:input class ="form-control" path="firstName"/>
			   		</div>
			    	<div class = "form-group">
				        <form:label path="lastName" id="lastName">Last Name:</form:label>
				        <form:errors path="lastName"/>
				        <form:input class = "form-control" path="lastName"/>
			   		</div>
			   		<div class ="form-group">
			   			<form:label path="age" id="lastName">Age</form:label>
			   			<form:errors path="age" id="id"/>
			   			<form:input class = "form-control" path="age"/>
			   		</div>

			    	<input type="submit" value="Add Ninja"/> 	
				</form:form>
			</div>
			
		</div>
	</body>
</html>