<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>\
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book</title>
</head>
	<body>
		<div>
			<a href="/books">Back to Books</a>
			<h1><c:out value="${book.title}"/></h1>
			<p>Description: <c:out value="${book.description}"/></p>
			<p>Language: <c:out value="${book.language}"/></p>
			<p>Number of pages: <c:out value="${book.numberOfPages}"/></p>
			<a href="/books/edit/${book.id}">Edit Book</a>
			<form action="/books/delete/${book.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete">
			</form>
		</div>
	</body>
</html>