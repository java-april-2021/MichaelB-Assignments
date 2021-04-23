<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
<meta charset="ISO-8859-1">
<title>Code</title>
</head>
<body>
	<div class = "container">
		<a href="/">Back</a>
		<ul>
			<c:forEach items="${values}" var="value" >
				<li>${value}</li>
			</c:forEach>
		</ul>
	</div>

</body>
</html>