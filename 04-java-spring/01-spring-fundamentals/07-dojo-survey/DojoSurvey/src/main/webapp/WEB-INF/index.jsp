<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey Index </title>
<link rel="stylesheet" type = "text/css" href="css/style.css">
</head>
<body>
	<div>
		<form action="/processData" method="POST">
			<label for="name">Your Name:</label><input type="text" name="name" id="name">
			<br>
			<label for="location"> Location:</label>
				<select name="location" id="location">
				<option value="San Jose"> San Jose</option>
				<option value="Dallas">Dallas</option>
				<option value = "Seattle">Seattle</option>
			</select>
			<br>
			<label for="lang"> Favorite Language:</label>
			<select name="lang" id="lang">
				<option value = "Java">Java</option>
				<option value="Python">Python</option>
				<option value="C">C</option>
			</select> 
			<br>
			<label for="comment" id="comment">Comment (Optional)</label>
			<textarea name="comment" rows="4" cols="50"></textarea>
			<br>
			<button>Button</button>
		</form>
	</div>
</body>
</html>