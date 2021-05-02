<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Add Song</title>
		<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" type ="text/css" href="/css/addStyle.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class = "container-fluid">
			<a class="return" href="/dashboard">Dashboard</a>
			<div class = "addFrom">
				<form:form method="POST" action="/song/new" modelAttribute="song">
					<p class ="form-group">
						<form:label path="title">Song title</form:label>
						<form:errors path = "title"/>
						<form:input class = "form-control" path="title"/>
					<p class = "form-group">
						<form:label path="artist">Artist</form:label>
						<form:errors path="artist"/>
						<form:input path= "artist" class ="form-control"/>
					</p>
					<p class = "form-group">
						<form:label path="rating">Rating</form:label>
						<form:errors path="rating"/>
						<form:input type="number" min="1" max="10" class ="form-control" path="rating"/>
					</p>
					<input type="submit" value="Add Song"/>
				</form:form>
			</div>
		</div>
		</body>
	</body>
</html>