<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Ninja Gold</title>
		<link rel="stylesheet" type = "text/css" href="css/style.css">
	</head>
	<body>
		<div class = "container">
			<h3>Your Gold: <c:out value ="${totalGold}"/></h3>
			<div class = "building">
				<form action="/processGold" method="POST">
					<h3>Farm</h3>
					<input type="hidden" value = "farm" name="building">
					<p>(earns 10-20 gold)</p>
					<button>Find Gold!</button>
				</form>
				<form action="/processGold" method="POST">
					<h3>Cave</h3>
					<input type="hidden" value = "cave" name="building">
					<p>(earns 5-10 gold)</p>
					<button>Find Gold!</button>
				</form>
				<form action="/processGold" method="POST">
					<h3>House</h3>
					<input type="hidden" value = "house" name="building">
					<p>(earns 2-5 gold)</p>
					<button>Find Gold!</button>
				</form>
				<form action="/processGold" method="POST">
					<h3>Casino</h3>
					<input type="hidden" value = "casino" name="building">
					<p>(earns 0-50 gold)</p>
					<button>Find Gold!</button>
				</form>
			</div>
				<div>
					<h3 class="actTitle">Activities:</h3>
					<div class = "activity">
						<c:forEach items = "${activity}" var="act">
							<c:choose>
								<c:when test = "${act.contains('ouch')}" >
								<p class = 'red'> ${act}</p>
								</c:when>
								<c:otherwise>
								<p class = 'green'> ${act}</p>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						</div>
				</div>
				
			
		</div>
	</body>
</html>