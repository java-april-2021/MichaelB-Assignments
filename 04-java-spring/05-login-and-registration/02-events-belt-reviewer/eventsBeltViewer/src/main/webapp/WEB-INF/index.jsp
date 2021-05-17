<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>EventsBeltViewer</title>
			<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
			<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
			<link rel="stylesheet" type="text/css" href="/css/style.css">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class ="container-fluid">
			<div class = "register">
				<form:form method="POST" action="/register" modelAttribute="register">
	    		<p class ="form-group">
			        <form:label path="firstName">First Name:</form:label>
			        <form:errors path="firstName"/>
			        <form:input  class = "form-control" path="firstName"/>
		   		</p>
		    	<p class = "form-group">
			        <form:label path="lastName" id="lastName">Last Name</form:label>
			        <form:errors path="lastName"/>
			        <form:input class ="form-control" path="lastName"/>
		   		</p>
		    	<p class = "form-group">
			        <form:label path="email" id="email">Email:</form:label>
			        <form:errors path="email"/>
			        <form:input class = "form-control" path="email"/>
		   		</p>
		   		<p class = "form-group">
			        <form:label path="city" id="city">City:</form:label>
			        <form:errors path="city"/>
			        <form:input class = "form-control" path="city"/>
		   		</p>
		   		<p class = "form-group">
			        <form:label path="state" id="state">State:</form:label>
			        <form:errors path="state"/>
			        <form:select  class = "form-control" path="state">
			        	<c:forEach items="${states}" var="state" varStatus="loop">
			        		<option value="${state}">${state}</option>
			        	</c:forEach>
			    	</form:select>
		   		</p>
		   		<p class = "form-group">
			        <form:label path="password" id="password">Password:</form:label>
			        <form:errors path="password"/>
			        <form:input class = "form-control" path="password"/>
		   		</p>
		   		<p class = "form-group">
			        <form:label path="passwordConfirmation" id="passwordConfirmation">Confirm Password:</form:label>
			        <form:errors path="passwordConfirmation"/>
			        <form:input class = "form-control" path="passwordConfirmation"/>
		   		</p>
		    	<input type="submit" value="Register"/> 
				</form:form>
			</div>
			<div class = "login">
				<p>${error}</p>
				<form action="/login" method="POST">
					<label for= "email">Email</label>
					<input type="text" name="email">
					<label for="pasword">Password</label>
					<input type="password" name="password">
					<input type="submit" name="LogIn">
				</form>
			</div>
		</div>
	</body>
</html>