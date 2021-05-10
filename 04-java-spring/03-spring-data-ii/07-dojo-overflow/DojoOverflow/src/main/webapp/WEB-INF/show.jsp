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
		<div class = "container-fluid">
			<a href="/">Main Page</a>
			<div class = "show-question">
				<h1>${question.question}</h1>
				<h5>Tags: <c:forEach items="${question.tags}" var="tag" varStatus="loop"> <span class = "subject-tags"> ${tag.subject} </span> </c:forEach></h5>
			</div>
			<div class = "answers">
				<table class = "table table-dark table-hover">
					<thead>
						<colgroup span ="3">
							<col width = "600"></col>
						</colgroup>
						<tr>
							<th>Answers</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${question.answers}" var="answer" varStatus="loop">
							<tr>
								<td>${answer.answer}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<form:form method="POST" action="/answers" modelAttribute="answer">
					<h3>Add your answer</h3>
		    		<p class ="form-group">
				        <form:label path="Answer">Answer</form:label>
				        <form:errors path="Answer"/>
				        <form:textarea class = "form-control" path="Answer"></form:textarea>
			   		</p>
			   		<form:hidden path="question" value="${question.id}"/>
			   		<form:errors path="question"/>
			    	<input type="submit" value="Add Language"/> 
				</form:form>
			</div>
		</div>
	</body>
</html>