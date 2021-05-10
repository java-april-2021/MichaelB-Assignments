<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>New Question</title>
			<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
			<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
			<link rel="stylesheet" type="text/css" href="/css/style.css">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class = "container-fluid">
			<a href="/">Main Page</a>
			<div class = "questionForm">
				<h1>What is you question?</h1>
				<form:form method="POST" action="/" modelAttribute="newQuestion">
		    		<p class ="form-group">
				        <form:label path="question">Question</form:label>
				        <form:errors path="question"/>
				        <form:input  class = "form-control" path="question"/>
			   		</p>
			    	<p class = "form-group">
				        <form:label path="Tags" id="tags">Tags</form:label>
				        <form:errors path="Tags"/>
				        <form:input class ="form-control" path="Tags"/>
			   		</p>
			    	<input type="submit" value="Add Question"/> 
				</form:form>
			</div>
		</div>
	</body>
</html>