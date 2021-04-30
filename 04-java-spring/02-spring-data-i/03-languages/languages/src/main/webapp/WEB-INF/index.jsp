<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Languages</title>

	<link rel="stylesheet" type = "text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" type="text/css" href="css/styleLogin.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		
	</head>
	<body>
		<div class="container-fluid">
			<h1>All Languages</h1>
			<table class=" table table-dark table-striped table-bordered col-md-8 offset-md-2 table-hover ">
			    <thead>
			        <tr>
			            <th>Language</th> 
			            <th>Creator</th>
			            <th>Current Version</th>
			            <th>action</th>
			        </tr>
			    </thead>
			    <tbody>
			        	<c:forEach items="${langs}" var="lang" varStatus="loop">
						<tr>    
						    <td><a href="/languages/${lang.id}"><c:out value="${lang.name}"/></a> </td>
						    <td><c:out value="${lang.creator}"/></td>
						    <td><c:out value="${lang.currentVersion}"/></td>
						    <td> <a href="/languages/${lang.id}/edit">Edit</a>
						    		<form class="linkButt" action="/language/${lang.id}" method="POST" >
						    		<input type="hidden" name="_method" value="delete">
						    		<input type="submit"  class="btn btn-link" value = Delete>
						    		</form>
						    </td>
						</tr>
						</c:forEach>
			    </tbody>
			</table>
			<div class = "addForm">
				<form:form method="POST" action="/languages" modelAttribute="language">
	    		<p class ="form-group">
			        <form:label path="name" id="name">Name</form:label>
			        <form:errors path="name"/>
			        <form:input  class = "form-control" path="name"/>
		   		</p>
		    	<p class = "form-group">
			        <form:label path="creator" id="creator">Creator</form:label>
			        <form:errors path="creator"/>
			        <form:input class ="form-control" path="creator"/>
			   	</p>
		    	<p class = "form-group">
			        <form:label path="currentVersion" id="version">Current Version</form:label>
			        <form:errors path="currentVersion"/>
			        <form:input class = "form-control" path="currentVersion"/>
		   		</p>
		    	<input type="submit" value="Add Language"/> 
				</form:form>
			</div>
		</div>
	</body>	
</html>