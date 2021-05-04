<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Person</title>
		<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" type="text/css" href="/css/personStyle.css"/>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	</head>
	<body>
		<div>
			<a href="/">Main Page</a>
			<h1>New Person</h1>
			<div class = "add">
				<form:form method="POST" action="" modelAttribute="person">
		    		<p class ="form-group">
				        <form:label path="firstName">First Name</form:label>
				        <form:errors path="firstName"/>
				        <form:input  class = "form-control" path="firstName"/>
			   		</p>
			    	<p class = "form-group">
				        <form:label path="lastName" >Last Name</form:label>
				        <form:errors path="lastName"/>
				        <form:input class ="form-control" path="lastName"/>
			   		</p>
			    	<input type="submit" value="Add Person"/> 
				</form:form>
			</div>
			
		</div>
	</body>
</html>