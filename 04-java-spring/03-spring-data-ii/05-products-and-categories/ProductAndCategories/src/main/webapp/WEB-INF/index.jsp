<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>	
	</head>
	<body>
		<div class == "container-fluid">
			<div>
				<a href="/category">Add Category</a>
				<a href="/product">Add Product</a>
				<a href="">Add Category to Product</a>
				
			</div>
			
			<div class= "product-table">
				<table class="table table-dark table-hover">
					<thead>
						<tr>
							<th>Name</th>
							<th>Description</th>
							<th>Price ($)</th>
							<th>Category</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${prods}" var="prod" varStatus="loop">
						<tr>
							<td><a href="/product/${prod.id}">${prod.name}</a></td>
							<td>${prod.description}</td>
							<td> $${prod.price}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class ="category-table">
				<table class="table table-dark table-hover">
					<thead>
						<tr>
							<th>Category</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${cats}" var="cat" varStatus="loop">
						<tr>
							<td> <a href="/category/${cat.id}">${cat.name}</a>  <form class="linkButt" action="category/delete/${cat.id}" method="POST" >
								<input type="hidden" name="_method" value="delete">
								<input type="submit"  class="btn btn-link" value = Delete>
								</form></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>