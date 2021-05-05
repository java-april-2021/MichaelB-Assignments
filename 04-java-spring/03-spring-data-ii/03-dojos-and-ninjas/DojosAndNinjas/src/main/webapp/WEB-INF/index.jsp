<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Dojos and Ninjas</title>
			<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
			<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
			<link rel="stylesheet" type="text/css" href="/css/style.css">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class = "container-fluid">
			<div class = "options">
				<h3>Welcome Dojo Database</h3>
				<a href="/dojo/new">Add Dojo</a> <a href="/ninja/new">Add Ninja</a> <a href=""></a>		
			</div>
			<div class="search">
			</div>
			<div class = "info">
				<table class = "table table-dark table-hover">
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Age</th>
							<th>Dojo</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ninjas}" var="ninja" varStatus="loop">
							<tr>
								<td>${ninja.firstName}</td>
								<td>${ninja.lastName}</td>
								<td>${ninja.age}</td>
								<td><a href="/dojo/${ninja.dojo.id}">${ninja.dojo.name}</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>	
		</div>
	</body>
</html>