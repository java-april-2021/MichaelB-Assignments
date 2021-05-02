<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<title>Artist</title>
		<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" type="text/css" href="">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class = "container-fluid">
			<div class = "top">
				<form action="" method="POST"> <input type="text" name=""> <input type="submit" name=""></form><a href="/dashboard">Dashboard</a>				
			</div>
			<div>
				<table class = "table table-dark table-hover thead-dark table-striped">
					<thead>
						<tr>
							<th>Name</th>
							<th>Rating</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${songs}" var="song" varStatus="loop">
						<tr>
							<td><a href="/song/${song.id}">${song.title}</a> </td>
							<td>${song.rating}</td>
							<td><a href="">Delete</a></td>
						</tr>
						</c:forEach>
					</tbody>
					</tbody>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>