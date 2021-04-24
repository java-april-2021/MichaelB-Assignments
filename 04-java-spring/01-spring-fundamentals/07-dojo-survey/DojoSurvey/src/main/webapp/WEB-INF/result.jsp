<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Dojo Survey Index</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<div>
			<c:choose> 
				<c:when test="${lang eq 'Java'}">
					<div class = "info">
					<h3>Submitted Info:</h3>
					<p>Name: <c:out value="${name}"/> </p>
					<p>Dojo Location: <c:out value="${location}"/> </p>
					<p>Favorite Language <c:out value="${lang}"/> </p>
					<p>Comment: <c:out value="${comment}"/> </p>
					<p>Welcome to the big leagues!!</p>
					</div>
				</c:when>
				<c:otherwise>
					<div class = "info">
					<h3>Submitted Info:</h3>
					<p>Name: <c:out value="${name}"/> </p>
					<p>Dojo Location: <c:out value="${location}"/> </p>
					<p>Favorite Language <c:out value="${lang}"/> </p>
					<p>Comment: <c:out value="${comment}"/> </p>
					</div>
				</c:otherwise>
			</c:choose>	
			<a href="/">Back</a>
		</div>
	</body>
</html>