<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>MainPage</title>
		<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" type="text/css" href="/css/mainPage.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class ="container">
			<div class = "add">
				<h1>DMV</h1>
				<a href="/person/new">Add Driver</a>
				<a href="/license/new">New License</a>
			</div>
			<table class = "table table-dark table-striped">
				<thead>
					<tr>
						<th>Name (Last, First)</th>
						<th>State:</th>
						<th>DL#</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${peeps}" var="peep" varStatus="loop">
					<tr>
						<td><a href="/person/${peep.id}"> ${peep.lastName} ,${peep.firstName}</a></td>
						<c:choose>
							<c:when test="${peep.license != null}">
								<td>${peep.license.state}</td>
								<td>${peep.license.number}</td>
							</c:when>	
							<c:otherwise>
								<td><p>Ridin dirty</p></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>	
				</tbody>
			</table>
		</div>
	</body>
</html>