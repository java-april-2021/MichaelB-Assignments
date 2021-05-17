<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Show Event</title>
			<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
			<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
			<link rel="stylesheet" type="text/css" href="/css/style.css">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class = "container-fluid">
			<a href="/events">Event page</a>
			<div class = "event-table">
				<div>
					<h1></h1>
					<h2>${event.name}</h2>

					<h4>Host: ${event.organizier.firstName} ${event.organizier.lastName}</h4>
					<h4>Date: <fmt:formatDate type="date" value="${event.eventDate}"/></h4>
					<h4>Location: ${event.city}, ${event.state}</h4>
					<h4>People who are attending this event: ${event.attendees.size()}</h4>
				</div>
				<table class = "table table-dark table-hover event-table">
					<thead>
						<tr>
							<th>Name</th>
							<th>Location</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<c:forEach items="${event.attendees}" var="attendee" varStatus="loop">
								<td>${attendee.firstName} ${attendee.lastName}</td>
								<td>${attendee.city} ${attendee.state}</td>
							</c:forEach>
						</tr>
					</tbody>
				</table>
			</div>
			<div class = "messages-pane">
				<div class= "messages">
					<c:choose>
						<c:when test="${event.comments.size() == 0}">
							<p>Be the first to make a comment!!</p>
						</c:when>
						<c:otherwise>
							<c:forEach items="${event.comments}" var="comment" varStatus="loop">
							<p> <span>${comment.commentor.firstName} ${comment.commentor.lastName}:</span>  ${comment.content}</p>
					</c:forEach>
						</c:otherwise>
					</c:choose>	
				</div>
				<form method="POST" action="/events/${event.id}">
		    		<p class ="form-group">
				        <label path="content">Content</label>
				        <form:errors path="content"/>
				        <textarea type = "text" name="comment" class = "form-control"></textarea>
			    	<input type="submit" value="Add Comment"/> 
				</form>
			</div>
		</div>
	</body>
</html>