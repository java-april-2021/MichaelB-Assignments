<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit party</title>
		<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class = "container-fluid">
			<h1>${event.name}</h1> <a href="/events">Event MainPage</a>
			<div class = "edit-event">
				<form:form method="PUT" action="/events/${event.id}/edit" modelAttribute="event">
					<form:hidden value="${user.id}" path="organizier"/>
		    		<p class ="form-group">
				        <form:label path="name">Name:</form:label>
				        <form:errors path="name"/>
				        <form:input  class = "form-control" path="name"/>
			   		</p>
			    	<p class = "form-group">
				        <form:label path="eventDate">Date:</form:label>
				        <form:errors path="eventDate"/>
				        <form:input type="date" class ="form-control" path="eventDate"/>
			   		</p>
			    	<p class = "form-group">
				        <form:label path="city">City:</form:label>
				        <form:errors path="city"/>
				        <form:input class = "form-control" path="city"/>
			   		</p>
			   		<p class = "form-group">
				        <form:label path="state" id="version">State:</form:label>
				        <form:errors path="state"/>
				        <form:select  class = "form-control" path="state">
				        	<c:forEach items="${states}" var="state" varStatus="loop">
				        		<c:choose>
				        			<c:when test="${state.equals(event.state)}">
				        				<option selected value=${state}>${state}</option>
				        			</c:when>
				        			<c:otherwise>
				        				<option value=${state}>test case</option>
				        			</c:otherwise>
				        		</c:choose>
				        	</c:forEach>
				        </form:select>
			   		</p>
			    	<input type="submit" value="Edit Language"/> 
				</form:form>
			</div>
		</div>
	</body>
</html>