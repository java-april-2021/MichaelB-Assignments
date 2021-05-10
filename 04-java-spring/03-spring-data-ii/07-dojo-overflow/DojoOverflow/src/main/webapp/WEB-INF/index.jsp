<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Question Dashboard</title>
			<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
			<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
			<link rel="stylesheet" type="text/css" href="css/style.css">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class = "container-fluid">
			<h1>Question Dashboard</h1>
			<div class = "questions-table">
				<table class = "table table-dark table-striped">
					<thead>
						<tr>
							<th>Question</th>
							<th>Tags</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${questions}" var="question" varStatus="loop">
							<tr>
								<td><a href="/${question.id}">${question.question}</a></td>
								<td>
									<c:forEach items="${question.tags}" var="tag" varStatus="loop">
										<span>${tag.subject}<c:if test="${question.tags.indexOf(tag) != question.tags.size()-1}">, </c:if></span>
									</c:forEach>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a href="/new">New Question</a>
			</div>
		</div>
	</body>
</html>