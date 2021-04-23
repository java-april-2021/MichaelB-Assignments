<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
</head>
<body>
<a href="/reset">Reset counter</a>
<h2>You have visited enter site <a href="/1">The counted</a> <c:out value="${count}"></c:out> times</h2>
<a href="/1">Test another visit?</a>
<br>
<a href="/2">Visit x 2</a>
</body>
</html>