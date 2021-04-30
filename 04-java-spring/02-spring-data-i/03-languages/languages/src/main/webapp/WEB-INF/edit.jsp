<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title> Edit Language </title>
		<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" type="text/css" href="css/styleEdit.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="container-fluid">
			<h1>Edit ${language.name}</h1>
			<div class = "top-links">
				<form class="linkButt" action="/language/${language.id}" method="POST" >
	    		<input type="hidden" name="_method" value="delete">
	    		<input type="submit"  class="btn btn-link" value = Delete>
	    		</form> 
	    		<a href="/languages">Dashboard</a>
			</div>
			<div class = "editForm">
				<form:form method="PUT" action="/language/${language.id}" modelAttribute="language">
		    		<p class ="form-group">
				        <form:label path="name">Name</form:label>
				        <form:errors path="name"/>
				        <form:input  class = "form-control" path="name"/>
			   		</p>
			    	<p class = "form-group">
				        <form:label path="creator" id="creator">Description</form:label>
				        <form:errors path="creator"/>
				        <form:input class ="form-control" path="creator"/>
			   		</p>
			    	<p class = "form-group">
				        <form:label path="currentVersion" id="version">Current Version</form:label>
				        <form:errors path="currentVersion"/>
				        <form:input class = "form-control" path="currentVersion"/>
			   		</p>
			    	<input type="submit" value="Edit Language"/> 
				</form:form>
			</div>
		</div>
	</body>	
</html>