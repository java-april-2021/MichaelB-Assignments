<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h1>All Books</h1>
	<table>
	    <thead>
	        <tr>
	            <th>Title</th>
	            <th>Description</th>
	            <th>Language</th>
	            <th>Number of Pages</th>
	        </tr>
	    </thead>
	    <tbody>
	        	<c:forEach items="${books}" var="book" varStatus="loop">
				<tr>    
			    <td><a href="/books/${book.id}"><c:out value="${book.title}"/></a> </td>
			    <td><c:out value="${book.description}"/></td>
			    <td><c:out value="${book.language}"/></td>
			    <td><c:out value="${book.numberOfPages}"/></td>
			    <td><form action="/books/delete/${book.id}" method="POST"><input type="hidden" name="_method" value="delete"><input type="submit" value = delete></form></td>
				</tr>
				</c:forEach>
	    </tbody>
	</table>
	<a href="/books/new">New Book</a>
</body>
</html>