<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Events</title>
			<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
			<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
			<link rel="stylesheet" type="text/css" href="/css/style.css">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class = "container-fluid">
			<div>
				<h1>Welcome, ${user.firstName}!!</h1>
				<a href="/logout">Logout</a>
			</div>
			<div class="InState ">
				<h3>In State Events</h3>
				<table class="table table-dark table-striped">
					<thead>
						<tr>
							<th>Name</th>
							<th>Date</th>
							<th>Location</th>
							<th>Host</th>
							<th>Action/Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${InState}" var="event" varStatus="loop">
							<tr>
								<td><a href="/events/${event.id}">${event.name}</a></td>
								<td><fmt:formatDate type="date" value="${event.eventDate}"/></td>
								<td>${event.city}</td>
								<td>${event.organizier.lastName}, ${event.organizier.firstName}</td>
								<c:choose>
									<c:when test="${event.organizier.equals(user)}">
										<td><a href="/events/${event.id}/edit">Edit</a> <form class="delete-event" action ="/events/del/${event.id}" method ="POST"><input class="btn btn-link" type="submit" value="Cancel"></form><Cancel</td>
									</c:when>
									<c:otherwise>
										<c:if test="${event.attendees.contains(user)}">
											<td>
												<form action="/events/remove/${event.id}" method="POST">
													<input type="submit" class="btn btn-link" value="Peace Out!!">
												</form>
											</td>
										</c:if>
										<c:if test="${!event.attendees.contains(user)}">
											<td><form action="/events/add/${event.id}" method="POST">
													<input type="submit" class="btn btn-link" value="Join">
												</form>
											</td>
										</c:if>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="outOfState">
				<h3>Out of State Events</h3>
				<table class="table table-dark table-striped">
					<thead>
						<tr>
							<th>Name</th>
							<th>Date</th>
							<th>Location</th>
							<th>State</th>
							<th>Host</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${outOfState}" var="event" varStatus="loop">
							<tr>
								<td><a href="/events/${event.id}">${event.name}</a> </td>
								<td><fmt:formatDate type="date" value="${event.eventDate}"/></td>
								<td>${event.city}</td>
								<td>${event.state}</td>
								<td>${event.organizier.lastName}, ${event.organizier.firstName}</td>
								<c:choose>
									<c:when test="${event.organizier.equals(user)}">
										<td><a href="/events/${event.id}/edit">Edit</a> <form class="delete-event" action ="/events/del/${event.id}" method ="POST"><input class="btn btn-link" type="submit" value="Cancel"></form><Cancel</td>
									</c:when>
									<c:otherwise>
										<c:if test="${event.attendees.contains(user)}">
											<td>
												<form action="/events/remove/${event.id}" method="POST">
													<input type="submit" class="btn btn-link" value="Peace Out!!">
												</form>
											</td>
										</c:if>
										<c:if test="${!event.attendees.contains(user)}">
											<td><form action="/events/add/${event.id}" method="POST">
													<input type="submit" class="btn btn-link" value="Join">
												</form>
											</td>
										</c:if>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="eventForm">
				<form:form method="POST" action="/events" modelAttribute="event">
					<form:input type="hidden" path="organizier" value="${user.id}"/>
	    		<p class ="form-group">
			        <form:label path="name">Name</form:label>
			        <form:errors path="name"/>
			        <form:input  class = "form-control" path="name"/>
		   		</p>
		    	<p class = "form-group">
			        <form:label path="eventDate" id="eventDate">Date:</form:label>
			        <form:errors path="eventDate"/>
			        <form:input type="date" value ="${now}" class ="form-control" path="eventDate"/>
		   		</p>
		    	<p class = "form-group">
			        <form:label path="city" id="city">City</form:label>
			        <form:errors path="city"/>
			        <form:input class = "form-control" path="city"/>
		   		</p>
		   		<p class = "form-group">
			        <form:label path="state" id="state">State:</form:label>
			        <form:errors path="state"/>
			        <form:select  class = "form-control" path="state">
			        	<c:forEach items="${states}" var="state" varStatus="loop">
			        		<option value="${state}">${state}</option>
			        	</c:forEach>
			    	</form:select>
		   		</p>
		    	<input type="submit" value="Add Event"/>
				</form:form>
			</div>
		</div>
	</body>
</html>