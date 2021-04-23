<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>Insert title here</title>
</head>
<body>
	<div class = container>
		<form action="/check" method="POST">
		<span><c:out value="${error}"/> </span>
			<h4>What is the code?</h4>
			<input type="text" name = "codeWord">
			<button>Try Code</button>
		</form>
	</div>
</body>
</html>