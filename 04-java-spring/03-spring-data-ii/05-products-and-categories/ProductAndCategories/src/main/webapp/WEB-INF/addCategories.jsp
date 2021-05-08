<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>add Category to Product</title>
		<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class = "container-fluid">
			<div class = "addCategory-nav">
				<a href="/">Main Page</a>
			</div>
			
			<div class="product-category">
				<h1>${prod.name}</h1>
				<ol>
					<c:forEach items="${prod.categories}" var="cat" varStatus="loop">
						<li>${cat.name}</li>
					</c:forEach>
				</ol>
			</div>
			<div class="category-list">
				<h2>Add Category to ${prod.name}</h2>
				<form action="/product/add" method="POST">
					<input type="hidden" name="product_id" value=${prod.id}>
					<select name ="category_id">
						<c:forEach items="${cats}" var="cat" varStatus="loop">
							<option value=${cat.id}>${cat.name}</option>
						</c:forEach>
					</select>
					<input type="submit" name="Add Category">
				</form>
			</div>
		</div>
	</body>
</html>